package junit;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.toedter.calendar.JDateChooser;

import controler.Festa;
import entidadesDAO.FestaDAO;
import view.CadastroFesta;

public class CadastroFestaTest {

	private CadastroFesta telaCadastroFesta;
	@Before
	public void setUp() throws Exception {
		this.telaCadastroFesta= new CadastroFesta();
		telaCadastroFesta.setVisible(true);
        telaCadastroFesta.toFront();
	}

	@Test
	public void testEscolherBuscarCliente() {
		try {
			try { Thread.sleep(3000); } catch (Exception e) {}
			Robot r = new Robot();
			JButton botaoBuscarCliente = telaCadastroFesta.getBuscarCliente();
			Point p = botaoBuscarCliente.getLocationOnScreen();
	        r.mouseMove(p.x + botaoBuscarCliente.getWidth() / 2, p.y + botaoBuscarCliente.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("tela cadastroFesta nao funciona botao buscar cliente");
		}
	}
	
	@Test
	public void testCancelarCadastroFesta()
	{
		try {
			try { Thread.sleep(3000); } catch (Exception e) {}
			Robot r = new Robot();
			JButton botaoBuscarCancelar = telaCadastroFesta.getBotaoCancelar();
			Point p = botaoBuscarCancelar.getLocationOnScreen();
	        r.mouseMove(p.x + botaoBuscarCancelar.getWidth() / 2, p.y + botaoBuscarCancelar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("tela cadastroFesta nao funciona botao cancelar");
		}
	}
	
	@Test
	public void testEscolherCriarPacote() {
		try {
			try { Thread.sleep(3000); } catch (Exception e) {}
			Robot r = new Robot();
			JButton botaoCriarPacote = telaCadastroFesta.getBotaoCriarPacote();
			Point p = botaoCriarPacote.getLocationOnScreen();
	        r.mouseMove(p.x + botaoCriarPacote.getWidth() / 2, p.y + botaoCriarPacote.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("tela cadastroFesta nao funciona botao criar pacote");
		}
	}
	
	@Test
	public void testCadastrarUmaFesta()
	{
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
			JDateChooser dataInicio = telaCadastroFesta.getDatainicio();
	        Calendar calendarioInicio = Calendar.getInstance();
	        calendarioInicio.set(2013, 05, 21);
	        dataInicio.setCalendar(calendarioInicio);
	        JDateChooser dataFim = telaCadastroFesta.getDatafim();
	        dataFim.setCalendar(calendarioInicio);
			
	        JTextField textfieldInserirCPF = telaCadastroFesta.getTextocpf();
	        textfieldInserirCPF.setText("21814586695");
	        r.delay(1000);
	        JButton botaoChecarCpf = telaCadastroFesta.getChecarCPF();
	        Point p = botaoChecarCpf.getLocationOnScreen();
	        r.mouseMove(p.x + botaoChecarCpf.getWidth() / 2, p.y + botaoChecarCpf.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        JButton botaoChecarData = telaCadastroFesta.getBotaoChecar();
	        Point pontoChecarData = botaoChecarData.getLocationOnScreen();
	        r.mouseMove(pontoChecarData.x + botaoChecarData.getWidth() / 2, pontoChecarData.y + botaoChecarData.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);
	        r.delay(3000);
	        JTextField textfieldQuantidadeConvidados = telaCadastroFesta.getQntConvidados();
	        textfieldQuantidadeConvidados.setText("3");
	        r.delay(1000);
	        JButton botaoSalvar = telaCadastroFesta.getBotaoSalvar();
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar criacao da festa
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//optionpane festa criada com sucesso
	        r.delay(3000);
	        
	        //falta deletar a festa para futuros testes
	        FestaDAO festaDao = new FestaDAO();
	        Festa festaRemover = festaDao.buscarFesta("2013-10-21 00:00:00").get(0);
	        if(festaRemover != null)
	        {
	        	//tem festa para remover
	        	festaDao.remover(festaRemover);
	        }
	        
			r.delay(3000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste cadastrar uma festa via GUI nao esta funcionando");
		}
		
	}
	
	@Test
	public void testCadastrarUmaFestaEnderecoDoCliente()
	{
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
			JDateChooser dataInicio = telaCadastroFesta.getDatainicio();
	        Calendar calendarioInicio = Calendar.getInstance();
	        calendarioInicio.set(2013, 05, 21);
	        dataInicio.setCalendar(calendarioInicio);
	        JDateChooser dataFim = telaCadastroFesta.getDatafim();
	        dataFim.setCalendar(calendarioInicio);
	        JTextField textfieldInserirCPF = telaCadastroFesta.getTextocpf();
	        textfieldInserirCPF.setText("21814586695");
	        r.delay(1000);
	        JButton botaoChecarCpf = telaCadastroFesta.getChecarCPF();
	        Point p = botaoChecarCpf.getLocationOnScreen();
	        r.mouseMove(p.x + botaoChecarCpf.getWidth() / 2, p.y + botaoChecarCpf.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        JButton botaoChecarData = telaCadastroFesta.getBotaoChecar();
	        Point pontoChecarData = botaoChecarData.getLocationOnScreen();
	        r.mouseMove(pontoChecarData.x + botaoChecarData.getWidth() / 2, pontoChecarData.y + botaoChecarData.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);
	        r.delay(3000);
	        JTextField textfieldQuantidadeConvidados = telaCadastroFesta.getQntConvidados();
	        textfieldQuantidadeConvidados.setText("3");
	        r.delay(1000);
	        JRadioButton botaoUsarEnderecoExterno = telaCadastroFesta.getLocalExterno();
	        Point pontoBotaoUsarEnderecoExterno = botaoUsarEnderecoExterno.getLocationOnScreen();
	        r.mouseMove(pontoBotaoUsarEnderecoExterno.x + botaoUsarEnderecoExterno.getWidth() / 2, pontoBotaoUsarEnderecoExterno.y + botaoUsarEnderecoExterno.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        JRadioButton botaoUsarEnderecoDoCliente = telaCadastroFesta.getUsarEndereco();
	        Point pontoBotaoUsarEnderecoDoCliente = botaoUsarEnderecoDoCliente.getLocationOnScreen();
	        r.mouseMove(pontoBotaoUsarEnderecoDoCliente.x + botaoUsarEnderecoDoCliente.getWidth() / 2, pontoBotaoUsarEnderecoDoCliente.y + botaoUsarEnderecoDoCliente.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        JButton botaoSalvar = telaCadastroFesta.getBotaoSalvar();
	        Point pontoSalvar = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(pontoSalvar.x + botaoSalvar.getWidth() / 2, pontoSalvar.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//confirmar criacao da festa
	        r.delay(3000);
	        r.keyPress(KeyEvent.VK_ENTER);//optionpane festa criada com sucesso
	        r.delay(3000);
	        
	        //falta deletar a festa para futuros testes
	        FestaDAO festaDao = new FestaDAO();
	        Festa festaRemover = festaDao.buscarFesta("2013-10-21 00:00:00").get(0);
	        if(festaRemover != null)
	        {
	        	//tem festa para remover
	        	festaDao.remover(festaRemover);
	        }
	        
			r.delay(3000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("teste cadastrar uma festa via GUI nao esta funcionando");
		}
		
	}
	
	@Test
	public void testCadastrarUmaFestaSemPreencherNada()
	{
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
	        JButton botaoSalvar = telaCadastroFesta.getBotaoSalvar();
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
		}
		
	}

}
