package junit;

import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.JRadioButton;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import view.TelaBuscar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelaBuscarTest {

	@Before
	public void setUp() throws Exception 
	{
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscar.getInstance().setVisible(true);
            }
        }); 
		
		TelaBuscar.getInstance().toFront();
	}
	
	@After
    public void tearDown() throws Exception 
    {
             
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                	TelaBuscar.getInstance().destruirTela();
                }
            });
    }

	@Test
	public void testBuscarClienteSemPreencherNada() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{

            final Robot r = new Robot();
            r.delay(3000);
            
			
			while(TelaBuscar.getInstance().isShowing() == false)
			{
				TelaBuscar.getInstance().show();
			}
			
			AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
			JRadioButton radioButton = TelaBuscar.getInstance().getClienteRB();
            Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + radioButton.getWidth() / 2, p.y + radioButton.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            
            r.delay(3000);
            
            Point p2 = button.getLocationOnScreen();
        
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
        

		}
		catch (Exception e) {
            // TODO Auto-generated catch block
			System.out.println("testBuscarClienteSemPreencherNada:" + e.getMessage());
            e.printStackTrace();
            fail("falhou buscar cliente sem preencher nada");
		}
	}
	
	@Test
	public void testBuscarClienteQueNaoExiste() 
	{
		TelaBuscar.getInstance().toFront();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TelaBuscar.getInstance().toFront();
		try
		{

            final Robot r = new Robot();
            r.delay(3000);
            TelaBuscar.getInstance().toFront();
            
			
			r.delay(3000);
			
			while(TelaBuscar.getInstance().isShowing() == false)
			{
				TelaBuscar.getInstance().show();
			}
			
			AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
			JRadioButton radioButton = TelaBuscar.getInstance().getClienteRB();
			
			TelaBuscar.getInstance().getCpfText().setText("00772543411");
			r.delay(1000);
			
            Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + radioButton.getWidth() / 2, p.y + radioButton.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            
            Point p2 = button.getLocationOnScreen();
            
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            
            r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
        

		}
		catch (Exception e) 
		{
            // TODO Auto-generated catch block
			System.out.println("erro no testBuscarClienteQueNaoExiste:" + e.getMessage());
            e.printStackTrace();
            fail("falhou buscar cliente que nao existe");
		}
	}
	
	@Test
	public void testBuscarFestaSemPreencherNada() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{

            final Robot r = new Robot();
            r.delay(3000);
            
			
			while(TelaBuscar.getInstance().isShowing() == false)
			{
				TelaBuscar.getInstance().show();
			}
			
			AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
			JRadioButton radioButton = TelaBuscar.getInstance().getFestaRB();
			
            Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + radioButton.getWidth() / 2, p.y + radioButton.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            
            Point p2 = button.getLocationOnScreen();
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            
            r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
        

		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou buscar festa sem preencher nada");
		}
	}
	
	
	@Test
	public void testBuscarMonitorSemPreencherNada() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{

            final Robot r = new Robot();
            r.delay(3000);
            
			
			while(TelaBuscar.getInstance().isShowing() == false)
			{
				TelaBuscar.getInstance().show();
			}
			
			AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
			JRadioButton radioButton = TelaBuscar.getInstance().getMonitorRB();
            Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + radioButton.getWidth() / 2, p.y + radioButton.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
            
            Point p2 = button.getLocationOnScreen();
            
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
        

		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou buscar monitor sem preencher nada");
		}
	}
	
	
	@Test
	public void testBuscarMonitorQueNaoExiste() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{

            final Robot r = new Robot();
            r.delay(3000);
            
			
			while(TelaBuscar.getInstance().isShowing() == false)
			{
				TelaBuscar.getInstance().show();
			}
			
			TelaBuscar.getInstance().getCpfText().setText("00772543411");
            r.delay(1000);
            
            AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
			JRadioButton radioButton = TelaBuscar.getInstance().getMonitorRB();
			
            Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + radioButton.getWidth() / 2, p.y + radioButton.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
            
            Point p2 = button.getLocationOnScreen();
            
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
            
            r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
        

		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou buscar monitor que nao existe");
		}
	}
	
	@Test
	public void testBuscarClienteExiste() 
	{
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{

            final Robot r = new Robot();
            r.delay(3000);

	    while(TelaBuscar.getInstance().isShowing() == false)
	    {
	    	TelaBuscar.getInstance().show();
	    }
	    
	    TelaBuscar.getInstance().getCpfText().setText("21346655");
  	    r.delay(1000);

	    AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
	    JRadioButton radioButton = TelaBuscar.getInstance().getClienteRB();
	    
            Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + radioButton.getWidth() / 2, p.y + radioButton.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);

	    Point p2 = button.getLocationOnScreen();
        
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
        
            r.delay(3000);
        
	    

		}
		catch (Exception e) 
		{
            // TODO Auto-generated catch block
			System.out.println("deu excecao no testBuscarClienteExiste:" + e.getMessage());
            e.printStackTrace();
            fail("falhou buscar cliente que existe");
		}
	}

	@Test
	public void testBuscarFestaQueNaoExiste() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{

            final Robot r = new Robot();
            r.delay(3000);


	    while(TelaBuscar.getInstance().isShowing() == false)
	    {
	    	TelaBuscar.getInstance().show();
	    }
	    
	    Calendar.getInstance().set(2013, 11, 20);
	    TelaBuscar.getInstance().getData().setCalendar(Calendar.getInstance());
            r.delay(1000);

	    AbstractButton button = TelaBuscar.getInstance().getBotaoBuscar();
	    JRadioButton radioButton = TelaBuscar.getInstance().getFestaRB();

	    Point p = radioButton.getLocationOnScreen();
        
            r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);

	    Point p2 = button.getLocationOnScreen();
        
            r.mouseMove(p2.x + button.getWidth() / 2, p2.y + button.getHeight() / 2);
            r.mousePress(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        
            r.delay(3000);

		
            r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(3000);
        

		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("falhou buscar festa que nao existe");
		}
	}

}
