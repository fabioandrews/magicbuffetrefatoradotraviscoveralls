/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Josiel
 */
public class ConectionFactory {
   
    Connection connection = null;
    
   public Connection getConnection() {
        try {
            String url = "jdbc:mysql://127.0.0.1/projetobd"; //+ serverName + "/" + mydatabase;  
            String username = "root";        //nome do usuario do BD        
            String password = "";      //senha de acesso  
            //System.out.println("Conectando ao BD");
            
            connection =  DriverManager.getConnection(url, username, password);
            return connection;
            
        } catch (SQLException e) {
            System.err.println("Nao foi possivel se conectar ao Banco de Dados");
            throw new RuntimeException(e);
        }    
    }
   
    public static void main(String[] args) {
        
        Connection connection = new ConectionFactory().getConnection();
        System.out.println("Conexao aberta");
    }
}


