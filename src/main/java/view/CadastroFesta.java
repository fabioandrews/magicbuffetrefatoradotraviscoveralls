/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import InterfaceDAO.DAOComBuscaMultiplaInterface;
import InterfaceDAO.GenericDAOInterface;
import InterfaceDAO.InterfaceFestaDAO;
import InterfaceDAO.InterfaceItemDAO;
import InterfaceDAO.InterfacePacoteDAO;
import controler.Festa;
import controler.Item;
import controler.Localizacao;
import controler.Pacote;
import controler.Pessoa;
import controler.Tema;
import entidadesDAO.FabricaDeDAO;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.sql.Time;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author andreza
 */
public final class CadastroFesta extends javax.swing.JFrame {

    private boolean checkData = false;
    private boolean checkCliente = false; //tem de checar o cpf
    private DAOComBuscaMultiplaInterface DAOTemas;
    private DAOComBuscaMultiplaInterface DAOPacotes;
    private DAOComBuscaMultiplaInterface DAOFestas;
    private DAOComBuscaMultiplaInterface DAOLocalizacao;
    private GenericDAOInterface DAOPessoas;
    
    private javax.swing.JRadioButton Buffet;
    private javax.swing.JRadioButton UsarEndereco;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoChecar;
    private javax.swing.JButton botaoCriarPacote;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton buscarCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton checarCPF;
    private com.toedter.calendar.JDateChooser datafim;
    private com.toedter.calendar.JDateChooser datainicio;
    private javax.swing.JComboBox estilo;
    private com.toedter.components.JSpinField horaSpin;
    private javax.swing.JComboBox itensPacote;
    private javax.swing.JComboBox itensTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton localExterno;
    private com.toedter.components.JSpinField minutosSpin;
    private javax.swing.JTextField qntConvidados;
    private javax.swing.JTextField textoBairro;
    private javax.swing.JTextField textoCEP;
    private javax.swing.JTextField textoCidade;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoNumero;
    private javax.swing.JTextField textoRua;
    private javax.swing.JTextField textocpf;
    
    
    public void prencherOpcoesTema(){
    	DAOTemas = FabricaDeDAO.criarTemaDAO();
    	DAOPacotes = FabricaDeDAO.criarPacoteDAO();
    	DAOPessoas = FabricaDeDAO.criarPessoaDAO();
    	DAOFestas = FabricaDeDAO.criarFestaDAO();
    	DAOLocalizacao = FabricaDeDAO.criarLocalizacaoDAO();
        ArrayList<Object> temaObj  = DAOTemas.buscar();;
        ArrayList<Tema> tema  = new ArrayList<Tema>();
        
        for(Object t : temaObj)
            tema.add((Tema)t);
        
        String[] themes = new String[tema.size()];
        
        for (int i = 0; i < tema.size(); i++) {
            themes[i] = tema.get(i).getTnome();
        }
        
        DefaultComboBoxModel  model = new DefaultComboBoxModel(themes);
        itensTema.setModel(model);
    }
    
        
    
    public void prencherOpcoesPacote(){
        ArrayList<Object> pacote =  this.DAOPacotes.buscar();
        ArrayList<Pacote> pk = new ArrayList<Pacote>();                
        
        for(Object p : pacote)
            pk.add((Pacote)p);
                    
        String[] packages = new String[pacote.size()];
        
        for (int i = 0; i < pk.size(); i++) {
            packages[i] = pk.get(i).getPacoteNome();
        }
        
        DefaultComboBoxModel  model = new DefaultComboBoxModel(packages);
        itensPacote.setModel(model);
        
    }
    
    
    public CadastroFesta() {
        initComponents();
        prencherOpcoesTema();
        prencherOpcoesPacote();
        textoBairro.setEnabled(false);
        textoCEP.setEnabled(false);
        textoCidade.setEnabled(false);
        textoRua.setEnabled(false);
        textoNumero.setEnabled(false);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        
    	this.inicializarTodosOsComponentesDaGUI();
    	this.setarTextosNosJLabelsDaGUI();
    	this.setarTextoEAcaoDosBotoesDaGUI();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(localExterno);
        localExterno.setText("Local Externo");
        localExterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localExternoActionPerformed(evt);
            }
        });

        buttonGroup1.add(UsarEndereco);
        UsarEndereco.setText("Usar Endereco do cliente");
        UsarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarEnderecoActionPerformed(evt);
            }
        });
        

        buttonGroup1.add(Buffet);
        Buffet.setText("Buffet");
        Buffet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuffetActionPerformed(evt);
            }
        });
        
        Buffet.setSelected(true);
        
        /*quando o textfield mudar, o cpf deve ser checado novamente*/
        textocpf.getDocument().addDocumentListener(new DocumentListener() {
        	  public void changedUpdate(DocumentEvent e) {
        		  	checkCliente = false;
        		    
        		  }
        		  public void removeUpdate(DocumentEvent e) {
        			  checkCliente = false;
        		  }
        		  public void insertUpdate(DocumentEvent e) {
        			  checkCliente = false;
        		  }
        	   });
        
        textoNome.setEditable(false);
        textoRua.setEditable(false);
        JTextField textFieldDataFim = (JTextField)(datafim.getDateEditor().getUiComponent());
        textFieldDataFim.setEditable(false);
        
        JTextField textFieldDataInicio = (JTextField)(datainicio.getDateEditor().getUiComponent());
        textFieldDataInicio.setEditable(false);

        estilo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Provencal", "Normal" }));


        horaSpin.setMaximum(23);
        horaSpin.setMinimum(0);

        minutosSpin.setMaximum(59);
        minutosSpin.setMinimum(0);

        jLabel1.setText("Quant. Convidados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jSeparator2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(localExterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Buffet)
                        .addGap(34, 34, 34)
                        .addComponent(UsarEndereco))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textoCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                            .addComponent(textoBairro))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                            .addComponent(textoNumero)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addGap(3, 3, 3))))
                                        .addComponent(jLabel8)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(horaSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(minutosSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                    .addComponent(jLabel1))
                                                .addComponent(estilo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(qntConvidados, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(datafim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(datainicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(itensPacote, javax.swing.GroupLayout.Alignment.LEADING, 0, 235, Short.MAX_VALUE)
                                                .addComponent(itensTema, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(botaoChecar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(botaoCriarPacote))))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(textocpf, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(checarCPF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buscarCliente))
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(442, 442, 442))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(botaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textocpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checarCPF)
                            .addComponent(buscarCliente)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(itensTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itensPacote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(botaoCriarPacote))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoChecar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(datainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(datafim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(horaSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutosSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(qntConvidados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(estilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsarEndereco)
                    .addComponent(Buffet)
                    .addComponent(localExterno))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(textoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoSalvar)
                            .addComponent(botaoCancelar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarTodosOsComponentesDaGUI()
    {
    	buttonGroup1 = new javax.swing.ButtonGroup();
        textocpf = new javax.swing.JTextField();
        textoNome = new javax.swing.JTextField();
        checarCPF = new javax.swing.JButton();
        buscarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        itensTema = new javax.swing.JComboBox();
        itensPacote = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        botaoCriarPacote = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        localExterno = new javax.swing.JRadioButton();
        UsarEndereco = new javax.swing.JRadioButton();
        Buffet = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        textoRua = new javax.swing.JTextField();
        textoBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        textoCEP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        textoCidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        estilo = new javax.swing.JComboBox();
        botaoChecar = new javax.swing.JButton();
        datainicio = new com.toedter.calendar.JDateChooser();
        datafim = new com.toedter.calendar.JDateChooser();
        horaSpin = new com.toedter.components.JSpinField();
        minutosSpin = new com.toedter.components.JSpinField();
        botaoCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        qntConvidados = new javax.swing.JTextField();
    }
    
    private void setarTextosNosJLabelsDaGUI()
    {
    	 jLabel1.setText("Quant. Convidados");
    	 jLabel2.setText("CPF");
         jLabel3.setText("Nome");
         jLabel4.setText("Tema");
         jLabel5.setText("Pacote");
         jLabel6.setText("Data Inico");
         jLabel7.setText("Data Fim");
         jLabel8.setText("Hora Inicial");
         jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
         jLabel9.setText("Estilo");
         jLabel10.setText("Rua");
         jLabel11.setText("Bairro");
         jLabel12.setText("Num");
         jLabel13.setText("CEP");
         jLabel14.setText("Cidade");
         jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
         jLabel15.setText("Cadastro de uma nova Festa");
    }
    
    private void setarTextoEAcaoDosBotoesDaGUI()
    {
    	checarCPF.setText("Checar CPF");
        checarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checarCPFActionPerformed(evt);
            }
        });

        buscarCliente.setText("Buscar Cliente");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        botaoCriarPacote.setText("Criar Novo Pacote");
        botaoCriarPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarPacoteActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoChecar.setText("Checar Data");
        botaoChecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoChecarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        
        datainicio.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) 
            {
                checkData = false; 
            }
            }
        );
    }
    
    
    private void checarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checarCPFActionPerformed
        String cpf = textocpf.getText();        
        Pessoa pessoa;
        pessoa = (Pessoa) DAOPessoas.buscar(cpf, "CLIENTE");        
        if(pessoa.getPnome() != null)
        {            
            textoNome.setText(pessoa.getPnome());
            textoNome.setEnabled(true);
            this.checkCliente = true;
        }
        else {
            JOptionPane.showMessageDialog(this, "CPF nao encontrado, cadastre o cliente");
        }
        
        
    }//GEN-LAST:event_checarCPFActionPerformed

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        
        TelaBuscar tela = TelaBuscar.getInstance();
        tela.setVisible(true);
        
    }//GEN-LAST:event_buscarClienteActionPerformed

    private void botaoCriarPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarPacoteActionPerformed
        
        TelaCadastrarpacote tela = new TelaCadastrarpacote();
        tela.setVisible(true);                
    }//GEN-LAST:event_botaoCriarPacoteActionPerformed

    private void botaoChecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoChecarActionPerformed
        
        String meuPacote = itensPacote.getSelectedItem().toString();
        InterfaceItemDAO it = FabricaDeDAO.criarItemDAO();
        InterfacePacoteDAO pacote = FabricaDeDAO.criarPacoteDAO();
        Pacote p = pacote.buscarPorNome(meuPacote);
        ArrayList<Item> itensMeuPacote = it.buscarItensPacote(p);        
        ArrayList<String> itensOk = new ArrayList<String>();
        ArrayList<String> itensLocados = new ArrayList<String>();
        
        InterfaceFestaDAO festas = FabricaDeDAO.criarFestaDAO();
        ArrayList<Festa> festa;                  
        Calendar dataInicial = datainicio.getCalendar();
        
        if(VerificadorCamposFormulario.dataEhValida(dataInicial) == true)
        {
        	String datainit = dataInicial.get(Calendar.DAY_OF_MONTH) + "/" + 
                    (dataInicial.get(Calendar.MONTH) + 1) 
                      + "/" + dataInicial.get(Calendar.YEAR);
      
        	festa = festas.buscarFesta(datainit); //array de feestas em uma data
        	System.out.println(festa);
        	int k = 2;
        	if(festa.isEmpty()){
          JOptionPane.showMessageDialog(this,"Data Disponivel");            
        	}
      
        	else{
              this.itensMeuPacoteApareceEmFesta(itensMeuPacote, itensOk, itensLocados, festa);
              
              
              String mensagem = verificarSeItensLocadosEstaoDisponiveisParaData(it, itensLocados);
              
              mensagem = verificarSeItensDisponiveis(itensOk, mensagem);
              mensagem = verificarSeBuffetLocadoNesseDia(festas, datainit, mensagem);
              JOptionPane.showMessageDialog(this, mensagem);
        	}
       
        	checkData = true;
        }
        
    }//GEN-LAST:event_botaoChecarActionPerformed



	private String verificarSeItensDisponiveis(ArrayList<String> itensOk, String mensagem) 
	{
		if(itensOk.size() > 0) {
		 mensagem = mensagem + " itens disponiveis \n";
		    for (int j = 0; j < itensOk.size(); j++) {
		         mensagem = mensagem + itensOk.get(j) + "\n";
		    }
		}                           
		return mensagem;
	}
	
	private String verificarSeBuffetLocadoNesseDia(InterfaceFestaDAO festas, String datainit, String mensagem)
	{
		if(Buffet.isSelected()){
			ArrayList<Festa> fest = festas.buscarFesta(datainit);
			for (int i = 0; i < fest.size(); i++) {
			    if(!fest.get(i).isExterno()){
			        mensagem = mensagem + " Buffet jah estah locado nesse dia\n";
			    }
			}
	         }
		
		return mensagem;
	}



    /*a funcao retorna uma string que eh tipo um log sobre se os itens locados estao disponiveis para a data ou nao*/
	private String verificarSeItensLocadosEstaoDisponiveisParaData(InterfaceItemDAO it, ArrayList<String> itensLocados) {
		String mensagem = "";
		int quantidade = 0;
		for (int i = 0; i < itensLocados.size(); i++) {                    
		    String iL = itensLocados.get(i);
		    for (int j = 0; j < itensLocados.size(); j++) {
		        if(j == i) {
		            j++;
		        }
		        else
		        {
		            if(itensLocados.get(j).equals(iL)){
		                quantidade++;
		            }
		            
		            Item iten = it.buscarNome(iL);
		            if(iten.getQuantidadeTotal() > quantidade){
		                mensagem = mensagem + "Nao ha " + iL + " disponivel(eis) para a data\n";
		            }
		            else {
		                mensagem = mensagem + iL + " esta disponivel para a data\n";
		            }
		        }
		    }
		   
		}
		return mensagem;
	}
	
	private void itensMeuPacoteApareceEmFesta(
			ArrayList<Item> itensMeuPacote, ArrayList<String> itensOk,
			ArrayList<String> itensLocados, ArrayList<Festa> festa) 
	{
		InterfaceItemDAO it = FabricaDeDAO.criarItemDAO();
		InterfacePacoteDAO pacote = FabricaDeDAO.criarPacoteDAO();
		for (int fest = 0; fest < festa.size(); fest++) {
		    System.out.println("entrou no for 1");
		    Festa e_festa = festa.get(fest);
		    System.out.println("peguei uma festa");
		    String f = e_festa.getPacote();
		    System.out.println("peguei o pacote da festa");
		    Pacote pak = pacote.buscarPorNome(f);
		    System.out.println("busquei o pacote");                  
		    ArrayList<Item> listaItens = it.buscarItensPacote(pak);
		    System.out.println("busquei itens");                    
		    System.out.println("criei um array de itens" + listaItens.size());                    
		    for (int j = 0; j < listaItens.size(); j++) {
		            System.out.println("entrei no for 2");
		            String itp = itensMeuPacote.get(j).getNomeItem();
		            System.out.println("itp = item do pacote");
		        for (int i = 0; i < listaItens.size(); i++) {
		            System.out.println("entrei no 3");
		            if(listaItens.get(i).getNomeItem().equalsIgnoreCase(itp)){                                                                    
		                itensLocados.add(itp);                                
		            }
		            else {
		                itensOk.add(itp);
		            }
		        }
		    }
   
		 }
	}

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        
        if(!checkData) {
            JOptionPane.showMessageDialog(this, "Verifique a data antes de salvar");
        }
        else if(!checkCliente)
        {
        	JOptionPane.showMessageDialog(this, "Verifique o cpf do cliente antes de salvar");
        }
        else 
        {

            String pacote = itensPacote.getSelectedItem().toString();
            String tema = itensTema.getSelectedItem().toString();                           
            String estiloFesta = estilo.getSelectedItem().toString();
            String cpf = textocpf.getText();
            String localFesta = textoCEP.getText();
            
            boolean algumCampoPreenchidoIncorretamente = algumDosCamposFoiPreenchidoIncorretamente(cpf, qntConvidados.getText());
            
            if(algumCampoPreenchidoIncorretamente == false)
            {
            	int quantosConvidados = Integer.parseInt(qntConvidados.getText());
                String dataFim = this.obterDataFim();       
                
                String datainicio = this.obterDataInicio();    
                if(datainicio.length() != 0 & dataInicioEhMaiorQueDataFim() == false)
                {
                	Time horaInicio = this.obterHoraInicio();                

                    boolean externoFesta = false;
                    
                    if(Buffet.isSelected())
                    {
                            externoFesta = false;
                            int resultadoDoDialog = JOptionPane.showConfirmDialog(this,"Tem certeza que deseja salvar a festa?");
                        	if(resultadoDoDialog == JOptionPane.YES_OPTION)
                        	{
                        		Festa festa = new Festa(pacote,tema,estiloFesta,cpf,quantosConvidados,localFesta,dataFim,datainicio,horaInicio,externoFesta);
                            	DAOFestas.criar(festa); 
                            	JOptionPane.showMessageDialog(this,"Festa cadastrada");
                        	}
                    } 
                    else 
                    {
                        boolean criarLocalizacaoEhPossivel = criarLocalizacaoEhPossivel();
                        if((UsarEndereco.isSelected() || localExterno.isSelected()) && criarLocalizacaoEhPossivel == true)
                        {
                            externoFesta = true;
                            this.criarLocalizacao();
                            int resultadoDoDialog = JOptionPane.showConfirmDialog(this,"Tem certeza que deseja salvar a festa?");
                            if(resultadoDoDialog == JOptionPane.YES_OPTION)
                            {
                            	Festa festa = new Festa(pacote,tema,estiloFesta,cpf,quantosConvidados,localFesta,dataFim,datainicio,horaInicio,externoFesta);
                            	DAOFestas.criar(festa); 
                            	JOptionPane.showMessageDialog(this,"Festa cadastrada");
                            }
                        }                
                    }        
                }
            }
        }

    }//GEN-LAST:event_botaoSalvarActionPerformed

    private String obterDataInicio()
    {
    	Calendar dataInicial = datainicio.getCalendar();   
    	boolean dataEhValida = VerificadorCamposFormulario.dataEhValida(dataInicial);
    	if(dataEhValida == false)
    	{
    		return "";
    	}
    	else
    	{
    		String datainicio = dataInicial.get(Calendar.YEAR) + "/" + (dataInicial.get(Calendar.MONTH) + 1)  + "/" + dataInicial.get(Calendar.DAY_OF_MONTH);
            return datainicio;
    	}
    }
    
    private String obterDataFim()
    {
    	Calendar d = datafim.getCalendar();
    	try
    	{
    		String data = d.get(Calendar.YEAR) + "/" + (d.get(Calendar.MONTH)+1) + "/" + d.get(Calendar.DAY_OF_MONTH);
    	    String dataFim = data; 
    	    return dataFim;
    	}
    	catch(Exception e)
    	{
    		//se der alguma data invalida tipo "", retorna null
    		return null;
    	}
    }
    
    private boolean dataInicioEhMaiorQueDataFim()
    {
    	Calendar dataInicial = datainicio.getCalendar();
    	Calendar dataFinal = datafim.getCalendar();
    	
    	String dataFimEmString = obterDataFim();
    	
    	if(dataFimEmString == null)
    	{
    		//a data de inicio nao eh menor que a do fim porque a do fim nao existe
    		return false;
    	}
    	else
    	{
    		int valorDaComparacao = dataInicial.compareTo(dataFinal);
    		if(valorDaComparacao > 0)
    		{
    			JOptionPane.showMessageDialog(this, "a data de inicio estah maior que a do fim, por favor insira outra data");
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    }
    
    private Time obterHoraInicio()
    {
    	int hora = horaSpin.getValue();
        int minuto = minutosSpin.getValue();        
        Time horaInicio = new Time(hora, minuto, 0);
        return horaInicio;
    }
    
    private boolean criarLocalizacaoEhPossivel()
    {
    	String bairro = textoBairro.getText();
        String cep = textoCEP.getText();
        String rua = textoRua.getText();
        String cidade = textoCidade.getText();  
        
        if(VerificadorCamposFormulario.campoComAte25CaracteresEhValido(bairro, "bairro") == true
        		&& VerificadorCamposFormulario.campoComAte25CaracteresEhValido(cep, "cep") == true
        		&& VerificadorCamposFormulario.campoComAte25CaracteresEhValido(rua, "rua") == true
        		&& VerificadorCamposFormulario.campoComAte25CaracteresEhValido(cidade, "cidade") == true 
        		&& VerificadorCamposFormulario.campoNumericoDeValorAte11EhValido(textoNumero.getText(), "numero") == true)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    
    private void criarLocalizacao()
    {                         
        String bairro = textoBairro.getText();
        String cep = textoCEP.getText();
        String rua = textoRua.getText();
        int numero = Integer.parseInt(textoNumero.getText());
        String cidade = textoCidade.getText();                              
        UID id = new UID();
        String idLocalizacao = id.toString();                                    

        Localizacao local = new Localizacao(bairro, cep, rua, numero, cidade, idLocalizacao);
        DAOLocalizacao.criar(local);
    }
    
    private void localExternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localExternoActionPerformed
        textoBairro.setEditable(true);
        textoCEP.setEditable(true);
        textoRua.setEditable(true);
        textoCidade.setEditable(true);
        textoNumero.setEditable(true);
        textoBairro.setEnabled(true);
        textoCEP.setEnabled(true);
        textoRua.setEnabled(true);
        textoCidade.setEnabled(true);
        textoNumero.setEnabled(true); 
        textoBairro.setText("");
        textoCEP.setText("");
        textoRua.setText("");
        textoCidade.setText("");
        textoNumero.setText("");    
    }//GEN-LAST:event_localExternoActionPerformed

    private void BuffetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuffetActionPerformed
        textoBairro.setEnabled(false);
        textoCEP.setEnabled(false);
        textoRua.setEnabled(false);
        textoCidade.setEnabled(false);
        textoNumero.setEnabled(false);        
        textoBairro.setText("");
        textoCEP.setText("");
        textoRua.setText("");
        textoCidade.setText("");
        textoNumero.setText("");    
        
    }//GEN-LAST:event_BuffetActionPerformed

    private void UsarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarEnderecoActionPerformed
        if(textocpf.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Digite o numero do cpf de um cliente");
        }
        textoBairro.setEnabled(false);
        textoCEP.setEnabled(false);
        textoRua.setEnabled(false);
        textoCidade.setEnabled(false);
        textoNumero.setEnabled(false);           
        Pessoa pessoa;
        pessoa = (Pessoa) this.DAOPessoas.buscar(textocpf.getText(), "CLIENTE");
                
        textoBairro.setText(pessoa.getBairro());
        textoCEP.setText(pessoa.getCep());
        textoRua.setText(pessoa.getRua());
        textoCidade.setText(pessoa.getCidade());
        textoNumero.setText(String.valueOf(pessoa.getNumero()));    
        
    }//GEN-LAST:event_UsarEnderecoActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
        TelaInicial tela = TelaInicial.getInstance();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoCancelarActionPerformed
    
    /*a funcao abaixo verifica se algum dos campos do formulario foi preenchido incorretamente*/
    private boolean algumDosCamposFoiPreenchidoIncorretamente(String cpf, String quantosConvidados)
    {
    	if(VerificadorCamposFormulario.cpfEhValido(cpf) == false)
    	{
    		return true;
    	}
    	else if(VerificadorCamposFormulario.campoNumericoDeValorAte11EhValido(quantosConvidados, "quantidade de convidados") == false)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }



	public javax.swing.JButton getBuscarCliente() {
		return buscarCliente;
	}



	public com.toedter.calendar.JDateChooser getDatainicio() {
		return datainicio;
	}

	public com.toedter.calendar.JDateChooser getDatafim() {
		return datafim;
	}



	public javax.swing.JButton getBotaoCriarPacote() {
		return botaoCriarPacote;
	}



	public javax.swing.JButton getBotaoCancelar() {
		return botaoCancelar;
	}



	public javax.swing.JTextField getTextocpf() {
		return textocpf;
	}



	public javax.swing.JButton getChecarCPF() {
		return checarCPF;
	}



	public javax.swing.JButton getBotaoChecar() {
		return botaoChecar;
	}



	public javax.swing.JTextField getQntConvidados() {
		return qntConvidados;
	}



	public javax.swing.JButton getBotaoSalvar() {
		return botaoSalvar;
	}



	public javax.swing.JRadioButton getUsarEndereco() {
		return UsarEndereco;
	}



	public javax.swing.JRadioButton getLocalExterno() {
		return localExterno;
	}
	
	
	
	
	
	
	
	
    
    
}
