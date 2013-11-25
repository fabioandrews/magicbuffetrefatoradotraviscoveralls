package InterfaceDAO;

import java.util.ArrayList;

import controler.Festa;

public interface InterfaceFestaDAO extends DAOComBuscaMultiplaInterface
{
	public ArrayList<Festa> buscarFesta(String data);
	

}
