package junit;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import view.VerificadorCamposFormulario;

public class VerificadorCamposFormularioTest 
{

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@Test
	public void testCpfEhValidoMenorQue11() 
	{
		boolean cpfValido = VerificadorCamposFormulario.cpfEhValido("003");
	    assertEquals(cpfValido,false);
	}
	
	@Test
	public void testCpfEhValidoCPfInvalido() 
	{
		
		
		boolean cpfValido = VerificadorCamposFormulario.cpfEhValido("14546718749");
	    assertEquals(cpfValido,false);

	}
	
	@Test
	public void testCpfEhValidoCPfValido() 
	{
		boolean cpfValido = VerificadorCamposFormulario.cpfEhValido("00772544492");
		assertEquals(cpfValido,true);
	}
	
	@Test
	public void testCampoNumericoDeValorAte11EhValidoValorVazio()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.campoNumericoDeValorAte11EhValido("", "");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testCampoNumericoDeValorAte11EhValidoValorNaoNumerico()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.campoNumericoDeValorAte11EhValido("hhaja", "");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testCampoNumericoDeValorAte11EhValidoAlgarismosMenorQueZero()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.campoNumericoDeValorAte11EhValido("-1", "");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testCampoNumericoDeValorAte11EhValidoValorValido()
	{	
		boolean campoValido = VerificadorCamposFormulario.campoNumericoDeValorAte11EhValido("4", "");
		assertEquals(campoValido,true);
	}
	
	@Test
	public void testdataEhValidaDataValida()
	{	
		boolean campoValido = VerificadorCamposFormulario.dataEhValida(Calendar.getInstance());
		assertEquals(campoValido,true);
	}
	
	@Test
	public void testdataEhValidaDataInvalida()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.dataEhValida(null);
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testcampoComAte25CaracteresEhValidoCampoVazio()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.campoComAte25CaracteresEhValido("", "");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testcampoComAte25CaracteresEhValidoCampoInvalido()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.campoComAte25CaracteresEhValido("rua dom jose tomaz", "cep");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testcampoComAte25CaracteresEhValidoCampoValido()
	{
		
		boolean campoValido = VerificadorCamposFormulario.campoComAte25CaracteresEhValido("rua dom jose tomaz", "rua");
		assertEquals(campoValido,true);
	}
	
	@Test
	public void teststringEhNumericaSim()
	{
		boolean campoValido = VerificadorCamposFormulario.stringEhNumerica("32");
		assertEquals(campoValido,true);
	}
	
	@Test
	public void teststringEhNumericaNao()
	{
		boolean campoValido = VerificadorCamposFormulario.stringEhNumerica("aajja");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testprecoEhValidoVazio()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.precoEhValido("");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testprecoEhValidoInvalido()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.precoEhValido("-3");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testprecoEhValidoValido()
	{
		boolean campoValido = VerificadorCamposFormulario.precoEhValido("3");
		assertEquals(campoValido,true);
	}
	
	@Test
	public void testnomeEhValidoInvalido()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.nomeEhValido("asdgwjrelfpitrmfhsldfhrucxmdheriejfosmejgosdmfrkrkfmssgksksmcfmdf", "nome");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testnomeEhValidoValido()
	{
		boolean campoValido = VerificadorCamposFormulario.nomeEhValido("andrews", "nome");
		assertEquals(campoValido,true);
	}
	
	@Test
	public void testtelefoneEhValidoInvalido()
	{
		
		
		boolean campoValido = VerificadorCamposFormulario.telefoneEhValido("8");
		assertEquals(campoValido,false);
	}
	
	@Test
	public void testtelefoneEhValidoValido()
	{
		boolean campoValido = VerificadorCamposFormulario.telefoneEhValido("(84)9924-3511");
		assertEquals(campoValido,true);
	}
	
	

}
