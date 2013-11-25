/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Tema {               
    private String idTema;
    private String Tnome;

    public Tema()
    {
    	
    }
    
    public Tema(String idTema, String nomeTema)
    {
    	this.idTema = idTema;
    	this.Tnome = nomeTema;
    }
    
    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }

    public String getTnome() {
        return Tnome;
    }

    public void setTnome(String Tnome) {
        this.Tnome = Tnome;
    }
    
    
    
    
}
