package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controler.Gerente;
import controler.Pessoa;
import entidadesDAO.GerenteDAO;

public class GerenteDAOTest {

	private GerenteDAO gerenteDao;
	@Before
	public void setUp() throws Exception {
		gerenteDao = new GerenteDAO();
		Gerente gerenteLimparBd = new Gerente();
		gerenteLimparBd.setLogin("fulanoQualquer");
		gerenteLimparBd.setSenha("123667");
		gerenteDao.remover(gerenteLimparBd);//se ja existir esse gerente...
		
		gerenteLimparBd.setLogin("haruglory");
		gerenteLimparBd.setSenha("umasenhaqualquer");
		gerenteDao.remover(gerenteLimparBd);//se ja existir esse gerente...
		
		gerenteLimparBd.setLogin("phikun");
		gerenteLimparBd.setSenha("umdoistres");
		gerenteDao.remover(gerenteLimparBd);//se ja existir esse gerente...
		
		
		gerenteDao = new GerenteDAO();
		Gerente gerenteParaBuscarBd = new Gerente();
		gerenteParaBuscarBd.setLogin("fulano2");
		gerenteParaBuscarBd.setSenha("127599");
		gerenteDao.remover(gerenteParaBuscarBd);//se ja existir esse gerente...
		gerenteDao.criar(gerenteParaBuscarBd);
		
		gerenteDao = new GerenteDAO();
		Gerente gerenteParaRemover = new Gerente();
		gerenteParaRemover.setLogin("fulano3");
		gerenteParaRemover.setSenha("127596808");
		gerenteDao.remover(gerenteParaRemover);//se ja existir esse gerente...
		gerenteDao.criar(gerenteParaRemover);
		
		
	}

	@Test
	public void testCriarUmGerenteHappyPath() 
	{
		Gerente novoGerente = new Gerente();
		novoGerente.setLogin("fulanoQualquer");
		novoGerente.setSenha("123667");
		boolean criouGerente = gerenteDao.criar(novoGerente);
		assertEquals(criouGerente, true);
	}
	
	@Test
	public void testCriarUmGerenteConstrutorCompleto()
	{
		Gerente gerente = new Gerente("44352691046", 2977269, "phikun", "59022250", "Rua dom jose tomaz ", "Tirol", "8499243511", 1051, "Fabio Phillip", Pessoa.getStringGerente(), "Natal", "umdoistres","phikun");
		boolean criouGerente = gerenteDao.criar(gerente);
		assertEquals(criouGerente, true);
	}
	
	@Test
	public void testCriarUmGerenteConstrutorSimples()
	{
		Gerente gerente = new Gerente("haruglory", "umasenhaqualquer");
	}
	
	@Test
	public void testBuscarUmGerenteHappyPath()
	{
		
		Gerente gerenteAchado = (Gerente) gerenteDao.buscar("fulano2");
		assertEquals(gerenteAchado.getLogin(), "fulano2");
		assertEquals(gerenteAchado.getSenha(), "127599");
	}
	
	@Test
	public void testRemoverUmGErenteHappyPath()
	{
		
		Gerente gerenteParaRemover = new Gerente();
		gerenteParaRemover.setLogin("fulano3");
		gerenteParaRemover.setSenha("127596808");
		boolean removeu = gerenteDao.remover(gerenteParaRemover);
		assertEquals(true, removeu);
	}
	
	@Test
	public void testCriarGerenteSqlInjection()
	{
		Gerente gerenteAAdicionar = new Gerente();
		gerenteAAdicionar.setLogin("abababababbababbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		gerenteAAdicionar.setSenha("1375279");
		boolean criou = this.gerenteDao.criar(gerenteAAdicionar);
		assertEquals(false, criou);
	}
	
	@Test
	public void buscarGerenteSqlInjection()
	{
		Object objetoRetorno = this.gerenteDao.buscar("()(87722e71'''''&=true");
		if(objetoRetorno != null)
		{
			fail("buscar gerente com sql injection esta dando certo e era para falhar");
		}
	}
	
	
	
	

}
