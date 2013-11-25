/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import javax.swing.JOptionPane;

/**
 *
 * @author andreza
 */
public class Mensagens {
    
    public void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg, "Erro critico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}
