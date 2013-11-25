package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import conexao.ConectionFactory;

public class ConectarComBdTest {

        @Test
        public void testconectarComBD() 
        {
                try
                {
                        ConectionFactory conector = new ConectionFactory();
                        conector.getConnection();
                }
                catch(Exception e)
                {
                        fail("teste falhou");
                }
        }
        
        @Test
        public void testarMainConnectionFactory()
        {
        	try
        	{
        		ConectionFactory.main(null);
        	}
        	catch(Exception e)
        	{
        		fail("testar mais connectionFactory falhou");
        	}
        	
        }

}
