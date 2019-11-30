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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author lucas
 */
public class MoradorDao {

    private String Comando;//comando sql
    private PreparedStatement ps;//preparando o ambiente para o comando sql (intermediario)
    private ResultSet rs;// armazenar os dados do banco da aplicação (apenas nas consultas)
    private Connection Conecta;

    //metodos
    public void cadastrar(Morador morador) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "insert into Morador (Mocpf,Monome,Mofone,Moapnumero) values (?,?,?,?);";
        ps = Conecta.prepareStatement(Comando);

        ps.setString(1, morador.getmocpf());
        ps.setString(2, morador.getmonome());
        ps.setString(3, morador.getmofone());
        ps.setString(4, morador.getapartemento().getapnumero());

        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Morador morador) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "update morador set monome = ?, mofone = ?, moapnumero = ? where mocpf=?;";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, morador.getmonome());
        ps.setString(2, morador.getmonome());
        ps.setString(3, morador.getapartemento().getapnumero());
        ps.setString(4, morador.getmocpf());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void excluir(String id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "delete from morador where mocpf=?;";
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, id);
        ps.execute();

        FabricaConexao.FecharConexao();
    }

    public List<Morador> listarTodos(String nome) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from Morador \n"
                + "join Apartamento on Mocpf=Apnumero \n"
                + "join Bloco on Apblid=Blid where mocpf like ?";

        //select * from Modelo\n" +
        //        "join Fabricante on Facnpj=Mofacnpj where Modesc like ? \n" +
        //         "limit 5"
        ps = Conecta.prepareStatement(Comando);
        ps.setString(1, nome + "%");
        rs = ps.executeQuery();

        List<Morador> lista = new ArrayList<>();
        while (rs.next()) {
            Morador morador = new Morador();

            morador.setmocpf(rs.getString("Mocpf"));
            morador.setmonome(rs.getString("Monome"));
            morador.setmofone(rs.getString("Mofone"));

            Apartamento apartamento = new Apartamento();

            apartamento.setapnumero(rs.getString("Apnumero"));
            apartamento.setapandar(rs.getString("Apandar"));
            apartamento.setapandar(rs.getString("Apdispo"));

            morador.setapartemento(apartamento);

            Bloco bloco = new Bloco();

            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));

            apartamento.setbloco(bloco);

            lista.add(morador);

        }

        FabricaConexao.FecharConexao();
        return lista;

    }

    public List<Morador> listarTodos() throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from Morador \n"
                + "join Apartamento on Mocpf=Apnumero \n"
                + "join Bloco on Apblid=Blid";

        //select * from Modelo\n" +
        //        "join Fabricante on Facnpj=Mofacnpj where Modesc like ? \n" +
        //         "limit 5"
        ps = Conecta.prepareStatement(Comando);
        rs = ps.executeQuery();

        List<Morador> lista = new ArrayList<>();
        while (rs.next()) {
            Morador morador = new Morador();

            morador.setmocpf(rs.getString("Mocpf"));
            morador.setmonome(rs.getString("Monome"));
            morador.setmofone(rs.getString("Mofone"));

            Apartamento apartamento = new Apartamento();

            apartamento.setapnumero(rs.getString("Apnumero"));
            apartamento.setapandar(rs.getString("Apandar"));
            apartamento.setapandar(rs.getString("Apdispo"));

            morador.setapartemento(apartamento);

            Bloco bloco = new Bloco();

            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));

            apartamento.setbloco(bloco);

            lista.add(morador);

        }

        FabricaConexao.FecharConexao();
        return lista;

    }

    public Morador buscar(String cpf) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from Morador \n"
                + "join Apartamento on Mocpf=Apnumero \n"
                + "join Bloco on Apblid=Blid where mocpf = ?";
        ps = Conecta.prepareStatement(Comando);

        ps.setString(1, cpf);
        rs = ps.executeQuery();

        Morador morador = new Morador();

        if (rs.next()) {

            morador.setmocpf(rs.getString("Mocpf"));
            morador.setmonome(rs.getString("Monome"));
            morador.setmofone(rs.getString("Mofone"));

            Apartamento apartamento = new Apartamento();

            apartamento.setapnumero(rs.getString("Apnumero"));
            apartamento.setapandar(rs.getString("Apandar"));
            apartamento.setapandar(rs.getString("Apdispo"));
            System.out.println("1");
            morador.setapartemento(apartamento);
            System.out.println("1");
            Bloco bloco = new Bloco();
            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));
            System.out.println("1");
            apartamento.setbloco(bloco);

        }

        FabricaConexao.FecharConexao();
        //System.out.println("Usuario Dao:" + usuario.getusnome());
        return morador;

    }

    public void relatorio() throws FileNotFoundException, SQLException {

        Conecta = FabricaConexao.Conectar();
        Comando = "select * from Morador \n"
                + "join Apartamento on Mocpf=Apnumero \n"
                + "join Bloco on Apblid=Blid";

        ps = Conecta.prepareStatement(Comando);
        rs = ps.executeQuery();

        List<Morador> lista = new ArrayList<>();
        while (rs.next()) {
            Morador morador = new Morador();

            morador.setmocpf(rs.getString("Mocpf"));
            morador.setmonome(rs.getString("Monome"));
            morador.setmofone(rs.getString("Mofone"));

            Apartamento apartamento = new Apartamento();

            apartamento.setapnumero(rs.getString("Apnumero"));
            apartamento.setapandar(rs.getString("Apandar"));
            apartamento.setapandar(rs.getString("Apdispo"));

            morador.setapartemento(apartamento);

            Bloco bloco = new Bloco();

            bloco.setblid(rs.getString("blid"));
            bloco.setblnumero(rs.getString("blnumero"));
            bloco.setblrua(rs.getString("blrua"));

            apartamento.setbloco(bloco);

            lista.add(morador);

        }

        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\lucas\\Downloads\\Moradores_Cadastrados.pdf"));
            document.open();
            document.add(new Paragraph("Lista de Moradores Cadastrados\n\n"));
            for (Morador m : lista) {
                document.add(new Paragraph("\n"
                        + "Morador: " + m.getmonome() + "\n"
                        + "CPF: " + m.getmocpf() + "\n"
                        + "Telefone: " + m.getmofone() + "\n"
                        + "Apartamento: " + m.getapartemento().getapnumero() + "\n"
                        + "Numero: " + m.getapartemento().getapnumero() + "\n"
                        + "Bloco: " + m.getapartemento().getbloco().getblid() + "\n"
                ));
            }
            document.add(new Paragraph("Sistema de Lucas Vieira"));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());

        }
        document.close();

        try {
            Desktop.getDesktop().open(new File("C:\\Users\\lucas\\Downloads\\Moradores_Cadastrados.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(MoradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
