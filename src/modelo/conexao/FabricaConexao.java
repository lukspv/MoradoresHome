/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author lucas
 */
public class FabricaConexao {
    
    private static String url = "jdbc:mysql://localhost:3306/moradorhome?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String pass = "1234";
    private static Connection con = null;

    public static Connection Conectar() {
              
         
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(url, user, pass);
           
           System.out.println("Foi Rapaz");
           
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Deu erro meu chapa\n", e.getMessage()+"ADVERTENCIA",0);
        } catch (SQLException e) {
            
        }   
        return con;    
    }
    
    public static void FecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void main(String[] args) {
        FabricaConexao.Conectar();
    }



}
