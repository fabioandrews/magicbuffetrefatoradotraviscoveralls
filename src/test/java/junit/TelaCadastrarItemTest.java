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
import org.junit.FixMethodOrder;
import org.junit.Test;

import view.TelaCadastrarItem;
import view.TelaInicial;

import org.junit.runners.MethodSorters;

import controler.Item;
import entidadesDAO.ItemDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelaCadastrarItemTest 
{
	TelaCadastrarItem telaCadastrarItem;

	@Before
	public void setUp() throws Exception 
	{
		telaCadastrarItem = new TelaCadastrarItem();
		telaCadastrarItem.setVisible(true);
		telaCadastrarItem.toFront();
		
	}
	
	@After
	public void tearDown() throws Exception 
	{
		telaCadastrarItem.dispose();
	}
	
	@Test
	public void testCancelarCadastro() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			AbstractButton button = telaCadastrarItem.getCANCELAR();

            Point p = button.getLocationOnScreen();

            final Robot r = new Robot();
            r.delay(3000);
        
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
        

		}
		catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou clicar no botao cancelar");
		}
	}
	
	@Test
	public void testCadastrarSemPreencherNada() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			AbstractButton button = telaCadastrarItem.getSALVAR();

            Point p = button.getLocationOnScreen();

            final Robot r = new Robot();
            r.delay(3000);
        
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
            r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
        

		}
		catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou cadastrar sem preencher nada");
		}
	}
	
	@Test
	public void testCadastrarPreenchendoCorretamente() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			AbstractButton button = telaCadastrarItem.getSALVAR();
			telaCadastrarItem.getTextoNomeItem().setText("bolo");
			telaCadastrarItem.getTextoQuantidade().setText("10");
			telaCadastrarItem.getTextopreco().setText("45.00");
			
            Point p = button.getLocationOnScreen();

            final Robot r = new Robot();
            r.delay(3000);
        
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
            
            ItemDAO itemDAO = new ItemDAO();
            Item item = itemDAO.buscarNome("bolo");
            itemDAO.remover(item);
        

		}
		catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou cadastrar preenchendo tudo corretamente");
		}
	}
	
	@Test
	public void testTestarMain() 
	{	
		telaCadastrarItem.main(null);	
	}
			

}
