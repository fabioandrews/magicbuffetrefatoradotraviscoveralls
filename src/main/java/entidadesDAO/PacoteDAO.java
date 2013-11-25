/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;



import InterfaceDAO.InterfacePacoteDAO;
import controler.Pacote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**DateDate
 *
 * @author Josiel
 */
public class PacoteDAO extends ConectionDAO implements InterfacePacoteDAO {

    private Mensagens mensagem = new Mensagens();
    
    public void criarItensPacote(Pacote pacote){
          for (String item : pacote.getItensPacote()) {

                String insert = "INSERT INTO pacote_contem_item (chavePacote, chaveItem, nomePacote)"
                        + "VALUES (?,?,?)";
                
             
              try {
                    conectar(insert);                    
                    pstm.setString(1, pacote.getIdPacote());
                    pstm.setString(2, item);
                    pstm.setString(3, pacote.getPacoteNome());
                    pstm.execute();
                    pstm.close();
              } catch (SQLException ex) {
                   System.out.println(ex.getMessage());
              }           
            }
    }
    
    @Override
    public boolean criar(Object object) {
        String criar = "INSERT INTO pacote (IdPacote,NomePacote,PrecoPacote) VALUES(?,?,?)";

        conectar(criar);
        try {           
            Pacote pacote = (Pacote) object;
            pstm.setString(1, pacote.getIdPacote());
            pstm.setString(2, pacote.getPacoteNome());
            pstm.setDouble(3, pacote.getPrecoPacote());            
            pstm.execute();                   
            pstm.close();
            criarItensPacote(pacote);
            return true;
        } catch (SQLException ex) {            
        	System.out.println(ex.getMessage());
            return false;
        }
        
    }

    @Override
    public Object buscar(String...args) {

        String busca = "SELECT * FROM pacote WHERE idPacote LIKE " + args[0];
        ResultSet result;
        Pacote pacote = new Pacote();
        conectar(busca);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                pacote.setIdPacote(result.getString("IdPacote"));
                pacote.setPacoteNome(result.getString("nomePacote"));
                pacote.setPrecoPacote(result.getFloat("precoPacote"));
            }
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        fechar();
        return pacote;
    }
    
    
     
    public Pacote buscarPorNome(String nome) {

        String busca = "SELECT * FROM pacote WHERE nomePacote LIKE '" + nome + "'";
        ResultSet result;
        Pacote pacote = new Pacote();
        conectar(busca);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                pacote.setIdPacote(result.getString("IdPacote"));
                pacote.setPacoteNome(result.getString("nomePacote"));
                pacote.setPrecoPacote(result.getFloat("precoPacote"));
            }
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        fechar();
        return pacote;
    }
    
    

    @Override
    public boolean atualizar(Object object) {

        String atualiza = "UPDATE pacote SET "
                + "nomePacote = ?,"
                + "precoPacote = ?"
                + "WHERE IdPacote = ?";
        conectar(atualiza);
        try {
            Pacote pacote = (Pacote) object;
            pstm.setString(1, pacote.getPacoteNome());
            pstm.setFloat(2, pacote.getPrecoPacote());
            pstm.setString(3, pacote.getIdPacote());
            pstm.executeUpdate();
            fechar();
            return true;
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean remover(Object object) {

        String remover = "DELETE FROM pacote WHERE IdPacote = ?";

        conectar(remover);
        try {
            Pacote pacote = (Pacote) object;
            pstm.setString(1, pacote.getIdPacote());
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object> buscar() {

        String buscapacotes = "SELECT * FROM pacote";
        ArrayList<Object> pacotes = new ArrayList<Object>();
        ResultSet result;
        conectar(buscapacotes);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                Pacote pacote = new Pacote();
                pacote.setIdPacote(result.getString("IdPacote"));
                pacote.setPacoteNome(result.getString("nomePacote"));
                pacote.setPrecoPacote(result.getFloat("precoPacote"));

                pacotes.add(pacote);
            }
            return pacotes;

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        return null;
    }

   
}
