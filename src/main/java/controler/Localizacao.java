/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Localizacao {
    
    private String idLocalizacao;
    private String CEP;
    private int numero;
    private String rua;
    private String bairro;
    private String Cidade;

    public Localizacao()
    {
    	
    }
    
    public Localizacao(String bairro, String cep, String rua, int numero, String cidade,String idLocalizacao)
    {
    	this.bairro = bairro;
    	this.CEP = cep;
    	this.rua = rua;
    	this.numero = numero;
    	this.Cidade = cidade;
    	this.idLocalizacao = idLocalizacao;
    }
    public String getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(String idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

}
