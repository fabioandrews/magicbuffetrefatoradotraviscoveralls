/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Pessoa {
    
    private static String CLIENTE = "CLIENTE";
    private static String GERENTE = "GERENTE";
    private static String MONITOR = "MONITOR";
          

    private String cpf;
    private String gerenteLogin;
    private String Pnome;
    private int rg;
    private String rua;
    private int numero;
    private String bairro;
    private String tipoPessoa;
    private String cep;
    private String telefone;
    private String cidade;

    public Pessoa()
    {
    	
    }
    
    public Pessoa(String cpf, int rg, String gerenteLogin, String cep, String rua, String bairro, 
    		String telefone,int numero, String Pnome, String tipoPessoa, String cidade)
    {
    	this.cpf = cpf;
    	this.rg = rg;
    	this.gerenteLogin = gerenteLogin;
    	this.cep = cep;
    	this.rua = rua;
    	this.bairro = bairro;
    	this.telefone = telefone;
    	this.numero = numero;
    	this.Pnome = Pnome;
    	this.tipoPessoa = tipoPessoa;
    	this.cidade = cidade;
    }
    
    public Pessoa(String cpf, int rg, String cep, String rua, String bairro, 
    		String telefone,int numero, String Pnome, String tipoPessoa, String cidade)
    {
    	new Pessoa(cpf, rg, "", cep, rua, bairro, telefone, numero, Pnome, tipoPessoa, cidade);
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGerenteLogin() {
        return gerenteLogin;
    }

    public void setGerenteLogin(String gerenteLogin) {
        this.gerenteLogin = gerenteLogin;
    }
       
    public String getPnome() {
        return Pnome;
    }

    public void setPnome(String Pnome) {
        this.Pnome = Pnome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

	public static String getStringCliente() {
		return CLIENTE;
	}

	public static String getStringGerente() {
		return GERENTE;
	}

	public static String getStringMonitor() {
		return MONITOR;
	}
    
    
}
