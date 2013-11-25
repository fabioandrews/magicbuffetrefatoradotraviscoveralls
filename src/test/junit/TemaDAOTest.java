package junit;

import static org.junit.Assert.*;

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
		//tema com mais de 45 caracteres
		Tema t = new Tema("mlp", "wfckljkscjcjcsdljdvlijsdlkjbdlkbsjdkbsjkldjbkldksdljbdkbdjbdlkbsdklsbdjbkljbkljbdskjbsdlkbdjklbdsjbkdljblkjbdslkjbsdklsbdljbslkjbslkjbslkjsbdkldbjskdbjkbdsljkjbdkljblkjbklbsjkbsljlbskjlbskjbdsjjblkbdjlksblkjbslkj");
		
		boolean conseguiuCriar = temaDAO.criar(t);
		
		assertEquals(conseguiuCriar,false);
	}
	
	@Test
	public void testBuscarPorTemaValido() 
	{
		String idTemaMoranguinho = "43";
		Tema t = (Tema) temaDAO.buscar(idTemaMoranguinho);
		assertEquals(t.getTnome(),"Moranguinho");
	}
	
	@Test
	public void testBuscarPorTemaInvalido() 
	{
		String idTemaInvalido =  "wfckljkscjcjcsdljdvlijsdlkjbdlkbsjdkbsjkldjbkldksdljbdkbdjbdlkbsdklsbdjbkljbkljbdskjbsdlkbdjklbdsjbkdljblkjbdslkjbsdklsbdljbslkjbslkjbslkjsbdkldbjskdbjkbdsljkjbdkljblkjbklbsjkbsljlbskjlbskjbdsjjblkbdjlksblkjbslkj";
		Tema t = (Tema) temaDAO.buscar(idTemaInvalido);
		
		assertEquals(t.getIdTema(),null);
		assertEquals(t.getTnome(),null);
	}

}
