/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import java.sql.Time;


/**
 *
 * @author Josiel
 */
public class Festa {

    private static final String PROVENCAL = "PROVENCAL";
    private static final String NORMAL = "NORMAL";
    private String IdFesta;
    private String pessoaCPF;
    private String tema;
    private String local;
    private String pacote;
    private String dataInicio;
    private String dataFim;
    private Time horaInicio;
    private boolean externo;
    private int quantidadeConvidados; //tres campos separando as idades
    private String estiloFesta;

    public Festa()
    {
    	
    }
    
    public Festa(String pacote, String tema, String estilo, String pessoaCpf, int quantosConvidados, String local, String dataFim, String dataInicio, Time horaInicio, boolean externo)
    {
    	this.pacote = pacote;
    	this.tema = tema;
    	this.estiloFesta = estilo;
    	this.pessoaCPF = pessoaCpf;
    	this.quantidadeConvidados = quantosConvidados;
    	this.local = local;
    	this.dataFim = dataFim;
    	this.dataInicio = dataInicio;
    	this.horaInicio = horaInicio;
    	this.externo = externo;
    	
    }
    public String getIdFesta() {
        return IdFesta;
    }

    public void setIdFesta(String IdFesta) {
        this.IdFesta = IdFesta;
    }

    public String getPessoaCPF() {
        return pessoaCPF;
    }

    public void setPessoaCPF(String pessoaCPF) {
        this.pessoaCPF = pessoaCPF;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPacote() {
        return pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }


    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    public int getQuantidadeConvidados() {
        return quantidadeConvidados;
    }

    public void setQuantidadeConvidados(int quantidadeConvidados) {
        this.quantidadeConvidados = quantidadeConvidados;
    }

    public String getEstiloFesta() {
        return estiloFesta;
    }

    public void setEstiloFesta(String tipoFesta) {
        this.estiloFesta = tipoFesta;
    }
}
