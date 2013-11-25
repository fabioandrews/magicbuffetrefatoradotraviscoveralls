package junit;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controler.Festa;
import entidadesDAO.FestaDAO;

public class FestaDaoTest {

	private FestaDAO festaDao;
	@Before
	public void setUp()  {
		festaDao = new FestaDAO();
		//remover festas usadas no teste na insercao
		Festa novaFesta = new Festa();
		
		novaFesta.setIdFesta("12378779");
		
		festaDao.remover(novaFesta);//se ja existia no BD
		
		Festa novaFesta2 = new Festa();
	
		novaFesta2.setIdFesta("761875");
	
		festaDao.remover(novaFesta2);
		
		Festa festaPraBuscar = new Festa("pacote Completo", "Moranguinho", "Normal", "556699999", 3, "Rua Carmosina" , 
				"2013/10/21", "2013/10/21", Time.valueOf("08:00:00"), true);
		/*festaPraBuscar.setDataInicio("2013/10/21");
		festaPraBuscar.setEstiloFesta("Normal");
		festaPraBuscar.setHoraInicio(Time.valueOf("08:00:00"));
		festaPraBuscar.setIdFesta("123787691");
		festaPraBuscar.setLocal("Rua Carmosina");
		festaPraBuscar.setPacote("pacote Completo");
		festaPraBuscar.setPessoaCPF("556699999");
		festaPraBuscar.setQuantidadeConvidados(3);
		festaPraBuscar.setTema("Moranguinho");
		festaPraBuscar.setExterno(true);*/
		festaDao.remover(festaPraBuscar);//se ja existia
		festaDao.criar(festaPraBuscar);
	}

	@Test
	public void testProcurarFestaInexistente() {
		Festa retornoPesquisaFesta = (Festa) festaDao.buscar("2013/11/11");//ele retorna um objeto festa vazio se nao tiver festa cadastrada
		assertEquals(retornoPesquisaFesta.getDataFim(), null);
		assertEquals(retornoPesquisaFesta.getDataInicio(), null);
		assertEquals(retornoPesquisaFesta.getEstiloFesta(), null);
		assertEquals(retornoPesquisaFesta.getHoraInicio(), null);
		assertEquals(retornoPesquisaFesta.getIdFesta(), null);
		assertEquals(retornoPesquisaFesta.getLocal(), null);
		assertEquals(retornoPesquisaFesta.getPacote(), null);
		assertEquals(retornoPesquisaFesta.getPessoaCPF(), null);
		assertEquals(retornoPesquisaFesta.getQuantidadeConvidados(), 0);
		assertEquals(retornoPesquisaFesta.getTema(), null);
	}
	
	@Test
	public void testProcurarFestaSqlInjection()
	{
		Object retornoPesquisaFesta =  festaDao.buscar("()(87722e71'''''&=true");
		if(retornoPesquisaFesta != null)
		{
			fail("retornando Festa com buscar() uma festa inserindo sql injection");
		}
	}
	
	@Test
	public void testProcurarFestaPorDataSqlInjection()
	{
		Object retornoPesquisaFesta =  festaDao.buscarFesta("()(87722e71'''''&=true");
		if(retornoPesquisaFesta != null)
		{
			fail("retornando Festa com buscarFesta(String data) uma festa inserindo sql injection");
		}
	}
	
	
	
	
	
	
	@Test
	public void testCriarFestaHappyPath()
	{
		System.out.println("iniciou metodo testCriarFestaHappyPath");
		Festa novaFesta = new Festa();
		novaFesta.setDataInicio("2013/11/11");
		novaFesta.setEstiloFesta("Normal");
		novaFesta.setHoraInicio(Time.valueOf("08:00:00"));
		novaFesta.setIdFesta("12378779");
		novaFesta.setLocal("Rua Carmosina");
		novaFesta.setPacote("pacote Completo");
		novaFesta.setPessoaCPF("556699999");
		novaFesta.setQuantidadeConvidados(3);
		novaFesta.setTema("Moranguinho");
		novaFesta.setExterno(true);
		
		boolean criadaFesta = festaDao.criar(novaFesta);
		System.out.println("criou festa metodo testCriarFestaHappyPath");
		assertEquals(true, criadaFesta);
	}
	
	@Test
	public void testCriarFestaSqlInjection()
	{
		Festa novaFesta = new Festa();
		novaFesta.setDataInicio("2013/11/11");
		novaFesta.setEstiloFesta("Normal");
		novaFesta.setHoraInicio(Time.valueOf("08:00:00"));
		novaFesta.setIdFesta("12378779");
		novaFesta.setLocal("Rua Carmosina");
		novaFesta.setPacote("pacote Completo");
		novaFesta.setPessoaCPF("abababababbababbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		novaFesta.setQuantidadeConvidados(3);
		novaFesta.setTema("Moranguinho");
		novaFesta.setExterno(true);
		boolean criou = this.festaDao.criar(novaFesta);
		assertEquals(false, criou);
	}
	
	@Test
	public void testUpdateFestaHappyPath()
	{
		Festa festaAtualizar = new Festa();
		festaAtualizar.setDataInicio("2013/11/11");
		festaAtualizar.setEstiloFesta("Normal");
		festaAtualizar.setHoraInicio(Time.valueOf("08:40:00"));
		festaAtualizar.setIdFesta("12378779");
		festaAtualizar.setLocal("Rua Carmosina");
		festaAtualizar.setPacote("pacote Completo");
		festaAtualizar.setPessoaCPF("556699999");
		festaAtualizar.setQuantidadeConvidados(3);
		festaAtualizar.setTema("Moranguinho");
		festaAtualizar.setExterno(true);
		boolean atualizadaFesta = festaDao.atualizar(festaAtualizar);
		System.out.println("atualizei festa");
		assertEquals(true, atualizadaFesta);
	}
	
	
	
	@Test
	public void testRemoverFestaHappyPath()
	{
		Festa festaRemover = new Festa();
		festaRemover.setIdFesta("12378779");
		
		//agora, tentar remover essa festa
		boolean festaRemovida = festaDao.remover(festaRemover);
		assertEquals(festaRemovida, true);
	}
	
	@Test
	public void testBuscarFestaExistente()
	{
		
		ArrayList<Festa> festaAchada = festaDao.buscarFesta("2013/10/21");
		if(festaAchada.size() >  0)
		{
			Festa umaFestaAchada = festaAchada.get(0);
			if(umaFestaAchada == null)
			{
				fail("festa existente o buscar tah dando erro testBuscarFestaExistente()");
			}
		}
		else
		{
			fail("buscar festa existente por data esta dando erro");
		}
	}
	
	@Test
	public void testBuscarTodasAsFestasExistentes()
	{
		ArrayList<Object> festasAchadas = festaDao.buscar();
		if(festasAchadas.size() == 0)
		{
			//tem ao menos uma festa que permanece no BD, entao tem erro
			fail("buscar todas as festas esta dando erro");
		}
	}
	
	
	
	
	
	
	
	
	

}
