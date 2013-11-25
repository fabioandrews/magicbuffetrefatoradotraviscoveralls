/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;


import InterfaceDAO.InterfaceFestaDAO;
import controler.Festa;
import controler.Pacote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Josiel
 */
public class FestaDAO extends ConectionDAO implements InterfaceFestaDAO {

        
    
    Mensagens mensagem = new Mensagens();
    
    @Override
    public Object buscar(String... args) {

        String buscarFesta = "SELECT * FROM festa WHERE IdFesta LIKE '" + args[0] + "'";

        conectar(buscarFesta);
        Festa festa = new Festa();
        ResultSet result;
        try {
            result = pstm.executeQuery();

            while (result.next()) {
                    festa = this.converterResultadoConsultaEmObjetoFesta(result);
            }

        } catch (SQLException ex) {
            return null;
        }

        fechar();
        return festa;
    }
                     
    public ArrayList<Festa> buscarFesta(String data) {
        /**/
        String buscarFestas = "SELECT * FROM festa WHERE datainicio = '" + data + "'";
        ArrayList<Festa> festas = new ArrayList<Festa>();
        ResultSet result;
        
        conectar(buscarFestas);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                    Festa festa = this.converterResultadoConsultaEmObjetoFesta(result);
                festas.add(festa);
            }
        } catch (SQLException ex) {
            return null;
        }
        
        return festas;
    }

   @Override
    public ArrayList<Object> buscar() {
        
        String buscarFestas = "SELECT * FROM festa " + ";";
        ArrayList<Object> festas = new ArrayList<Object>();
        ResultSet result;
        
        conectar(buscarFestas);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                    Festa festa = this.converterResultadoConsultaEmObjetoFesta(result);
                festas.add(festa);
            }
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Buscar Todas as Festa", ex.getMessage());
        }
       
        
        return festas;
    }

   private Festa converterResultadoConsultaEmObjetoFesta(ResultSet result) throws SQLException
   {
           Festa festa = new Festa();

       festa.setIdFesta(result.getString("IdFesta"));
       festa.setPessoaCPF(result.getString("clienteCPF"));
       festa.setTema(result.getString("idTema"));
       festa.setLocal(result.getString("localizacaoCEP"));
       festa.setPacote(result.getString("idPacote"));
       festa.setDataInicio(result.getString("datainicio"));
       festa.setDataFim(result.getString("dataFim"));
       festa.setHoraInicio(result.getTime("horaInicio"));
       festa.setExterno(result.getBoolean("externo"));
       festa.setQuantidadeConvidados(result.getInt("quantidadeconvidados"));
       festa.setEstiloFesta(result.getString("estiloFesta"));
       
       return festa;
   }
   
    @Override
    public boolean criar(Object object) {
             String criarFesta = "INSERT INTO festa VALUES(?,?,?,?,?,?,?,?,?,?,?)";


        
        try {
            Festa festa = (Festa) object;
            conectar(criarFesta);
            conn.setAutoCommit(false);
            pstm.setString(1, festa.getIdFesta());
            pstm.setString(2, festa.getPessoaCPF());
            pstm.setString(3, festa.getTema());
            pstm.setString(4, festa.getLocal());
            //pstm.setString(5, festa.getPacote());
            
            //vou buscar no BD por um pacote com esse nome para obter seu ID
            PacoteDAO buscaPacotes = new PacoteDAO();
            Pacote pacote = buscaPacotes.buscarPorNome(festa.getPacote());
            String idPacote = pacote.getIdPacote();
            
            pstm.setString(5, idPacote);
            pstm.setString(6, festa.getDataInicio());
            pstm.setString(7, festa.getDataFim());
            pstm.setTime(8, festa.getHoraInicio());
            pstm.setBoolean(9, festa.isExterno());
            pstm.setInt(10, festa.getQuantidadeConvidados());
            pstm.setString(11, festa.getEstiloFesta());
            pstm.execute();
            conn.commit();
            fechar();
            return true;

        } catch (SQLException ex) {
            try {
                    ex.printStackTrace();
                conn.rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(FestaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }
        }
    }

    @Override
    public boolean atualizar(Object object) {
          String atualiza = "UPDATE festa SET "
                + "clienteCPF = ?,"
                + "idTema = ?,"
                + "localizacaoCEP = ?,"
                + "idPacote = ?,"
                + "datainicio = ?,"
                + "dataFim = ?,"
                + "horaInicio = ?,"
                + "externo = ?,"
                + "quantidadeconvidados = ?,"
                + "estiloFesta = ? "
                + "WHERE IdFesta = ?";

        conectar(atualiza);
        try {
            Festa festa = (Festa) object;
            pstm.setString(1, festa.getIdFesta());
            pstm.setString(2, festa.getPessoaCPF());
            pstm.setString(3, festa.getTema());
            pstm.setString(4, festa.getLocal());
            pstm.setString(5, festa.getPacote());
            pstm.setString(6, festa.getDataInicio());
            pstm.setString(7, festa.getDataFim());
            pstm.setTime(8, festa.getHoraInicio());
            pstm.setBoolean(9, festa.isExterno());
            pstm.setInt(10, festa.getQuantidadeConvidados());
            pstm.setString(11, festa.getEstiloFesta());

            pstm.executeUpdate();
            System.out.println("Festa Atualizada");
            fechar();
            return true;

        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean remover(Object object) {
        
        String remover = "DELETE FROM festa WHERE idFesta = ? ";

        conectar(remover);
        try {
            Festa festa = (Festa) object;
            pstm.setString(1, festa.getIdFesta());
            pstm.execute();
            fechar();
            return true;
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Remover Festa", ex.getMessage());
            return false;
        }
    }
    
    


}
