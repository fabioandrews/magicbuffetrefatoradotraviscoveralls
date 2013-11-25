/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Gerente extends Pessoa{
    
    private String senha;
    private String login;
    
    public Gerente()
    {
    	
    }
    
    public Gerente(String cpf, int rg, String gerenteLogin, String cep, String rua, String bairro, 
    		String telefone,int numero, String Pnome, String tipoPessoa, String cidade, String senha, String login)
    {
    	super(cpf, rg, gerenteLogin, cep, rua, bairro, telefone, numero, Pnome, tipoPessoa, cidade);
    	this.senha = senha;
    	this.login = login;
    }
    
    public Gerente(String login, String senha)
    {
    	this.login = login;
    	this.senha = senha;
    }
   

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }      
    
    
}
