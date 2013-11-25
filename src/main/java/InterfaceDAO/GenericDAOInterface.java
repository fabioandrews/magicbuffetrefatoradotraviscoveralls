/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

/**
 *
 * @author andreza
 */
public interface GenericDAOInterface {
    
    public boolean criar(Object object);
    public boolean atualizar(Object object);
    public boolean remover(Object object);
    public Object buscar(String... args);
}
