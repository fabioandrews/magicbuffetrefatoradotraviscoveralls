/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import conexao.ConectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Josiel
 */
public abstract class ConectionDAO {

    protected Connection conn;
    protected PreparedStatement pstm;
    private Mensagens mensagem = new Mensagens();
    protected void conectar(String conecta) {

        try {
            conn = new ConectionFactory().getConnection();
            pstm = conn.prepareStatement(conecta);
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao conectar", ex.getMessage());
        }
    }

    protected void fechar() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            mensagem.imprimeErro("Erro ao fechar conexao", e.getMessage());
        }
    }

    
}
