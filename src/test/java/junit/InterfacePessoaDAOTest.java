package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import controler.Pessoa;
import InterfaceDAO.InterfacePessoaDAO;
import entidadesDAO.PessoaDAO;

public class InterfacePessoaDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBuscarPessoas() 
	{
		InterfacePessoaDAO interfacePessoa = new PessoaDAO();
		ArrayList<Pessoa> pessoas = interfacePessoa.buscarPessoas("CLIENTE");
		
		assertNotNull(pessoas);
	}
	
	@Test
	public void testBuscarPessoaNome() 
	{
		InterfacePessoaDAO interfacePessoa = new PessoaDAO();
		ArrayList<Pessoa> pessoas = interfacePessoa.buscarPessoaNome("Joao Vinaud");
		
		assertNotNull(pessoas);
	}

}
