package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controler.Localizacao;
import entidadesDAO.LocalizacaoDAO;

public class LocalizacaoDAOTest 
{
	private LocalizacaoDAO localizacaoDAO;

	@Before
	public void setUp() throws Exception 
	{
		localizacaoDAO = new LocalizacaoDAO();
		
		Localizacao l = new Localizacao("tirol", "59022250", "dom jose tomaz", 1051, "natal", "59022250");
		localizacaoDAO.remover(l);
	}

	@Test
	public void testCriarLocalizacaoValida() 
	{
		Localizacao l = new Localizacao();
		l.setBairro("tirol");
		l.setCEP("59022250");
		l.setCidade("natal");
		l.setIdLocalizacao("59022250");
		l.setNumero(1051);
		l.setRua("dom jose tomaz");
		
		boolean conseguiuCriar = localizacaoDAO.criar(l);
		assertEquals(conseguiuCriar,true);
	}
	
	@Test
	public void testCriarLocalizacaoInvalida() 
	{
		Localizacao l = new Localizacao();
		l.setBairro("tirol");
		l.setCEP("59022250");
		l.setCidade("natal");
		l.setIdLocalizacao("59022250");
		l.setNumero(1051);
		l.setRua("abababababbababbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		boolean conseguiuCriar = localizacaoDAO.criar(l);
		assertEquals(conseguiuCriar,false);
	}
	
	
	@Test
	public void testBuscar2() 
	{
		Localizacao localizacaoMaxId = localizacaoDAO.buscar2();
		if(localizacaoMaxId.getCidade() == null)
		{
			fail("nenhuma localizacao maxima achada");
		}
	}
	
	@Test
	public void testBuscarLocalizacaoValida() 
	{
		Localizacao l = new Localizacao();
		l.setBairro("tirol");
		l.setCEP("59022250");
		l.setCidade("natal");
		l.setIdLocalizacao("59022250");
		l.setNumero(1051);
		l.setRua("dom jose tomaz");
		
		boolean conseguiuCriar = localizacaoDAO.criar(l);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar localizacao em testBuscarLocalizacaoValida");
		}
		else
		{
			Localizacao localizacaoAchada = (Localizacao) localizacaoDAO.buscar(l.getCEP());
			assertEquals(localizacaoAchada.getCEP(),"59022250");
		}
	}
	
	@Test
	public void testBuscarLocalizacaoInvalida() 
	{
			Localizacao localizacaoAchada = (Localizacao) localizacaoDAO.buscar("()(87722e71'''''&=true");
			
			assertEquals(localizacaoAchada.getCidade(),null);
	}
	
	@Test
	public void testAtualizarLocalizacaoValida() 
	{
		Localizacao l = new Localizacao();
		l.setBairro("tirol");
		l.setCEP("59022250");
		l.setCidade("natal");
		l.setIdLocalizacao("59022250");
		l.setNumero(1051);
		l.setRua("dom jose tomaz");
		
		boolean conseguiuCriar = localizacaoDAO.criar(l);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar localizacao em testAtualizarLocalizacaoValida");
		}
		else
		{
			l.setCidade("recife");
			boolean conseguiuAtualizar = localizacaoDAO.atualizar(l);
			
			assertEquals(conseguiuAtualizar,true);
		}
	}
	
	@Test
	public void testAtualizarLocalizacaoInvalida() 
	{
		Localizacao l = new Localizacao();
		l.setBairro("tirol");
		l.setCEP("59022250");
		l.setCidade("natal");
		l.setIdLocalizacao("59022250");
		l.setNumero(1051);
		l.setRua("dom jose tomaz");
		
		boolean conseguiuCriar = localizacaoDAO.criar(l);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar localizacao em testAtualizarLocalizacaoValida");
		}
		else
		{
			l.setCidade("abababababbababbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			boolean conseguiuAtualizar = localizacaoDAO.atualizar(l);
			
			assertEquals(conseguiuAtualizar,false);
		}
	}
	
	@Test
	public void testRemoverLocalizacaoValida() 
	{
		Localizacao l = new Localizacao();
		l.setBairro("tirol");
		l.setCEP("59022250");
		l.setCidade("natal");
		l.setIdLocalizacao("59022250");
		l.setNumero(1051);
		l.setRua("dom jose tomaz");
		
		boolean conseguiuCriar = localizacaoDAO.criar(l);
		
		if(conseguiuCriar == false)
		{
			fail("nao conseguiu nem criar localizacao em testRemoverLocalizacaoValida");
		}
		else
		{
			boolean conseguiuRemover = localizacaoDAO.remover(l);
			
			assertEquals(conseguiuRemover,true);
		}
	}
	
	@Test
	public void testBuscarLocalizacao() 
	{
		ArrayList<Object> localizacoes = localizacaoDAO.buscar();
		
		if(localizacoes == null || localizacoes.size() == 0)
		{
			fail("nenhuma localizacao achada em buscar()");
		}
			
	}
	
	

}
