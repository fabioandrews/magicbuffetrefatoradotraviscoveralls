/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import controler.Gerente;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO {

   private Mensagens mensagem = new Mensagens();
   
    @Override
    public boolean criar(Object object) {
        
        String sql = "INSERT INTO gerente(Login,Senha)" + "VALUES (?,?)";
        try {
            Gerente gerente = (Gerente) object;
            conectar(sql);

            pstm.setString(1, gerente.getLogin());
            pstm.setString(2, gerente.getSenha());
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException ex) {
            //mensagem.imprimeErro("Erro ao Cadastrar as informacoes do Gerente", ex.getMessage());
            ex.printStackTrace();
        	fechar();
            return false;
        }

    }
    
    @Override
    public Object buscar(String...args){
        String sql = "SELECT * FROM gerente WHERE Login LIKE '" + args[0] + "'"; 
        conectar(sql);
        Gerente gerente = new Gerente();
        try {
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                gerente.setSenha(result.getString("Senha"));
                gerente.setLogin(result.getString("Login"));                
            }
            
        } catch (SQLException ex) {
            
            return null;
        }   
        fechar();
        return gerente;
    }
    
    @Override
    public boolean remover(Object object) {

        String sql = "DELETE FROM gerente WHERE login = ?";
        conectar(sql);

        try {
            Gerente gerente = (Gerente) object;
            pstm.setString(1, gerente.getLogin());
            pstm.execute();
            pstm.close();
            System.out.println("Gerente removido com sucesso:" + gerente.getLogin());
            return true;
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Remover Gerente", ex.getMessage());
            return false;
        }
    }

}
