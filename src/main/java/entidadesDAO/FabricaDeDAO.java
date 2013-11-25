package entidadesDAO;


import InterfaceDAO.DAOComBuscaMultiplaInterface;
import InterfaceDAO.InterfaceFestaDAO;
import InterfaceDAO.InterfaceItemDAO;
import InterfaceDAO.InterfacePacoteDAO;
import InterfaceDAO.InterfacePessoaDAO;

public class FabricaDeDAO 
{
	public static DAOComBuscaMultiplaInterface criarTemaDAO()
	{
		DAOComBuscaMultiplaInterface dao = new TemaDAO();
		return dao;
	}
	
	public static InterfacePacoteDAO criarPacoteDAO()
	{
		InterfacePacoteDAO dao = new PacoteDAO();
		return dao;
	}
	
	public static InterfaceFestaDAO criarFestaDAO()
	{
		InterfaceFestaDAO dao = new FestaDAO();
		return dao;
	}
	
	public static InterfacePessoaDAO criarPessoaDAO()
	{
		InterfacePessoaDAO dao = new PessoaDAO();
		return dao;
	}
	
	public static DAOComBuscaMultiplaInterface criarLocalizacaoDAO()
	{
		DAOComBuscaMultiplaInterface dao = new LocalizacaoDAO();
		return dao;
	}
	
	public static InterfaceItemDAO criarItemDAO()
	{
		InterfaceItemDAO dao = new ItemDAO();
		return dao;
	}

	public static InterfacePessoaDAO criarGerenteDAO()
	{
		return new GerenteDAO();
	}
	
	
	
}
