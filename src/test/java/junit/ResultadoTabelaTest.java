package junit;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Time;

import javax.swing.AbstractButton;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import controler.Festa;
import controler.Pessoa;
import entidadesDAO.FestaDAO;
import entidadesDAO.PessoaDAO;
import view.ResultadoTabela;

public class ResultadoTabelaTest 
{
	ResultadoTabela resultadoTabela;

	@Before
	public void setUp() throws Exception 
	{
		resultadoTabela = new ResultadoTabela();
		resultadoTabela.setVisible(true);
		resultadoTabela.toFront();
		
	}
	
	@After
	public void tearDown() throws Exception
	{
		resultadoTabela.dispose();
	}

	@Test
	public void testPegarInformacoesDaPrimeiraLinhaSendoUmaFesta() 
	{
		DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Clientes das Festas");
        modelo.addColumn("CPF");
        modelo.addColumn("Horario");
        modelo.addColumn("Id");
        
        
            FestaDAO daoFesta = new FestaDAO();
            Festa festa = new Festa("pacote Basico", "moranguinho", "Normal", "21346655", 3, "Rua Maracajau", null, "2013/11/11", Time.valueOf("08:40:00"), true);
            festa.setIdFesta("999");
            
            daoFesta.remover(festa); //por precaucao, irei remover a festa se ela ja existe
            daoFesta.criar(festa);
            String[] linha = {"Joao Vinaud","21346655", "08:40:00" ,"999"};
            
            modelo.addRow(linha);
            
        resultadoTabela.tabela.setModel(modelo);
        
        
        try
        {

        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	

            final Robot r = new Robot();
            r.delay(3000);
            
            while(resultadoTabela.isShowing() == false)
            {
            	resultadoTabela.show();
            }
            
            resultadoTabela.selecionarAPrimeiraLinhaDaTabela();
            AbstractButton button = resultadoTabela.getInformacoes();

            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
            

        }
        catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                fail("falhou clicar no botao buscar");
        }
        
        daoFesta.remover(festa);
	}
	
	@Test
	public void testExcluirPrimeiraLinhaSendoUmaFesta() 
	{
		DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Clientes das Festas");
        modelo.addColumn("CPF");
        modelo.addColumn("Horario");
        modelo.addColumn("Id");
        
        
            FestaDAO daoFesta = new FestaDAO();
            Festa festa = new Festa("pacote Basico", "moranguinho", "Normal", "21346655", 3, "Rua Maracajau", null, "2013/11/11", Time.valueOf("08:40:00"), true);
            festa.setIdFesta("999");
            
            daoFesta.remover(festa); //por precaucao, irei remover a festa se ela ja existe
            daoFesta.criar(festa);
            String[] linha = {"Joao Vinaud","21346655", "08:40:00" ,"999"};
            
            modelo.addRow(linha);
            
        resultadoTabela.tabela.setModel(modelo);
        
        
        try
        {

        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	

            final Robot r = new Robot();
            r.delay(3000);
            
            while(resultadoTabela.isShowing() == false)
            {
            	resultadoTabela.show();
            }
            
        	resultadoTabela.selecionarAPrimeiraLinhaDaTabela();
            AbstractButton button = resultadoTabela.getExcluir();

            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
            
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
			
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);

        }
        catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                fail("falhou clicar no botao buscar");
        }
        
        daoFesta.remover(festa);
	}
	
	@Test
	public void testExcluirPrimeiraLinhaSendoUmaPessoa() 
	{
		DefaultTableModel modelo = new DefaultTableModel();
		resultadoTabela.setTipoPessoa("CLIENTE");
        modelo = new DefaultTableModel();
        modelo.addColumn("CLIENTE");
        modelo.addColumn("CPF");
        
        
            PessoaDAO daoPessoa = new PessoaDAO();
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf("00772544492");
            pessoa.setRg(3034904);
            pessoa.setBairro("tirol");
            pessoa.setCep("59022250");
            pessoa.setCidade("natal");
            pessoa.setNumero(1051);
            pessoa.setPnome("fabio andrews rocha marques");
            pessoa.setRua("rua dom jose tomaz");
            pessoa.setTelefone("91524459");
            pessoa.setTipoPessoa("CLIENTE");
            
            daoPessoa.remover(pessoa); //por precaucao, irei remover a festa se ela ja existe
            daoPessoa.criar(pessoa);
            String[] linha = {"fabio andrews rocha marques", "00772544492"};
            
            modelo.addRow(linha);
            
        resultadoTabela.tabela.setModel(modelo);
        
        
        try
        {

        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	

            final Robot r = new Robot();
            r.delay(3000);
            
            while(resultadoTabela.isShowing() == false)
            {
            	resultadoTabela.show();
            }
            
            resultadoTabela.selecionarAPrimeiraLinhaDaTabela();
            AbstractButton button = resultadoTabela.getExcluir();

            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
            
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
			
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);

        }
        catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                fail("falhou excluir pessoa que existe");
        }
        
        daoPessoa.remover(pessoa);
	}
	
	@Test
	public void testPegarInformacoesPrimeiraLinhaSendoUmaPessoa() 
	{
		DefaultTableModel modelo = new DefaultTableModel();
		resultadoTabela.setTipoPessoa("CLIENTE");
        modelo = new DefaultTableModel();
        modelo.addColumn("CLIENTE");
        modelo.addColumn("CPF");
        
        
            PessoaDAO daoPessoa = new PessoaDAO();
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf("00772544492");
            pessoa.setRg(3034904);
            pessoa.setBairro("tirol");
            pessoa.setCep("59022250");
            pessoa.setCidade("natal");
            pessoa.setNumero(1051);
            pessoa.setPnome("fabio andrews rocha marques");
            pessoa.setRua("rua dom jose tomaz");
            pessoa.setTelefone("91524459");
            pessoa.setTipoPessoa("CLIENTE");
            
            daoPessoa.remover(pessoa); //por precaucao, irei remover a festa se ela ja existe
            daoPessoa.criar(pessoa);
            String[] linha = {"fabio andrews rocha marques", "00772544492"};
            
            modelo.addRow(linha);
            
        resultadoTabela.tabela.setModel(modelo);
        
        
        try
        {

        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	

            final Robot r = new Robot();
            r.delay(3000);
            
            while(resultadoTabela.isShowing() == false)
            {
            	resultadoTabela.show();
            }
            
            resultadoTabela.selecionarAPrimeiraLinhaDaTabela();
            AbstractButton button = resultadoTabela.getInformacoes();

            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
            

        }
        catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                fail("falhou pegar informacoes pessoa que existe");
        }
        
        daoPessoa.remover(pessoa);
	}

}
