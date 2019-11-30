/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Bloco;

/**
 *
 * @author lucas
 */
public class BlocoDao {

    private String Comando;//comando sql
    private PreparedStatement ps;//preparando o ambiente para o comando sql (intermediario)
    private ResultSet rs;// armazenar os dados do banco da aplicação (apenas nas consultas)
    private Connection Conecta;

    //metodos
    public void cadastrar(Bloco bloco) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "insert into bloco (blid,blnumero,blrua) values (?,?,?);";
        ps = Conecta.prepareStatement(Comando);

        ps.setString(1, bloco.getblid());
        ps.setString(2, bloco.getblnumero());
        ps.setString(3, bloco.getblrua());

        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Bloco bloco) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "update bloco set blnumero = ?, blrua where blid=?;";
        ps = Conecta.prepareStatement(Comando);

        ps.setString(1, bloco.getblnumero());
        ps.setString(2, bloco.getblrua());
        ps.setString(3, bloco.getblid());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void excluir(String id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "delete from bloco where blid=?;";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, id);
        ps.execute();

        FabricaConexao.FecharConexao();
    }

    public List<Bloco> listarTodos() throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from bloco";
        ps = Conecta.prepareStatement(Comando);
        rs = ps.executeQuery();

        List<Bloco> lista = new ArrayList<>();
        while (rs.next()) {
            Bloco bloco = new Bloco();


            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));


            lista.add(bloco);

        }

        FabricaConexao.FecharConexao();
        return lista;

    }

    public Bloco buscar(Bloco usu) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from bloco where blid = ?";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, usu.getblid());
        rs = ps.executeQuery();

        Bloco bloco = null;

        if (rs.next()) {

            bloco = new Bloco();
            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));

        }

        FabricaConexao.FecharConexao();
        //System.out.println("Usuario Dao:" + usuario.getusnome());
        return bloco;

    }
}
