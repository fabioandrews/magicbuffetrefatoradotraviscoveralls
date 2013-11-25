package InterfaceDAO;

import java.util.ArrayList;

import controler.Pessoa;

public interface InterfacePessoaDAO extends GenericDAOInterface 
{
	public ArrayList<Pessoa> buscarPessoas(String tipo);
	public ArrayList<Pessoa> buscarPessoaNome(String nome);

}
