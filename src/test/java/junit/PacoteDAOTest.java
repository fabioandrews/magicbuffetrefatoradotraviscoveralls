package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import controler.Pacote;
import entidadesDAO.PacoteDAO;

public class PacoteDAOTest 
{
	PacoteDAO pacoteDAO;

	@Before
	public void setUp() throws Exception 
	{
		pacoteDAO = new PacoteDAO();
		
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote("99999", "pacotaoSupimba", new Float(30.0), itensPacote);
		pacoteDAO.remover(p);
	}

	@Test
	public void testCriarPacoteValido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("pacotaoSupimba");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		
		assertEquals(conseguiuCriar,true);
	}
	
	@Test
	public void testCriarPacoteInvalido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("tirolaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		assertEquals(conseguiuCriar,false);
	}
	
	@Test
	public void testCriarItensPacoteNaoValido() 
	{
		//os itens vao estao validos, mas o pacote nao
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("tirolaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		p.setPrecoPacote(new Float(30.0));
		
		pacoteDAO.criarItensPacote(p);
		
		Pacote pacoteAchado = (Pacote) pacoteDAO.buscar(p.getIdPacote());
		
		if(pacoteAchado.getIdPacote() == null)
		{
			//teste funcionou
		}
		else
		{
			fail("teste criarItensPacoteNaoValido nao funcionou porque o pacote foi criado");
		}
	}
	
	@Test
	public void testBuscarPacoteValido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("pacotaoSupimba");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar um pacote no testBuscarPacoteValido");
		}
		else
		{
			Pacote pacoteAchado = (Pacote) pacoteDAO.buscar(p.getIdPacote());
			
			assertEquals(pacoteAchado.getPacoteNome(),"pacotaoSupimba");
		}
	}
	
	@Test
	public void testBuscarPacoteInvalido() 
	{
		
		Pacote pacoteAchado = (Pacote) pacoteDAO.buscar("()(87722e71'''''&=true");
			
		assertEquals(pacoteAchado.getPacoteNome(), null);
	}
	
	@Test
	public void testBuscarPacotePorNomeValido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("pacotaoSupimba");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar um pacote no testBuscarPacotePorNomeValido");
		}
		else
		{
			Pacote pacoteAchado = (Pacote) pacoteDAO.buscarPorNome(p.getPacoteNome());
			
			assertEquals(pacoteAchado.getIdPacote(),"99999");
		}
	}
	
	@Test
	public void testBuscarPacotePorNomeInvalido() 
	{
		
		Pacote pacoteAchado = (Pacote) pacoteDAO.buscarPorNome("()(87722e71'''''&=true");
		assertEquals(pacoteAchado.getIdPacote(),null);
	}
	
	
	@Test
	public void testAtualizarPacoteValido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("pacotaoSupimba");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar um pacote no testAtualizarPacoteValido");
		}
		else
		{
			p.setPacoteNome("pacoteXumbregau");
			boolean pacoteAtualizado = pacoteDAO.atualizar(p);
			
			assertEquals(pacoteAtualizado,true);
		}
	}
	
	@Test
	public void testAtualizarPacoteInValido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("pacotaoSupimba");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar um pacote no testAtualizarPacoteInvalido");
		}
		else
		{
			p.setPacoteNome("tirolaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			boolean pacoteAtualizado = pacoteDAO.atualizar(p);
			
			assertEquals(pacoteAtualizado,false);
		}
	}
	
	
	@Test
	public void testRemoverPacoteValido() 
	{
		ArrayList<String> itensPacote = new ArrayList<String>();
		itensPacote.add("9090");
		
		Pacote p = new Pacote();
		p.setIdPacote("99999");
		p.setItensPacote(itensPacote);
		p.setPacoteNome("pacotaoSupimba");
		p.setPrecoPacote(new Float(30.0));
		
		boolean conseguiuCriar = pacoteDAO.criar(p);
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar um pacote no testRemoverPacoteValido");
		}
		else
		{
			
			boolean pacoteRemovido = pacoteDAO.remover(p);
			
			assertEquals(pacoteRemovido,true);
		}
	}
	
	@Test
	public void testBuscar() 
	{
		ArrayList<Object> pacotes = pacoteDAO.buscar();
		
		if(pacotes == null)
		{
			fail("testBuscar falhou porque retornou um arraylist nulo");
		}
	}
	
	


}
