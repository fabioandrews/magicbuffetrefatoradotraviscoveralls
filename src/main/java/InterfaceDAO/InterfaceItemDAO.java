package InterfaceDAO;

import java.util.ArrayList;

import controler.Item;
import controler.Pacote;

public interface InterfaceItemDAO extends DAOComBuscaMultiplaInterface {
	public Item buscarNome(String nomeItem);
	public ArrayList<Item> buscarItensPacote(Pacote pacote);
}
