package InterfaceDAO;

import controler.Pacote;

public interface InterfacePacoteDAO extends DAOComBuscaMultiplaInterface{
	public Pacote buscarPorNome(String nome);

}
