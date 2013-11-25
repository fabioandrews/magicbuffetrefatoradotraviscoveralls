package junit;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InterfaceDAO.InterfaceItemDAO;
import controler.Item;
import controler.Pacote;
import entidadesDAO.FabricaDeDAO;
import entidadesDAO.ItemDAO;
import entidadesDAO.PacoteDAO;
import view.TelaCadastrarpacote;

public class TelaCadastrarPacoteTest {

	TelaCadastrarpacote telaCadastrarPacote; 
	@Before
	public void setUp() throws Exception {
		//TelaCadastrarpacote.main(null);//cria uma telinha para testar o main...
		
		
		DefaultTableModel modelo;
		InterfaceItemDAO DAOTrabalhaComItens = FabricaDeDAO.criarItemDAO();
        ArrayList<Object> ListaPacotes = DAOTrabalhaComItens.buscar();
        ArrayList<Item> it = new ArrayList<Item>();
        
        for(Object p : ListaPacotes)
            it.add((Item)p);
        
        modelo = new DefaultTableModel();                                
        modelo.addColumn("Item");        
        modelo.addColumn("ID"); 
        String Item;
        String ID;
        for (int i = 0; i < ListaPacotes.size(); i++) {
              Item = it.get(i).getNomeItem();              
              ID = it.get(i).getIdItem();
              String [] linha = {Item,ID};
              modelo.addRow(linha);
          }
              
        this.telaCadastrarPacote = new  TelaCadastrarpacote();
        this.telaCadastrarPacote.getTabela().setModel(modelo);
        this.telaCadastrarPacote.toFront();
        
        this.telaCadastrarPacote.setVisible(true);
              
	}

	@Test
	public void testCancelarJanelaPacote() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			
			r = new Robot();
			r.delay(3000);
			while(telaCadastrarPacote.isShowing() == false)
	        {
	        	telaCadastrarPacote.show();
	        }
			JButton botaoCancelar = telaCadastrarPacote.getCANCELAR();
			Point p = botaoCancelar.getLocationOnScreen();
			r.mouseMove(p.x + botaoCancelar.getWidth() / 2, p.y + botaoCancelar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCadastraPacote() {
		try { Thread.sleep(3000); } catch (Exception e) {}
		Robot r;
		try {
			r = new Robot();
			r.delay(3000);
			while(telaCadastrarPacote.isShowing() == false)
	        {
	        	telaCadastrarPacote.show();
	        }
			
			
			JTextField textFieldNomePacote = telaCadastrarPacote.getTextoNomePacote();
			textFieldNomePacote.setText("pacote novo");
			
			JTextField textFieldDesconto = telaCadastrarPacote.getDesconto();
			textFieldDesconto.setText("1.00");
			
			JTable tabelaItensAdicionarPacote = telaCadastrarPacote.getTabela();
			Point p = tabelaItensAdicionarPacote.getLocationOnScreen();
			r.mouseMove(p.x + tabelaItensAdicionarPacote.getWidth() / 2, p.y + tabelaItensAdicionarPacote.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        
	        JButton botaoCalcularPreco = telaCadastrarPacote.getCalcularPreco();
	        p = botaoCalcularPreco.getLocationOnScreen();
	        r.mouseMove(p.x + botaoCalcularPreco.getWidth() / 2, p.y + botaoCalcularPreco.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        
	        JButton botaoSalvar = telaCadastrarPacote.getSALVAR();
	        p = botaoSalvar.getLocationOnScreen();
	        r.mouseMove(p.x + botaoSalvar.getWidth() / 2, p.y + botaoSalvar.getHeight() / 2);
	        r.mousePress(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        r.mouseRelease(InputEvent.BUTTON1_MASK);
	        r.delay(3000);
	        
	        //limpar textfields para testes futuros
	        textFieldDesconto.setText("");
	        textFieldNomePacote.setText("");
	        
	        //salvamos um novo pacote. agora, temos de remover esse pacote do bd para futuros testes
	        PacoteDAO pacoteDAO = new PacoteDAO();
	        Pacote pacoteRemover = pacoteDAO.buscarPorNome("pacote novo");
	        if(pacoteRemover != null)//tem algo pra remover...
	        {
	        	pacoteDAO.remover(pacoteRemover);
	        }
	        
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			fail("cadastrar pacote na tela de cadastrar pacote esta dando erro");
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCadastrarPacoteSemNome()
	{
		try { Thread.sleep(3000); } catch (Exception e) {}
		 JButton botaoSalvar = telaCadastrarPacote.getSALVAR();
		 Robot r;
		try {
			r = new Robot();
			r.delay(3000);
			while(telaCadastrarPacote.isShowing() == false)
	        {
	        	telaCadastrarPacote.show();
	        }
			 Point p = botaoSalvar.getLocationOnScreen();
		     r.mouseMove(p.x + botaoSalvar.getWidth() / 2, p.y + botaoSalvar.getHeight() / 2);
		     r.mousePress(InputEvent.BUTTON1_MASK);
		     r.delay(3000);
		     r.mouseRelease(InputEvent.BUTTON1_MASK);
		     r.delay(3000);
		     r.keyPress(KeyEvent.VK_ENTER);
		     r.delay(3000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("cadastrar pacote sem nome na tela de cadastro  esta dando erro AWT");
		}
	}
	
	@Test
	public void testCadastrarPacoteComNomeJahExistente()
	{
		 
		//primeiro, salvar o pacote no BD
         
		ArrayList<String> itensPacote = new ArrayList<String>();
        itensPacote.add("9090");
         
         PacoteDAO daoPacote = new PacoteDAO();
        
         Pacote p = new Pacote("99999", "pacotaoSupimba", new Float(30.0), itensPacote);
         daoPacote.remover(p);
         
         
         Pacote pacoteParaTestes = new Pacote();
         pacoteParaTestes.setIdPacote("99999");
         pacoteParaTestes.setItensPacote(itensPacote);
         pacoteParaTestes.setPacoteNome("pacotaoSupimba");
         pacoteParaTestes.setPrecoPacote(new Float(30.0));
         
         daoPacote.remover(pacoteParaTestes);
         boolean conseguiuCriar = daoPacote.criar(pacoteParaTestes);
         if(conseguiuCriar == true)
         {
        	 try { Thread.sleep(3000); } catch (Exception e) {}
    		 JButton botaoSalvar = telaCadastrarPacote.getSALVAR();
    		 Robot r;
    		try {
    			 r = new Robot();
    			 r.delay(3000);
    			 while(telaCadastrarPacote.isShowing() == false)
    		        {
    		        	telaCadastrarPacote.show();
    		        }
    			 JTextField textFieldNomePacote = telaCadastrarPacote.getTextoNomePacote();
    			 textFieldNomePacote.setText("pacotaoSupimba");
    			 Point ponto = botaoSalvar.getLocationOnScreen();
    		     r.mouseMove(ponto.x + botaoSalvar.getWidth() / 2, ponto.y + botaoSalvar.getHeight() / 2);
    		     r.mousePress(InputEvent.BUTTON1_MASK);
    		     r.delay(3000);
    		     r.mouseRelease(InputEvent.BUTTON1_MASK);
    		     r.delay(3000);
    		     r.keyPress(KeyEvent.VK_ENTER);
    		     r.delay(3000);
    		     textFieldNomePacote.setText("");//para testes futuros
    		     //e por fim remover o pacote
    		     daoPacote.remover(pacoteParaTestes);
    		} catch (AWTException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			fail("cadastrar pacote sem nome na tela de cadastro  esta dando erro AWT");
    		}
         }
         else
         {
        	 fail("cadastrar pacote com nome existente via GUI - nao consigo criar o pacote antes de mecher na tela");
         }
	}
	
	@After
	public void tearDown()
	{
		this.telaCadastrarPacote.dispose();
	}
	


}
