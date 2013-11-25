package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controler.Pessoa;

public class PessoaTest {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@Test
	public void testCriarPessoaConstrutorImenso() 
	{
		Pessoa p = new Pessoa("00772544492", 3034904, "59022250", "rua dom jose tomaz", "tirol", 
	    		"91524459",1051, "fabio andrews", "CLIENTE", "natal");
		assertNotNull(p);
	}
	
	@Test
	public void testGetStringGerenteEMonitor() 
	{
		String gerente = Pessoa.getStringGerente();
		String monitor = Pessoa.getStringMonitor();
		
		assertEquals(gerente,"GERENTE");
		assertEquals(monitor,"MONITOR");
		
	}

}
