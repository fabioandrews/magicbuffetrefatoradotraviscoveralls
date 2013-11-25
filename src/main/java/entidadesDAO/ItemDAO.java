/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;



import InterfaceDAO.InterfaceItemDAO;
import controler.Item;
import controler.Pacote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class ItemDAO extends ConectionDAO implements  InterfaceItemDAO {
    
    private Mensagens mensagem = new Mensagens();

    @Override
    public boolean criar(Object object) {

        String criar = "INSERT INTO item (idItem, nomeItem, quantidadeTotal, precoUnidade)"
                + "VALUES (?,?,?,?)";

        conectar(criar);
        try { 
            Item item = (Item) object;
            pstm.setString(1, item.getIdItem());
            pstm.setString(2, item.getNomeItem());
            pstm.setInt(3, item.getQuantidadeTotal());
            pstm.setFloat(4, item.getPrecoUnidade());

            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException ex) {
        	
            return false;
        }

    }

    @Override
    public Item buscar(String...args) {
        String buscar = "SELECT * FROM item WHERE IdItem LIKE '" + args[0] + "'";
        ResultSet result;
        conectar(buscar);
        Item item = new Item();

        try {
            result = pstm.executeQuery();

            while (result.next()) {

                item.setIdItem(result.getString("idItem"));
                item.setNomeItem(result.getString("nomeItem"));
                item.setQuantidadeTotal(result.getInt("quantidadeTotal"));
                item.setPrecoUnidade(result.getFloat("precoUnidade"));
            }
        } catch (SQLException ex) {
           return null;
        }
        fechar();
        return item;
    }

    
     public Item buscarNome(String nomeItem) {
        String buscar = "SELECT * FROM item WHERE NomeItem LIKE '" + nomeItem + "'";
        ResultSet result;
        conectar(buscar);
        Item item = new Item();

        try {
            result = pstm.executeQuery();

            while (result.next()) {

                item.setIdItem(result.getString("idItem"));
                item.setNomeItem(result.getString("nomeItem"));
                item.setQuantidadeTotal(result.getInt("quantidadeTotal"));
                item.setPrecoUnidade(result.getFloat("precoUnidade"));
            }
        } catch (SQLException ex) {
            return null;
        }
        fechar();
        return item;
    }
    
    
    @Override
    public boolean atualizar(Object object) {

        String atualiza = "UPDATE item SET "
                + "nomeItem = ?,"
                + "quantidadeTotal = ?,"
                + "precoUnidade = ?"
                + "WHERE idItem = ?";

        conectar(atualiza);

        try {
            Item item = (Item) object;
            pstm.setString(1, item.getNomeItem());
            pstm.setInt(2, item.getQuantidadeTotal());
            pstm.setFloat(3, item.getPrecoUnidade());
            pstm.setString(4, item.getIdItem());

            pstm.executeUpdate();
            System.out.println("Item Atualizado");
            fechar();
            return true;
        } catch (SQLException ex) {
        	
            return false;
        }
    }

    @Override
    public boolean remover(Object object) {

        String remover = "DELETE FROM item WHERE idItem = ?";

        conectar(remover);

        try {
            Item item = (Item) object;
            pstm.setString(1, item.getIdItem());
            pstm.execute();
            pstm.close();

            return true;
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Remover um item", ex.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object> buscar() {

        String buscarItens = "SELECT * FROM item ";
        
        ArrayList<Object> itens = new ArrayList<Object>();
        ResultSet result;
        conectar(buscarItens);

        try {
            result = pstm.executeQuery();
            while (result.next()) {
                Item item = new Item();
                item.setIdItem(result.getString("idItem"));
                item.setNomeItem(result.getString("nomeItem"));
                item.setQuantidadeTotal(result.getInt("quantidadeTotal"));
                item.setPrecoUnidade(result.getFloat("precoUnidade"));
                
                itens.add(item);
            }
            return itens;
            
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Buscar um Item", ex.getMessage());
        }
        return null;      
    }
    
     public ArrayList<Item> buscarItensPacote(Pacote pacote) 
     {

        String buscarItens = "SELECT * FROM pacote_contem_item WHERE nomePacote LIKE '" 
                                + pacote.getPacoteNome() + "'";
        
        ArrayList<Item> itens = new ArrayList<Item>();
        
        ResultSet result;
        conectar(buscarItens);

        try {
            result = pstm.executeQuery();
            while (result.next()) {
                
                Item item = new Item();
                item.setIdItem(result.getString("chaveItem"));
                ItemDAO it = new ItemDAO();
                Item i = it.buscar(result.getString("chaveItem"));                        
                item.setNomeItem(i.getNomeItem());
                item.setQuantidadeTotal(i.getQuantidadeTotal());
                item.setPrecoUnidade(i.getPrecoUnidade());
                
                itens.add(item);
            }
            return itens;
            
        } catch (SQLException ex) {
            return null;
        }
            
    }
     
    
    //PAREI AQUI FALTA BOTAR ITEMDAO E ITEMDAOTEST NO REPOSITORIO
    
    
}
