

package junit;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import view.telaLogin;


public class TelaLoginTest {

	static telaLogin telaLogin;
	@Before
	public  void setUp() throws Exception {
		telaLogin = new telaLogin();
		view.telaLogin.main(null);
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaLogin = new telaLogin();
                telaLogin.setVisible(true);
                
            }
        });
	}

	@Test
	public void testEntrarComLoginQualquer() {
		try
		{
			//fail("Not yet implemented");
			try { Thread.sleep(3000); } catch (Exception e) {}
			JButton botaoEntrar = telaLogin.getEntrar();
			Robot r = new Robot();
			r.delay(3000);
			Point p = botaoEntrar.getLocationOnScreen();
	        r.mouseMove(p.x + botaoEntrar.getWidth() / 2, p.y + botaoEntrar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
		}
		catch(AWTException exc)
		{
			exc.printStackTrace();
            fail("awt exception no teste da telaLogin clicar botao entrar");
		}

	}
	
	
	
	

}
