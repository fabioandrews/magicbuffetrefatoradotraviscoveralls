package junit;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.Test;

import controler.Gerente;
import controler.Pessoa;
import entidadesDAO.GerenteDAO;
import entidadesDAO.PessoaDAO;
import view.Cadastros;

public class CadastrosTest {

	Cadastros telaCadastros;
	@Before
	public void setUp() throws Exception {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaCadastros = new Cadastros();
                telaCadastros.setVisible(true);
                telaCadastros.toFront();
            }
        });
		
	}

	@Test
	public void testCadastrarClienteSemPreencherNada() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
	        JButton botaoSalvar = telaCadastros.getBotaoSalvar1();
	        while(telaCadastros.isShowing() == false)
	        {
	        	telaCadastros.show();
	        }
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar dialog
	        r.delay(3000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste cadastrar cliente sem preencher nada pela GUI dando erro");
		}
	}
	
	@Test
	public void testCancelarCadastro() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
	        JButton botaoCancelar = telaCadastros.getBotaoCancelar1();
	        while(telaCadastros.isShowing() == false)
	        {
	        	telaCadastros.show();
	        }
	        Point pontoCancelar = botaoCancelar.getLocationOnScreen();
	        r.mouseMove(pontoCancelar.x + botaoCancelar.getWidth() / 2, pontoCancelar.y + botaoCancelar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar dialog
	        r.delay(3000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste cancelar cadastro pela gui dando erro");
		}
	}
	
	@Test
	public void testCadastrarCliente() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		//primeiro, remover a pessoa que eu vou cadastrar para o comeco do teste
		Pessoa pessoaTeste = new Pessoa();
		pessoaTeste.setCpf("20438281420");
		PessoaDAO pessoaDao = new PessoaDAO();
		boolean removeuParaTeste = pessoaDao.remover(pessoaTeste);
		if(removeuParaTeste == false)
		{
			fail("falha ao tentar remover cliente para o cadastro na tela de cadastrosTest");
		}
		Robot r;
		try {
			r = new Robot();
			while(telaCadastros.isShowing() == false)
			{
				telaCadastros.show();
			}
	        JTextField textfieldNome1 = telaCadastros.getTextoNome1();
	        textfieldNome1.setText("Star Hollywood");
	        r.delay(1000);
	        JTextField textfieldCPF = telaCadastros.getTextoCPF1();
	        textfieldCPF.setText("20438281420");
	        r.delay(1000);
	        JTextField textFieldRg = telaCadastros.getTextoRG1();
	        textFieldRg.setText("2977269");
	        r.delay(1000);
	        JTextField textfieldRua = telaCadastros.getTextoRua1();
	        textfieldRua.setText("Rua Dom Jose tomaz");
	        r.delay(1000);
	        JTextField textfieldBairro = telaCadastros.getTextoBairro1();
	        textfieldBairro.setText("Tirol");
	        r.delay(1000);
	        JTextField textfieldCidade = telaCadastros.getTextoCidade1();
	        textfieldCidade.setText("Natal");
	        r.delay(1000);
	        JTextField textfieldNumero = telaCadastros.getTextoNumero1();
	        textfieldNumero.setText("1051");
	        r.delay(1000);
	        JTextField textfieldCep = telaCadastros.getTextoCEP1();
	        textfieldCep.setText("59022250");
	        r.delay(1000);
	        JTextField textfieldTelefone = telaCadastros.getTextoTelefone1();
	        textfieldTelefone.setText("8499243511");
	        r.delay(1000);
	        while(telaCadastros.isShowing() == false)
	        {
	        	r.delay(1000);//ainda carregando tela...
	        }
	        JButton botaoSalvar = telaCadastros.getBotaoSalvar1();
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar dialog
	        r.delay(3000);
	        //por fim, remover a pessoa novamente para futuros testes...
	        pessoaDao.remover(pessoaTeste);
	        
	        
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste cadastrar cliente pela GUI falhou");
		}
	}
	
	@Test
	public void testCadastrarGerente() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		//primeiro, remover a pessoa que eu vou cadastrar para o comeco do teste
		Gerente gerenteTest = new Gerente();
		gerenteTest.setLogin("pokemon");
		GerenteDAO gerenteDao = new GerenteDAO();
		boolean removeuParaTeste = gerenteDao.remover(gerenteTest);
		if(removeuParaTeste == false)
		{
			fail("falha ao tentar remover cliente para o cadastro na tela de cadastrosTest");
		}
		Robot r;
		try {
			r = new Robot();
			while(telaCadastros.isShowing() == false)
			{
				telaCadastros.show();
			}
			telaCadastros.getTipoCadastro().setText("Cadastrar Novo Gerente");
			r.delay(1000);
	        JTextField textfieldNome1 = telaCadastros.getTextoNome1();
	        textfieldNome1.setText("Violet Epaminondas");
	        r.delay(1000);
	        JTextField textfieldCPF = telaCadastros.getTextoCPF1();
	        textfieldCPF.setText("32232210774");
	        r.delay(1000);
	        JTextField textFieldRg = telaCadastros.getTextoRG1();
	        textFieldRg.setText("2977269");
	        r.delay(1000);
	        JTextField textfieldRua = telaCadastros.getTextoRua1();
	        textfieldRua.setText("Rua Dom Jose tomaz");
	        r.delay(1000);
	        JTextField textfieldBairro = telaCadastros.getTextoBairro1();
	        textfieldBairro.setText("Tirol");
	        r.delay(1000);
	        JTextField textfieldCidade = telaCadastros.getTextoCidade1();
	        textfieldCidade.setText("Natal");
	        r.delay(1000);
	        JTextField textfieldNumero = telaCadastros.getTextoNumero1();
	        textfieldNumero.setText("1051");
	        r.delay(1000);
	        JTextField textfieldCep = telaCadastros.getTextoCEP1();
	        textfieldCep.setText("59022250");
	        r.delay(1000);
	        JTextField textfieldTelefone = telaCadastros.getTextoTelefone1();
	        textfieldTelefone.setText("8499243511");
	        JTextField textFieldLogin = telaCadastros.getTextoLogin();
	        textFieldLogin.setText("pokemon");
	        r.delay(1000);
	        JTextField textfieldSenha = telaCadastros.getTextoSenha();
	        textfieldSenha.setText("126679");
	        r.delay(1000);
	        while(telaCadastros.isShowing() == false)
	        {
	        	r.delay(1000);//ainda carregando tela...
	        }
	        JButton botaoSalvar = telaCadastros.getBotaoSalvar1();
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar dialog
	        r.delay(3000);
	        //por fim, remover a pessoa novamente para futuros testes...
	        gerenteDao.remover(gerenteTest);
	        
	        
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste criar gerente pela GUI falhou");
			
		}
	}
	
	@Test
	public void testCadastrarMonitor() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		//primeiro, remover a pessoa que eu vou cadastrar para o comeco do teste
		Pessoa pessoaTeste = new Pessoa();
		pessoaTeste.setCpf("20438281420");
		PessoaDAO pessoaDao = new PessoaDAO();
		boolean removeuParaTeste = pessoaDao.remover(pessoaTeste);
		if(removeuParaTeste == false)
		{
			fail("falha ao tentar remover cliente para o cadastro na tela de cadastrosTest");
		}
		Robot r;
		try {
			r = new Robot();
			while(telaCadastros.isShowing() == false)
			{
				telaCadastros.show();
			}
			telaCadastros.getTipoCadastro().setText("Cadastrar Novo Monitor");
	        JTextField textfieldNome1 = telaCadastros.getTextoNome1();
	        textfieldNome1.setText("Star Hollywood");
	        r.delay(1000);
	        JTextField textfieldCPF = telaCadastros.getTextoCPF1();
	        textfieldCPF.setText("20438281420");
	        r.delay(1000);
	        JTextField textFieldRg = telaCadastros.getTextoRG1();
	        textFieldRg.setText("2977269");
	        r.delay(1000);
	        JTextField textfieldRua = telaCadastros.getTextoRua1();
	        textfieldRua.setText("Rua Dom Jose tomaz");
	        r.delay(1000);
	        JTextField textfieldBairro = telaCadastros.getTextoBairro1();
	        textfieldBairro.setText("Tirol");
	        r.delay(1000);
	        JTextField textfieldCidade = telaCadastros.getTextoCidade1();
	        textfieldCidade.setText("Natal");
	        r.delay(1000);
	        JTextField textfieldNumero = telaCadastros.getTextoNumero1();
	        textfieldNumero.setText("1051");
	        r.delay(1000);
	        JTextField textfieldCep = telaCadastros.getTextoCEP1();
	        textfieldCep.setText("59022250");
	        r.delay(1000);
	        JTextField textfieldTelefone = telaCadastros.getTextoTelefone1();
	        textfieldTelefone.setText("8499243511");
	        r.delay(1000);
	        while(telaCadastros.isShowing() == false)
	        {
	        	r.delay(1000);//ainda carregando tela...
	        }
	        JButton botaoSalvar = telaCadastros.getBotaoSalvar1();
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar dialog
	        r.delay(3000);
	        //por fim, remover a pessoa novamente para futuros testes...
	        pessoaDao.remover(pessoaTeste);
	        
	        
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste cadastrar monitor pela GUI falhou");
		}
	}
	
	
	@Test
	public void testCriarClienteSemTelefone()
	{
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
			while(telaCadastros.isShowing() == false)
			{
				telaCadastros.show();
			}
	        JTextField textfieldNome1 = telaCadastros.getTextoNome1();
	        textfieldNome1.setText("Star Hollywood");
	        r.delay(1000);
	        JButton botaoSalvar = telaCadastros.getBotaoSalvar1();
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar dialog
	        r.delay(3000);
		}
		catch(AWTException e)
		{
			e.printStackTrace();
			fail("teste criar cliente pela GUI sem telefone falhou");
		}
	        
	}
	
	

}
