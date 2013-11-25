package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controler.Item;
import controler.Pacote;
import entidadesDAO.ItemDAO;
import InterfaceDAO.InterfaceItemDAO;

public class InterfaceItemDaoTest {

	InterfaceItemDAO itemDao;
	@Before
	public void setUp() throws Exception {
		itemDao = new ItemDAO();
	}

	@Test
	public void testBuscarItemPorNome()
	{
		Item itemBuscar = new Item();
		itemBuscar.setIdItem("862868662");
		itemBuscar.setNomeItem("cupcakes");
		itemBuscar.setQuantidadeTotal(20);
		itemBuscar.setPrecoUnidade(new Float(100.00));
		itemDao.criar(itemBuscar);//eu vou adicionar esse para ter algo para pegar
		
		Item itemAchado = itemDao.buscarNome("cupcakes");
		
		itemDao.remover(itemBuscar);//para futuros testes
		if(itemAchado == null || itemAchado.getNomeItem().compareTo("cupcakes") != 0)
		{
			fail("buscar item por nome nao estah funcionando");
		}
		
	}
	
	@Test
	public void testBuscarItensDoPacoteSqlInjection()
	{
		Pacote pacoteBuscar = new Pacote();
		pacoteBuscar.setPacoteNome("()(87722e71'''''&=true");
		ArrayList<Item> itensPacote = itemDao.buscarItensPacote(pacoteBuscar);
		if(itensPacote != null)
		{
			fail("buscar itens do pacote funciona com sql injection");
		}
		
	}
	
	

}
