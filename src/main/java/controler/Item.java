/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Item {
    
    private String idItem;
    private String nomeItem;
    private int quantidadeTotal;
    private float precoUnidade;

    public Item(String idItem, String nomeItem, int quantidadeTotal, float precoUnidade)
    {
    	this.idItem = idItem;
    	this.nomeItem = nomeItem;
    	this.quantidadeTotal = quantidadeTotal;
    	this.precoUnidade = precoUnidade;
    }
    
    public Item()
    {
    	
    }
    
    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String NomeItem) {
        this.nomeItem = NomeItem;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public float getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(float precoUnidade) {
        this.precoUnidade = precoUnidade;
    }
}
