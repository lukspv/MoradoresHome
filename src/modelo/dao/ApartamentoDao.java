/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Apartamento;
import modelo.entidade.Bloco;
import modelo.entidade.Morador;

/**
 *
 * @author lucas
 */
public class ApartamentoDao {

    private String Comando;//comando sql
    private PreparedStatement ps;//preparando o ambiente para o comando sql (intermediario)
    private ResultSet rs;// armazenar os dados do banco da aplicação (apenas nas consultas)
    private Connection Conecta;

    //metodos
    public void cadastrar(Apartamento apartamento) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "insert into apartamento (apnumero,apandar,apdispo,apblid) values (?,?,?,?);";
        ps = Conecta.prepareStatement(Comando);

        ps.setString(1, apartamento.getapnumero());
        ps.setString(2, apartamento.getapandar());
        ps.setString(3, apartamento.getdispo());
        ps.setString(4, apartamento.getbloco().getblid());

        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Apartamento apartamento) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "update apartamento set apandar = ?, apdispo  = ?, apblid = ? where apnumero=?;";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, apartamento.getapandar());
        ps.setString(2, apartamento.getdispo());
        ps.setString(3, apartamento.getbloco().getblid());
        ps.setString(4, apartamento.getapnumero());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void excluir(String id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "delete from apartamento where apnumero=?";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, id);
        ps.execute();

        FabricaConexao.FecharConexao();
    }

    public List<Apartamento> listarTodos() throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from apartamento join bloco on apblid=blid;";
        ps = Conecta.prepareStatement(Comando);
        rs = ps.executeQuery();

        List<Apartamento> lista = new ArrayList<>();
        Apartamento apartamento = new Apartamento();

        while (rs.next()) {

            apartamento.setapnumero(rs.getString("apnumero"));
            apartamento.setapandar(rs.getString("apandar"));
            apartamento.setdispo(rs.getString("apdispo"));

            Bloco bloco = new Bloco();

            bloco.setblid(rs.getString("blid"));

            bloco.setblnumero(rs.getString("blnumero"));

            bloco.setblrua(rs.getString("blrua"));

            apartamento.setbloco(bloco);

            lista.add(apartamento);

        }

        FabricaConexao.FecharConexao();
        //System.out.println("6");
        return lista;

    }

    public List<Apartamento> listarTodos(String numero) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from apartamento join bloco on apblid=blid where"
                + " apnumero like ? limit 5;";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, numero + "%");
        rs = ps.executeQuery();

        List<Apartamento> lista = new ArrayList<>();

        Apartamento apartamento = new Apartamento();
        while (rs.next()) {

            apartamento.setapnumero(rs.getString("apnumero"));
            apartamento.setapandar(rs.getString("apandar"));
            apartamento.setdispo(rs.getString("apdispo"));

            Bloco bloco = new Bloco();

            bloco.setblid(rs.getString("blid"));

            bloco.setblnumero(rs.getString("blnumero"));

            bloco.setblrua(rs.getString("blrua"));

            apartamento.setbloco(bloco);

            lista.add(apartamento);

        }

        FabricaConexao.FecharConexao();

        return lista;

    }

    public Apartamento buscar(String numero) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from apartamento join Bloco on Apblid=Blid where apnumero = ? ";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, numero);
        rs = ps.executeQuery();

        Apartamento apartamento = apartamento = new Apartamento();

        if (rs.next()) {

            apartamento.setapnumero(rs.getString("apnumero"));
            apartamento.setapandar(rs.getString("apandar"));
            apartamento.setdispo(rs.getString("apdispo"));

            Bloco bloco = new Bloco();
            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));

            apartamento.setbloco(bloco);

        }

        FabricaConexao.FecharConexao();
        return apartamento;

    }

    public void relatorio() throws FileNotFoundException, SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from apartamento join bloco on apblid=blid;";
        ps = Conecta.prepareStatement(Comando);
        rs = ps.executeQuery();

        List<Apartamento> lista = new ArrayList<>();

        while (rs.next()) {
            Apartamento apartamento = new Apartamento();
            apartamento.setapnumero(rs.getString("apnumero"));
            apartamento.setapandar(rs.getString("apandar"));
            apartamento.setdispo(rs.getString("apdispo"));

            Bloco bloco = new Bloco();
            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));
            apartamento.setbloco(bloco);

            lista.add(apartamento);
        }

        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\lucas\\Downloads\\Apartamentos_Cadastrados.pdf"));
            document.open();
            document.add(new Paragraph("Lista de Apartamentos Cadastrados\n\n"));
            for (Apartamento m : lista) {

                document.add(new Paragraph("\n"
                        + "Apartamento: " + m.getapnumero() + "\n"
                        + "Numero: " + m.getapandar() + "\n"
                        + "Bloco: " + m.getbloco().getblid() + "\n"
                        + "Disponibiliade: " + m.getdispo()));
            }
            
            document.add(new Paragraph("Sistema de Lucas Vieira"));

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());

        }
        document.close();

        try {
            Desktop.getDesktop().open(new File("C:\\Users\\lucas\\Downloads\\Apartamentos_Cadastrados.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(MoradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
