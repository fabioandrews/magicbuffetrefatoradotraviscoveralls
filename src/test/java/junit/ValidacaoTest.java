package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controler.Validacao;

public class ValidacaoTest {

	@Before
	public void setUp() throws Exception 
	{
	}

	@Test
	public void testValidacaoTrue() 
	{
		Validacao v = new Validacao();
		boolean cpfValido = v.validarCPF("00772544492");
		assertEquals(cpfValido,false);
	}
	
	@Test
	public void testValidacaoFalse() 
	{
		Validacao v = new Validacao();
		boolean cpfValido = v.validarCPF("0");
		assertEquals(cpfValido,false);
	}

}
