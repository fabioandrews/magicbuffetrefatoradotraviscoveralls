package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controler.ResultadoPesquisa;

public class ResultadoPesquisaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ResultadoPesquisa resultado = new ResultadoPesquisa();
		resultado.setCpf("59706513540");
		String cpf =resultado.getCpf();
		assertEquals(cpf, "59706513540");
	}

}
