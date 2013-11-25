package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import entidadesDAO.TemaDAO;
import InterfaceDAO.DAOComBuscaMultiplaInterface;

public class DAOComBuscaMultiplaInterfaceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() 
	{
		DAOComBuscaMultiplaInterface temaDAO = new TemaDAO();
		ArrayList<Object> resultado = temaDAO.buscar();
		assertNotNull(resultado);
	}
}
