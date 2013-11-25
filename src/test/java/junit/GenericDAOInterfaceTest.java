package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controler.Pessoa;
import entidadesDAO.PessoaDAO;
import InterfaceDAO.GenericDAOInterface;

public class GenericDAOInterfaceTest {

	@Before
	public void setUp() throws Exception 
	{
		Pessoa p = new Pessoa("00772544492", 3034904, "josiel1nico", "59022250", "rua dom jose tomaz", "tirol", 
                "91524459",1051, "fabio andrews rocha marques", "CLIENTE", "natal");
		GenericDAOInterface pessoaDAO = new PessoaDAO();
		pessoaDAO.remover(p);
	}
	
	@After
	public void tearDown()
	{
		Pessoa p = new Pessoa("00772544492", 3034904, "josiel1nico", "59022250", "rua dom jose tomaz", "tirol", 
                "91524459",1051, "fabio andrews rocha marques", "CLIENTE", "natal");
		GenericDAOInterface pessoaDAO = new PessoaDAO();
		pessoaDAO.remover(p);
	}

	@Test
	public void testBuscar() 
	{
		GenericDAOInterface pessoaDAO = new PessoaDAO();
		Object resposta = pessoaDAO.buscar("21346655","CLIENTE");
		assertNotNull(resposta);
	}
	
	@Test
	public void testCriar() 
	{
		GenericDAOInterface pessoaDAO = new PessoaDAO();
		Pessoa p = new Pessoa("00772544492", 3034904, "josiel1nico", "59022250", "rua dom jose tomaz", "tirol", 
                "91524459",1051, "fabio andrews rocha marques", "CLIENTE", "natal");
		boolean resposta = pessoaDAO.criar(p);
		assertEquals(resposta,true);
	}
	
	@Test
	public void testRemover() 
	{
		GenericDAOInterface pessoaDAO = new PessoaDAO();
		Pessoa p = new Pessoa("00772544492", 3034904, "josiel1nico", "59022250", "rua dom jose tomaz", "tirol", 
                "91524459",1051, "fabio andrews rocha marques", "CLIENTE", "natal");
		boolean resposta = pessoaDAO.criar(p);

		if(resposta == true)
		{
			boolean resposta2 = pessoaDAO.remover(p);
			assertEquals(resposta2,true);
		}
		else
		{
			fail("nao conseguiu nem criar a pessoa para remover em GenericDAOInterfaceTest");
		}
	}
	
	@Test
	public void testAtualizar() 
	{
		GenericDAOInterface pessoaDAO = new PessoaDAO();
		Pessoa p = new Pessoa("00772544492", 3034904, "josiel1nico", "59022250", "rua dom jose tomaz", "tirol", 
                "91524459",1051, "fabio andrews rocha marques", "CLIENTE", "natal");
		boolean resposta = pessoaDAO.criar(p);

		if(resposta == true)
		{
			p.setBairro("marol");
			boolean resposta2 = pessoaDAO.atualizar(p);
			assertEquals(resposta2,true);
		}
		else
		{
			fail("nao conseguiu nem criar a pessoa para atualizar em GenericDAOInterfaceTest");
		}
	}
	

}
