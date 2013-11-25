package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controler.Pessoa;
import entidadesDAO.PessoaDAO;

public class PessoaDAOTest 
{
	PessoaDAO pessoaDAO;
	@Before
	public void setUp() throws Exception 
	{
		pessoaDAO = new PessoaDAO();
		
		Pessoa p = new Pessoa("00772544492", 3034904, "josiel1nico", "59022250", "rua dom jose tomaz", "tirol", 
				"91524459",1051, "fabio andrews rocha marques", "CLIENTE", "natal");
		pessoaDAO.remover(p);
	}

	@Test
	public void testCriarPessoaValida() 
	{
		Pessoa p = new Pessoa();
		p.setBairro("tirol");
		p.setCep("59022250");
		p.setCidade("natal");
		p.setCpf("00772544492");
		p.setGerenteLogin("josiel1nico");
		p.setNumero(1051);
		p.setPnome("fabio andrews rocha marques");
		p.setRg(3034904);
		p.setRua("rua dom jose tomaz");
		p.setTelefone("91524459");
		p.setTipoPessoa("CLIENTE");
		
		boolean criouPessoa = pessoaDAO.criar(p);
		assertEquals(criouPessoa,true);
	}
	
	@Test
	public void testCriarPessoaInvalida() 
	{
		Pessoa p = new Pessoa();
		p.setBairro("tirolaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		p.setCep("59022250");
		p.setCidade("natal");
		p.setCpf("00772544492");
		p.setGerenteLogin("josiel1nico");
		p.setNumero(1051);
		p.setPnome("fabio andrews rocha marques");
		p.setRg(3034904);
		p.setRua("rua dom jose tomaz");
		p.setTelefone("91524459");
		p.setTipoPessoa("CLIENTE");
		
		boolean criouPessoa = pessoaDAO.criar(p);
		assertEquals(criouPessoa,false);
	}
	
	
	@Test
	public void testBuscarPessoaValida() 
	{	
		Pessoa p = (Pessoa) pessoaDAO.buscar("556699999","GERENTE");
		assertEquals(p.getPnome(),"Josiel Silva");
	}
	
	@Test
	public void testBuscarPessoaInvalida() 
	{	
		Pessoa p = (Pessoa) pessoaDAO.buscar("()(87722e71'''''&=true","GERENTE");
		assertEquals(p.getPnome(),null);
	}
	
	@Test
	public void testAtualizarPessoaValida() 
	{	
		Pessoa p = new Pessoa();
		p.setBairro("tirol");
		p.setCep("59022250");
		p.setCidade("natal");
		p.setCpf("00772544492");
		p.setGerenteLogin("josiel1nico");
		p.setNumero(1051);
		p.setPnome("fabio andrews rocha marques");
		p.setRg(3034904);
		p.setRua("rua dom jose tomaz");
		p.setTelefone("91524459");
		p.setTipoPessoa("CLIENTE");
		
		boolean conseguiuCriar = pessoaDAO.criar(p);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar a pessoa para atualizar");
		}
		else
		{
			p.setBairro("conxinxina");
			boolean conseguiuAtualizar = pessoaDAO.atualizar(p);
			assertEquals(conseguiuAtualizar,true);
		}
	}
	
	@Test
	public void testAtualizarPessoaInvalida() 
	{	
		Pessoa p = new Pessoa();
		p.setBairro("tirol");
		p.setCep("59022250");
		p.setCidade("natal");
		p.setCpf("00772544492");
		p.setGerenteLogin("josiel1nico");
		p.setNumero(1051);
		p.setPnome("fabio andrews rocha marques");
		p.setRg(3034904);
		p.setRua("rua dom jose tomaz");
		p.setTelefone("91524459");
		p.setTipoPessoa("CLIENTE");
		
		boolean conseguiuCriar = pessoaDAO.criar(p);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar a pessoa para atualizar");
		}
		else
		{
			p.setBairro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			boolean conseguiuAtualizar = pessoaDAO.atualizar(p);
			assertEquals(conseguiuAtualizar,false);
		}
	}
	
	@Test
	public void testRemoverPessoaValida() 
	{	
		Pessoa p = new Pessoa();
		p.setBairro("tirol");
		p.setCep("59022250");
		p.setCidade("natal");
		p.setCpf("00772544492");
		p.setGerenteLogin("josiel1nico");
		p.setNumero(1051);
		p.setPnome("fabio andrews rocha marques");
		p.setRg(3034904);
		p.setRua("rua dom jose tomaz");
		p.setTelefone("91524459");
		p.setTipoPessoa("CLIENTE");
		
		boolean conseguiuCriar = pessoaDAO.criar(p);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar a pessoa para deletar");
		}
		else
		{
			boolean conseguiuRemover = pessoaDAO.remover(p);
			assertEquals(conseguiuRemover,true);
		}
	}
	
	@Test
	public void testBuscarPessoasValidas() 
	{	
		ArrayList<Pessoa> pessoas = pessoaDAO.buscarPessoas("GERENTE");
		
		if(pessoas == null || pessoas.size() == 0)
		{
			fail("nenhum gerente encontrado, por isso a busca por pessoas validas falhou");
		}
	}
	
	@Test
	public void testBuscarPessoasInvalidas() 
	{	
		ArrayList<Pessoa> pessoas = pessoaDAO.buscarPessoas("()(87722e71'''''&=true");
		
		if(pessoas == null || pessoas.size() == 0)
		{
			
		}
		else
		{
			fail("alguma pessoa invalida foi achada. buscarPessoasInvalidas Falhou");
		}
	}
	
	@Test
	public void testBuscarPessoaNomeValida() 
	{	
		ArrayList<Pessoa> pessoas = pessoaDAO.buscarPessoaNome("Josiel Silva");
		
		if(pessoas.size() == 0)
		{
			fail("josiel silva nao achado, embora ele seja o gerente. BuscarPessoaValida falhou");
		}
	}
	
	@Test
	public void testBuscarPessoaNomeInvalida() 
	{	
		ArrayList<Pessoa> pessoas = pessoaDAO.buscarPessoaNome("()(87722e71'''''&=true");
		
		if(pessoas != null)
		{
			fail("achei pessoa por nome invalida");
		}
	}

}
