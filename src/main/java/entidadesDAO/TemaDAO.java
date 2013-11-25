/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;


import InterfaceDAO.DAOComBuscaMultiplaInterface;
import controler.Tema;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class TemaDAO extends  ConectionDAO implements DAOComBuscaMultiplaInterface {
    
    private Mensagens mensagem = new Mensagens();
    
    @Override
    public boolean criar(Object object) {

        String criar = "INSERT INTO tema (IdTema, Tnome)"
                + "VALUES(?,?)";
        conectar(criar);
        try {
            Tema tema = (Tema) object;
            pstm.setString(1, tema.getIdTema());
            pstm.setString(2, tema.getTnome());            
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Object buscar(String... args) {
        String buscaTema = "SELECT * FROM tema WHERE IdTema LIKE " + args[0];
        ResultSet result;
        Tema tema = new Tema();

        conectar(buscaTema);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                tema.setIdTema(result.getString("IdTema"));
                tema.setTnome(result.getString("Tnome"));  
            
            }

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            
        }
        fechar();
        return tema;
    }
    

    @Override
    public boolean atualizar(Object object) {
        String atualizar = "UPDATE tema SET "
                + "Tnome = ? "                
                + "WHERE IdTema = ?";

        conectar(atualizar);
        try {
            Tema tema = (Tema) object;
            pstm.setString(1, tema.getTnome());
            pstm.setString(2, tema.getIdTema());            

            pstm.executeUpdate();
            System.out.println("Tema atualizado");
            fechar();
            return true;

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            return false;
        }


    }

    @Override
    public boolean remover(Object object) {

        String remove = "DELETE FROM tema WHERE IdTema = ?";
        conectar(remove);
        try {
            Tema tema = (Tema) object;
            pstm.setString(1, tema.getIdTema());
            pstm.execute();
            pstm.close();
            System.out.println("Tema Removido com sucesso:" + tema.getIdTema());
            return true;
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public ArrayList<Object> buscar() {
        
        String BuscaTodos = "SELECT * FROM tema ";
        
        ArrayList<Object> temas = new ArrayList<Object>();
        ResultSet result;
        conectar(BuscaTodos);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                
                Tema tema = new Tema();
                tema.setIdTema(result.getString("IdTema"));
                tema.setTnome(result.getString("Tnome"));                
                
                temas.add(tema);
            }
            return temas;
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }       
        return null;
    }
}
