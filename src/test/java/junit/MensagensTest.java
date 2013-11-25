package junit;



import org.junit.Before;
import org.junit.Test;

import view.Mensagens;

public class MensagensTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() 
	{
		
	
		Mensagens mensagem = new Mensagens();
		mensagem.imprimeErro("mensagem", "erro");
		
		
	}
	
	

}
