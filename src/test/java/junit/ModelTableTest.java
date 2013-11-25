package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import InterfaceDAO.ModelTable;

public class ModelTableTest {

	@Before
	public void setUp() throws Exception 
	{
	}

	@Test
	public void test() 
	{
		ModelTable m = new ModelTable();
		assertNotNull(m);
	}

}
