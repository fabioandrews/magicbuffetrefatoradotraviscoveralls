package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptioDAO.DAOException;

public class DAOExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConstrutorVazio() 
	{
		DAOException d = new DAOException();
		assertNotNull(d);
	}
	
	@Test
	public void testConstrutorNaoVazio() 
	{
		DAOException d = new DAOException("oi");
		assertNotNull(d);
	}

}
