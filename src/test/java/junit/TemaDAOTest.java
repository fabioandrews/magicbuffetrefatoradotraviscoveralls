package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controler.Tema;
import entidadesDAO.TemaDAO;

public class TemaDAOTest 
{
	TemaDAO temaDAO;

	@Before
	public void setUp() throws Exception 
	{
		temaDAO = new TemaDAO();
		
		Tema t = new Tema("mlp","my little pony");
		temaDAO.remover(t);
		
		Tema t2= new Tema();
		t2.setIdTema("llpsy");
		t2.setTnome("lalaloopsy");
		temaDAO.remover(t2);
	}

	
	@Test
	public void testCriarTemaValido() 
	{
		Tema t = new Tema("mlp","my little pony");
		boolean conseguiuCriar = temaDAO.criar(t);
		assertEquals(conseguiuCriar,true);
	}
	
	@Test
	public void testCriarTemaInvalido() 
	{
		Tema t = new Tema("mlp","abababababbababbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		boolean conseguiuCriar = temaDAO.criar(t);
		assertEquals(conseguiuCriar,false);
	}
	
	
	@Test
	public void testBuscarPorTemaValido() 
	{
		String idTemaPica = "21";
		Tema t = (Tema) temaDAO.buscar(idTemaPica);
		assertEquals(t.getTnome(),"Pica-pau");
	}
	@Test
	public void testBuscarPorTemaInvalido() 
	{
		String idTema = "()(87722e71'''''&=true";
		Tema t = (Tema) temaDAO.buscar(idTema);
		assertEquals(t.getTnome(),null);
	}
	
	@Test
	public void atualizarTemaValido() 
	{
		Tema t = new Tema("mlp","my little pony");
		boolean conseguiuCriar = temaDAO.criar(t);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar o tema para atualizar");
		}
		else
		{
			Tema t2 = new Tema("mlp","a amizade eh magica");
			boolean conseguiuAtualizar = temaDAO.atualizar(t2);
			
			assertEquals(conseguiuAtualizar,true);
		}
	}
	
	@Test
	public void atualizarTemaInvalido() 
	{
		Tema t = new Tema("mlp","my little pony");
		boolean conseguiuCriar = temaDAO.criar(t);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar o tema para atualizar");
		}
		else
		{
			Tema t2 = new Tema("mlp","abababababbababbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			boolean conseguiuAtualizar = temaDAO.atualizar(t2);
			
			assertEquals(conseguiuAtualizar,false);
		}
	}
	
	@Test
	public void removerTemaValido() 
	{
		//criarei um tema e depois o removerei
		String idNovoTema = "llpsy";
		String novoTema = "lalaloopsy";
		Tema t = new Tema(idNovoTema,novoTema);
		boolean conseguiuCriar = temaDAO.criar(t);
		
		if(conseguiuCriar == true)
		{
			//vamos remove-lo
			boolean conseguiuRemover = temaDAO.remover(t);
			
			assertEquals(conseguiuRemover,true);
		}
		else
		{
			fail("nao conseguiu criar o tema para deletar");
		}
	}
	
	
	@Test
	public void testBuscarTodosOsTemas() 
	{
		ArrayList<Object> temas = temaDAO.buscar();
		if(temas.size() == 0)
		{
			fail("nao conseguiu pegar nem os temas criados por default");
		}
	}
	
	
	
}
