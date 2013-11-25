/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class Pacote {
    
    private String idPacote;
    private String nomePacote;
    private float precoPacote;
    private ArrayList<String> itensPacote;

    public Pacote()
    {
    	
    }
    
    public Pacote(String idPacote, String nomePacote, float precoPacote, ArrayList<String> itensPacote)
    {
    	this.idPacote = idPacote;
    	this.nomePacote = nomePacote;
    	this.precoPacote = precoPacote;
    	this.itensPacote = itensPacote;
    }
    
    public ArrayList<String> getItensPacote() {
        return itensPacote;
    }

    public void setItensPacote(ArrayList<String> itensPacote) {
        this.itensPacote = itensPacote;
    }
       
    
    public String getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(String idPacote) {
        this.idPacote = idPacote;
    }


    public String getPacoteNome() {
        return nomePacote;
    }

    public void setPacoteNome(String PacoteNome) {
        this.nomePacote = PacoteNome;
    }

    public float getPrecoPacote() {
        return precoPacote;
    }

    public void setPrecoPacote(float precoPacote) {
        this.precoPacote = precoPacote;
    }

}
