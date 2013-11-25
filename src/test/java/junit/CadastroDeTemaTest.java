package junit;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.CadastroDeTema;
import view.TelaInicial;
import controler.Tema;
import entidadesDAO.TemaDAO;

public class CadastroDeTemaTest 
{
	CadastroDeTema cadastroDeTema;

	@Before
	public void setUp() throws Exception 
	{
		TemaDAO temaDAO = new TemaDAO();
		Tema t = new Tema("MFml","mlp");
		temaDAO.remover(t);
		
		cadastroDeTema = new CadastroDeTema();
		cadastroDeTema.setVisible(true);
		cadastroDeTema.toFront();
	}
	
	@After
	public void tearDown()
	{
		cadastroDeTema.dispose();
	}

	@Test
	public void testCadastrarTemaSemPreencherNada() 
	{
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
            
            AbstractButton button = cadastroDeTema.getSalvar();
            
            while(cadastroDeTema.isShowing() == false)
            {
            	cadastroDeTema.show();
            }
            
            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
			
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
		}
		catch (AWTException e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou testCadastrarTemaSemPreencherNada");
		}
	}
	
	@Test
	public void testCadastrarTemaMuitoGrande() 
	{
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
            
            AbstractButton button = cadastroDeTema.getSalvar();
            JTextField textFieldNome = cadastroDeTema.getNomeTema();						
            textFieldNome.setText("ajshfoeurtjgjdlsirjgkforudjeutqhdfjfkreiweudhdskskfgjmcjdheuwtdfgskfmcjdhsgdnc");
            
            r.delay(1000);
            
            
            while(cadastroDeTema.isShowing() == false)
            {
            	cadastroDeTema.show();
            }
            
            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
			
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
		}
		catch (AWTException e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou testCadastrarTemaMuitoGrande");
		}
	}
	
	@Test
	public void testCadastrarTemaValido() 
	{
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
            
            AbstractButton button = cadastroDeTema.getSalvar();
            JTextField textFieldNome = cadastroDeTema.getNomeTema();						
            textFieldNome.setText("mlp");
            
            r.delay(1000);
            
            
            while(cadastroDeTema.isShowing() == false)
            {
            	cadastroDeTema.show();
            }
            
            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
			
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
		}
		catch (AWTException e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou testCadastrarTemaValido");
		}
	}
	
	@Test
	public void testCadastrarTemaCancelar() 
	{
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
            
            AbstractButton button = cadastroDeTema.getjButton2();
            
            
            while(cadastroDeTema.isShowing() == false)
            {
            	cadastroDeTema.show();
            }
            
            Point p = button.getLocationOnScreen();
            
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            
			r.delay(3000);
			
		}
		catch (AWTException e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou testCadastrarTemaCancelar");
		}
	}

}
