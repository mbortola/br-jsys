package brjsys.gui;

//import per la parte grafica
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import per ordinare l'array
import java.util.Arrays;
//import per usare le espressioni regolari nella ricerca
import java.util.regex.Pattern;

//import per l'uso delle funzionalita' del prodotto
import brjsys.businessrules.BusinessRule;
import brjsys.communicator.GUICommunicator;
import brjsys.validator.Validator;


/**
 * 
 * Interfaccia Grafica per il prodotto Brjsys
 * @author Filippo Carraro
 * @version 1.2 16 Mar 2008
 * 
 */


public class Gui extends JFrame {
    
    /***/
	private static final long serialVersionUID = 1L;
	
	/** Array delle Business Rule nel repository*/
	private BusinessRule arrayBR[];	
	
	/** Array con i nomi delle Business Rule ordinati*/
	private String orderedBR[];

	/**  Validatore*/
	Validator compiler=null;

	/** Interfaccia con eXist*/
	GUICommunicator queryService=null;
    
	
    /**
     *  
     * Dichiarazione Componenti Grafiche 
     * 
     **/
	
	
	/** Frame principale.*/
    private JFrame mainGui;
	
	/** Frame di inserimento.*/
    private JFrame insertGui;
    
    /** Frame di rimozione.*/
    private JFrame remGui;
    
    /** Frame di querying.*/
    private JFrame sandbox;

    /***/
    private JTextField jText_Username;
    /***/
    private JTabbedPane pannelloQuery;
    /***/
    private JTabbedPane pannelloRisultati;
    /***/
    private JTextArea textAreaQuery;
    /***/
    private JTextArea textAreaRisultati;
    /***/
    private JButton jButton_CancellaIns;
    /***/
    private JButton jButton_CancellaSandbox;
    /***/
    private JButton jButton_Cerca;
    /***/
    private JButton jButton_Desel;
    /***/
    private JButton jButton_Entra;
    /***/
    private JButton jButton_EsciIns;
    /***/
    private JButton jButton_EsciSandbox;
    /***/
    private JButton jButton_Esegui;
    /***/
    private JButton jButton_Inserisci;
    /***/
    private JButton jButton_RimBR;
    /***/
    private JButton jButton_Rimuovi;
    /***/
    private JButton jButton_Sandbox;
    /***/
    private JButton jButton_Val;
    /***/
    private JComboBox jComboBox_BOAss;
    /***/
    private JLabel jLabel1_NLista2;
    /***/
    private JLabel jLabel_BOAss;
    /***/
    private JLabel jLabel_Comm;
    /***/
    private JLabel jLabel_DBOAss;
    /***/
    private JLabel jLabel_DComm;
    /***/
    private JLabel jLabel_DNome;
    /***/
    private JLabel jLabel_DReg;
    /***/
    private JLabel jLabel_NLista1;
    /***/
    private JLabel jLabel_Nome;
    /***/
    private JLabel jLabel_Password;
    /***/
    private JLabel jLabel_Reg;
    /***/
    private JLabel jLabel_Username;
    /***/
    private JPanel jPanel_DettInt;
    /***/
    private JPasswordField jPassword_Password;
    /***/
    private JScrollPane jScrollPane_Comm;
    /***/
    private JScrollPane jScrollPane_DComm;
    /***/
    private JScrollPane jScrollPane_DReg;
    /***/
    private JScrollPane jScrollPane_Query;
    /***/
    private JScrollPane jScrollPane_Ris;
    /***/
    private JSeparator jSeparator_Ins;
    /***/
    private JSeparator jSeparator_Rim;
    /***/
    private JSeparator jSeparator_Sandbox;
    /***/
    private JTabbedPane jTabbedPane_Dettagli;
    /***/
    private JTextArea jTextArea_Comm;
    /***/
    private JTextArea jTextArea_DComm;
    /***/
    private JTextArea jTextArea_DReg;
    /***/
    private JTextField jTextField_Cerca;
    /***/
    private JTextField jTextField_DBOAss;
    /***/
    private JTextField jTextField_DNome;
    /***/
    private JTextField jTextField_Nome;
    /***/
    private JTextField jTextField_Regola;
    /***/
    private Label label1;
    /***/
    private List list_BR1;
    /***/
    private List list_BR2;
    /***/
    private List list_RegIns;
    /***/
    private JLabel statusBar_Ins;
    /***/
    private JLabel statusBar_Rim;
    /***/
    private JLabel statusBar_Sandbox;


    //------------------------------------------------------
    /** Costruttore. Crea un nuovo frame e ne inizializza le componenti */
    public Gui() {
        initComponents();
    }
    //------------------------------------------------------ 
    
    //------------------------------------------------------
    /** Inizializzazione Componenti Grafiche */
    private void initComponents() {

        //------------------------------------------------------
		/**
		 * Inizializzazione Finestra Principale
		 * 
		 * @param mainGui
		 */
        mainGui = new JFrame();
        
        /** Inizializzazione delle Componenti della Finestra mainGui */
        jButton_Inserisci = new JButton();
        jButton_Rimuovi = new JButton();
        jButton_Sandbox = new JButton();
        
        //------------------------------------------------------
		/**
		 * Inizializzazione Finestra sandbox
		 * 		 
		 * @param sandbox
		 */        
        sandbox = new JFrame();
        
        /** Inizializzazione delle Componenti della Finestra sandbox */
        pannelloQuery = new JTabbedPane();
        jScrollPane_Query = new JScrollPane();
        textAreaQuery = new JTextArea();
        pannelloRisultati = new JTabbedPane();
        jScrollPane_Ris = new JScrollPane();
        textAreaRisultati = new JTextArea();
        jButton_Esegui = new JButton();
        jButton_CancellaSandbox = new JButton();
        jButton_EsciSandbox = new JButton();
        jSeparator_Sandbox = new JSeparator();
        statusBar_Sandbox = new JLabel();
        
        //------------------------------------------------------
		/**
		 * Inizializzazione Finestra Inserimento Nuova Business Rule
		 * 		 
		 * @param insertGui
		 */
        insertGui = new JFrame();
        
        /** Inizializzazione delle Componenti della Finestra Inserimento */
        jLabel_Nome = new JLabel();
        jTextField_Nome = new JTextField();
        jLabel_BOAss = new JLabel();
        jComboBox_BOAss = new JComboBox();
        jLabel_Reg = new JLabel();
        jTextField_Regola = new JTextField();
        jLabel_Comm = new JLabel();
        jScrollPane_Comm = new JScrollPane();
        jTextArea_Comm = new JTextArea();
        jButton_Val = new JButton();
        jButton_CancellaIns = new JButton();
        jButton_EsciIns = new JButton();
        label1 = new Label();
        list_RegIns = new List();
        jSeparator_Ins = new JSeparator();
        statusBar_Ins = new JLabel();
        
        //------------------------------------------------------
		/**
		 * Inizializzazione Finestra Rimozione Business Rule
		 * 		 
		 * @param remGui
		 */
        remGui = new JFrame();
        
        /** Inizializzazione delle Componenti della Finestra Rimozione */
        jTextField_Cerca = new JTextField();
        jButton_Cerca = new JButton();
        jLabel_NLista1 = new JLabel();
        list_BR1 = new List();
        jLabel1_NLista2 = new JLabel();
        list_BR2 = new List();
        jTabbedPane_Dettagli = new JTabbedPane();
        jPanel_DettInt = new JPanel();
        jLabel_DNome = new JLabel();
        jLabel_DBOAss = new JLabel();
        jLabel_DReg = new JLabel();
        jLabel_DComm = new JLabel();
        jScrollPane_DReg = new JScrollPane();
        jTextArea_DReg = new JTextArea();
        jTextField_DBOAss = new JTextField();
        jTextField_DNome = new JTextField();
        jScrollPane_DComm = new JScrollPane();
        jTextArea_DComm = new JTextArea();
        jButton_RimBR = new JButton();
        jButton_Desel = new JButton();
        jSeparator_Rim = new JSeparator();
        statusBar_Rim = new JLabel();
        
        
        //------------------------------------------------------
		/**
		 * Inizializzazione Finestra Login
		 * 		 
		 * @param LoginGui
		 */
        
        /** Inizializzazione delle Componenti della finestra di Login */
        
        jPassword_Password = new JPasswordField();
        jText_Username = new JTextField();
        jLabel_Username = new JLabel();
        jLabel_Password = new JLabel();
        jButton_Entra = new JButton();

        
		//------------------------------------------------------       
		// mainGui
		//------------------------------------------------------
        
        /* Action Listener associato al tasto Inserisci */
        jButton_Inserisci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_InserisciActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto Rimuovi */
        jButton_Rimuovi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_RimuoviActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto sandbox */
        jButton_Sandbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_SandboxActionPerformed(evt);
            }
        });
                
        
        /* Costruzione di mainGui */
        
        mainGui.setTitle("Brjsys");

        jButton_Inserisci.setFont(new Font("Tahoma", 1, 11));
        jButton_Inserisci.setText("Inserisci Business Rule");
        jButton_Rimuovi.setFont(new Font("Tahoma", 1, 11));
        jButton_Rimuovi.setText("Rimuovi Business Rule");
        jButton_Sandbox.setFont(new Font("Tahoma", 1, 11));
        jButton_Sandbox.setText("Sandbox");
        
        GroupLayout MainGuiLayout = new GroupLayout(mainGui.getContentPane());
        mainGui.getContentPane().setLayout(MainGuiLayout);
        MainGuiLayout.setHorizontalGroup(
            MainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MainGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainGuiLayout.createParallelGroup(GroupLayout.
                		Alignment.LEADING)
                    .addComponent(jButton_Inserisci, GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Rimuovi, GroupLayout.DEFAULT_SIZE,
                    		161, Short.MAX_VALUE)
                    .addComponent(jButton_Sandbox, GroupLayout.DEFAULT_SIZE,
                    		161, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainGuiLayout.setVerticalGroup(
            MainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MainGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Inserisci)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Rimuovi, GroupLayout.PREFERRED_SIZE, 23,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Sandbox)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        
		//------------------------------------------------------       
		// sandbox
		//------------------------------------------------------
        
        
        /* Action Listener associato al tasto ESEGUI */
        jButton_Esegui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_EseguiActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto CANCELLA */
        jButton_CancellaSandbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CancellaSandboxActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto ESCI */
        jButton_EsciSandbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_EsciSandboxActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto DESELEZIONA */
        jButton_Desel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_DeselActionPerformed(evt);
            }
        });
        
        /*Costruzione Di sandbox */
        
        sandbox.setBackground(new Color(184, 207, 215));
        pannelloQuery.setBackground(new Color(184, 207, 215));
        textAreaQuery.setBackground(new Color(234, 243, 246));
        textAreaQuery.setColumns(20);
        textAreaQuery.setRows(5);
        jScrollPane_Query.setViewportView(textAreaQuery);
        pannelloQuery.addTab("Query", jScrollPane_Query);
        pannelloRisultati.setBackground(new Color(184, 207, 215));
        textAreaRisultati.setBackground(new Color(234, 243, 246));
        textAreaRisultati.setColumns(20);
        textAreaRisultati.setRows(5);
        jScrollPane_Ris.setViewportView(textAreaRisultati);
        pannelloRisultati.addTab("Risultati", jScrollPane_Ris);
        jButton_Esegui.setFont(new Font("Tahoma", 1, 11));
        jButton_Esegui.setText("ESEGUI");
        jButton_CancellaSandbox.setFont(new Font("Tahoma", 1, 11));
        jButton_CancellaSandbox.setText("CANCELLA");
        jButton_EsciSandbox.setFont(new Font("Tahoma", 1, 11));
        jButton_EsciSandbox.setText("ESCI");
        statusBar_Sandbox.setText("Ready!");
        jButton_Desel.setText("Deseleziona");

        GroupLayout SandboxLayout = new GroupLayout(sandbox.getContentPane());
        sandbox.getContentPane().setLayout(SandboxLayout);
        SandboxLayout.setHorizontalGroup(
            SandboxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pannelloQuery, GroupLayout.DEFAULT_SIZE, 468,
            		Short.MAX_VALUE)
            .addComponent(pannelloRisultati, GroupLayout.DEFAULT_SIZE, 468,
            		Short.MAX_VALUE)
            .addGroup(SandboxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Esegui, GroupLayout.PREFERRED_SIZE, 113,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61,
                		Short.MAX_VALUE)
                .addComponent(jButton_CancellaSandbox,
                		GroupLayout.PREFERRED_SIZE, 103,
                		GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton_EsciSandbox, GroupLayout.PREFERRED_SIZE,
                		113, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING,
            		SandboxLayout.createSequentialGroup()
                .addGroup(SandboxLayout.createParallelGroup(
                		GroupLayout.Alignment.TRAILING)
                    .addGroup(SandboxLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(statusBar_Sandbox,
                        		GroupLayout.DEFAULT_SIZE, 448,
                        		Short.MAX_VALUE))
                    .addComponent(jSeparator_Sandbox,
                    		GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                .addContainerGap())
        );
        SandboxLayout.setVerticalGroup(
            SandboxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SandboxLayout.createSequentialGroup()
                .addComponent(pannelloQuery, GroupLayout.DEFAULT_SIZE, 161,
                		Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SandboxLayout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Esegui, GroupLayout.PREFERRED_SIZE,
                    		31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_EsciSandbox,
                    		GroupLayout.PREFERRED_SIZE, 31,
                    		GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CancellaSandbox,
                    		GroupLayout.PREFERRED_SIZE, 31,
                    		GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(pannelloRisultati,
                		GroupLayout.DEFAULT_SIZE, 161,
                		Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator_Sandbox,
                		GroupLayout.PREFERRED_SIZE, 9,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar_Sandbox)
                .addContainerGap())
        );

        
        //------------------------------------------------------       
		// insertGui
		//------------------------------------------------------
        
        
        /* Action Listener associato al tasto VALIDA */
        jButton_Val.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_ValActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto CANCELLA */
        jButton_CancellaIns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CancellaInsActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto ESCI */
        jButton_EsciIns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_EsciInsActionPerformed(evt);
            }
        });
        
        /* Mouse Listener associato alla lista list_RegIns */
        list_RegIns.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                list_RegIns_MouseClick(evt);
            }
        });
        
        /* Costruzione Di insertGui */
        
        insertGui.setBackground(new Color(255, 255, 204));
        jLabel_Nome.setFont(new Font("Tahoma", 1, 12));
        jLabel_Nome.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel_Nome.setText("Nome");
        jLabel_Nome.setMaximumSize(new Dimension(32, 14));
        jLabel_Nome.setMinimumSize(new Dimension(32, 14));
        jTextField_Nome.setBackground(new Color(234, 243, 246));
        jLabel_BOAss.setFont(new Font("Tahoma", 1, 12));
        jLabel_BOAss.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel_BOAss.setText("BO Associato");
        jLabel_BOAss.setMaximumSize(new Dimension(32, 14));
        jLabel_BOAss.setMinimumSize(new Dimension(32, 14));
        jComboBox_BOAss.setBackground(new Color(234, 243, 246));
        jComboBox_BOAss.setModel(new DefaultComboBoxModel(
        		new String[] { "Archivio","Articolo","SubArch" }));
        jLabel_Reg.setFont(new Font("Tahoma", 1, 12));
        jLabel_Reg.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel_Reg.setText("Regola");
        jTextField_Regola.setBackground(new Color(234, 243, 246));
        jLabel_Comm.setFont(new Font("Tahoma", 1, 12));
        jLabel_Comm.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel_Comm.setText("Commento");
        jTextArea_Comm.setBackground(new Color(234, 243, 246));
        jTextArea_Comm.setColumns(20);
        jTextArea_Comm.setRows(5);
        jScrollPane_Comm.setViewportView(jTextArea_Comm);
        jButton_Val.setFont(new Font("Tahoma", 1, 11));
        jButton_Val.setText("VALIDA");
        jButton_CancellaIns.setFont(new Font("Tahoma", 1, 11));
        jButton_CancellaIns.setText("CANCELLA");
        jButton_EsciIns.setFont(new Font("Tahoma", 1, 11));
        jButton_EsciIns.setText("ESCI");
        label1.setAlignment(Label.CENTER);
        label1.setFont(new Font("Tahoma", 1, 12));
        label1.setText("Regole Presenti");
        list_RegIns.setBackground(new Color(234, 243, 246));
        statusBar_Ins.setText("Ready!");

        GroupLayout insertGuiLayout = new GroupLayout(
        		insertGui.getContentPane());
        insertGui.getContentPane().setLayout(insertGuiLayout);
        insertGuiLayout.setHorizontalGroup(
            insertGuiLayout.createParallelGroup(
            		GroupLayout.Alignment.LEADING)
            .addGroup(insertGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addGroup(insertGuiLayout.createSequentialGroup()
                        .addGroup(insertGuiLayout.createParallelGroup(
                        		GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane_Comm,
                            		GroupLayout.DEFAULT_SIZE, 413,
                            		Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING,
                            		insertGuiLayout.createSequentialGroup()
                                .addComponent(jButton_Val,
                                		GroupLayout.PREFERRED_SIZE, 113,
                                		GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jButton_CancellaIns,
                                		GroupLayout.PREFERRED_SIZE, 113,
                                		GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jButton_EsciIns,
                                		GroupLayout.PREFERRED_SIZE, 113,
                                		GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_BOAss,
                            		GroupLayout.PREFERRED_SIZE, 413,
                            		GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Reg,
                            		GroupLayout.DEFAULT_SIZE, 413,
                            		Short.MAX_VALUE)
                            .addComponent(jTextField_Nome,
                            		GroupLayout.DEFAULT_SIZE, 413,
                            		Short.MAX_VALUE)
                            .addComponent(jComboBox_BOAss,
                            		0, 413, Short.MAX_VALUE)
                            .addComponent(jTextField_Regola,
                            		GroupLayout.DEFAULT_SIZE, 413,
                            		Short.MAX_VALUE)
                            .addComponent(jLabel_Comm,
                            		GroupLayout.DEFAULT_SIZE, 413,
                            		Short.MAX_VALUE)
                            .addComponent(jLabel_Nome,
                            		GroupLayout.DEFAULT_SIZE, 413,
                            		Short.MAX_VALUE))
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(insertGuiLayout.createParallelGroup(
                        		GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE,
                            		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(list_RegIns,
                            		GroupLayout.DEFAULT_SIZE, 197,
                            		Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING,
                    		insertGuiLayout.createSequentialGroup()
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusBar_Ins, GroupLayout.DEFAULT_SIZE,
                        		620, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jSeparator_Ins, GroupLayout.Alignment.TRAILING,
            		GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        insertGuiLayout.setVerticalGroup(
            insertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(insertGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 20,
                    		Short.MAX_VALUE)
                    .addComponent(jLabel_Nome, GroupLayout.PREFERRED_SIZE,
                    		19, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(insertGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addGroup(insertGuiLayout.createSequentialGroup()
                        .addComponent(jTextField_Nome,
                        		GroupLayout.PREFERRED_SIZE, 22,
                        		GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_BOAss, GroupLayout.PREFERRED_SIZE,
                        		19, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_BOAss,
                        		GroupLayout.PREFERRED_SIZE, 23,
                        		GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Reg)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Regola,
                        		GroupLayout.PREFERRED_SIZE, 22,
                        		GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Comm,
                        		GroupLayout.PREFERRED_SIZE, 14,
                        		GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane_Comm,
                        		GroupLayout.PREFERRED_SIZE, 127,
                        		GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(insertGuiLayout.createParallelGroup(
                        		GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Val,
                            		GroupLayout.PREFERRED_SIZE, 31,
                            		GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_EsciIns,
                            		GroupLayout.PREFERRED_SIZE, 31,
                            		GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_CancellaIns,
                            		GroupLayout.PREFERRED_SIZE, 31,
                            		GroupLayout.PREFERRED_SIZE)))
                    .addComponent(list_RegIns,
                    		GroupLayout.DEFAULT_SIZE, 332,
                    		Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator_Ins, GroupLayout.PREFERRED_SIZE,
                		8, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar_Ins)
                .addContainerGap())
        );

        
        //------------------------------------------------------       
		// remGui
		//------------------------------------------------------
        
        
        /* Action Listener associato al tasto CERCA */
        jButton_Cerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CercaActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto RIMUOVI SELEZIONATE */
        jButton_RimBR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_RimBRActionPerformed(evt);
            }
        });
        
        /* Action Listener associato al tasto DESELEZIONA */
        jButton_Desel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_DeselActionPerformed(evt);
            }
        });
        
        /* Mouse Listener associato alla lista list_BR1 */
        list_BR1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                list_BR1_MouseClick(evt);
            }
        });
        
        /* Costruzione Di remGui */
        
        jTextField_Cerca.setBackground(new Color(234, 243, 246));
        jButton_Cerca.setFont(new Font("Tahoma", 1, 11));
        jButton_Cerca.setText("CERCA");
        jLabel_NLista1.setFont(new Font("Tahoma", 1, 11));
        jLabel_NLista1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_NLista1.setText("Lista Completa");
        list_BR1.setBackground(new Color(234, 243, 246));
        jLabel1_NLista2.setFont(new Font("Tahoma", 1, 11));
        jLabel1_NLista2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1_NLista2.setText("Business Rules Selezionate");
        list_BR2.setBackground(new Color(234, 243, 246));
        jLabel_DNome.setText("Nome");
        jLabel_DBOAss.setText("BO Associato");
        jLabel_DReg.setText("Regola");
        jLabel_DComm.setText("Commento");
        jTextArea_DReg.setBackground(new Color(234, 243, 246));
        jTextArea_DReg.setColumns(20);
        jTextArea_DReg.setRows(5);
        jScrollPane_DReg.setViewportView(jTextArea_DReg);
        jTextField_DBOAss.setBackground(new Color(234, 243, 246));
        jTextField_DNome.setBackground(new Color(234, 243, 246));
        jTextArea_DComm.setBackground(new Color(234, 243, 246));
        jTextArea_DComm.setColumns(20);
        jTextArea_DComm.setRows(5);
        jScrollPane_DComm.setViewportView(jTextArea_DComm);

        GroupLayout jPanel_DettIntLayout = new GroupLayout(jPanel_DettInt);
        jPanel_DettInt.setLayout(jPanel_DettIntLayout);
        jPanel_DettIntLayout.setHorizontalGroup(
            jPanel_DettIntLayout.createParallelGroup(
            		GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DettIntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DettIntLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DReg)
                    .addComponent(jLabel_DBOAss)
                    .addComponent(jLabel_DNome)
                    .addComponent(jLabel_DComm))
                .addGap(10, 10, 10)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_DComm, GroupLayout.DEFAULT_SIZE,
                    		450, Short.MAX_VALUE)
                    .addComponent(jScrollPane_DReg, GroupLayout.DEFAULT_SIZE,
                    		450, Short.MAX_VALUE)
                    .addComponent(jTextField_DBOAss, GroupLayout.DEFAULT_SIZE,
                    		450, Short.MAX_VALUE)
                    .addComponent(jTextField_DNome, GroupLayout.DEFAULT_SIZE,
                    		450, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_DettIntLayout.setVerticalGroup(
            jPanel_DettIntLayout.createParallelGroup(
            		GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DettIntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DettIntLayout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DNome)
                    .addComponent(jTextField_DNome,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DBOAss)
                    .addComponent(jTextField_DBOAss, 
                    		GroupLayout.PREFERRED_SIZE, 
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DReg)
                    .addComponent(jScrollPane_DReg,
                    		GroupLayout.PREFERRED_SIZE, 117,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DComm)
                    .addComponent(jScrollPane_DComm, 
                    		GroupLayout.PREFERRED_SIZE, 117, 
                    		GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane_Dettagli.addTab("Details", jPanel_DettInt);
        jButton_RimBR.setFont(new Font("Tahoma", 1, 11));
        jButton_RimBR.setText("RIMUOVI SELEZIONATE");
        statusBar_Rim.setText("Ready!");
        jButton_Desel.setText("Deseleziona");

        GroupLayout RemGuiLayout = new GroupLayout(remGui.getContentPane());
        remGui.getContentPane().setLayout(RemGuiLayout);
        RemGuiLayout.setHorizontalGroup(
            RemGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator_Rim, GroupLayout.DEFAULT_SIZE, 568,
            		Short.MAX_VALUE)
            .addGroup(RemGuiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(statusBar_Rim, GroupLayout.DEFAULT_SIZE, 558,
                		Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING,
            		RemGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_RimBR, GroupLayout.DEFAULT_SIZE, 548,
                		Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(RemGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RemGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING,
                    		RemGuiLayout.createSequentialGroup()
                        .addComponent(jTextField_Cerca,
                        		GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Cerca))
                    .addGroup(RemGuiLayout.createSequentialGroup()
                        .addGroup(RemGuiLayout.createParallelGroup(
                        		GroupLayout.Alignment.LEADING)
                            .addComponent(list_BR1,
                            		GroupLayout.DEFAULT_SIZE, 264,
                            		Short.MAX_VALUE)
                            .addComponent(jLabel_NLista1,
                            		GroupLayout.Alignment.TRAILING,
                            		GroupLayout.DEFAULT_SIZE, 264,
                            		Short.MAX_VALUE))
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RemGuiLayout.createParallelGroup(
                        		GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1_NLista2,
                            		GroupLayout.Alignment.LEADING,
                            		GroupLayout.DEFAULT_SIZE, 274,
                            		Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING,
                            		RemGuiLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(RemGuiLayout.createParallelGroup(
                                		GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_Desel,
                                    		GroupLayout.DEFAULT_SIZE, 264,
                                    		Short.MAX_VALUE)
                                    .addComponent(list_BR2,
                                    		GroupLayout.DEFAULT_SIZE, 264,
                                    		Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(RemGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane_Dettagli, GroupLayout.DEFAULT_SIZE,
                		548, Short.MAX_VALUE)
                .addContainerGap())
        );
        RemGuiLayout.setVerticalGroup(
            RemGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING,
            		RemGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RemGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cerca)
                    .addComponent(jTextField_Cerca, GroupLayout.PREFERRED_SIZE,
                    		23, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RemGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1_NLista2, GroupLayout.PREFERRED_SIZE,
                    		14, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NLista1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RemGuiLayout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addGroup(RemGuiLayout.createSequentialGroup()
                        .addComponent(list_BR2, GroupLayout.DEFAULT_SIZE,
                        		127, Short.MAX_VALUE)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Desel))
                    .addComponent(list_BR1, GroupLayout.DEFAULT_SIZE,
                    		160, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane_Dettagli, GroupLayout.PREFERRED_SIZE,
                		GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton_RimBR, GroupLayout.PREFERRED_SIZE,
                		40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator_Rim, GroupLayout.PREFERRED_SIZE, 10,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar_Rim)
                .addContainerGap())
        );
        
        
		//------------------------------------------------------       
		// LoginGui
		//------------------------------------------------------
        
        
        /* Action Listener associato al tasto Entra */
        jButton_Entra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_EntraActionPerformed(evt);
            }
        });
        
        /* Costruzione Di LoginGui */
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginGUI");
        setBackground(new Color(134, 177, 184));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setName("LoginGUI");
        jPassword_Password.setBackground(new Color(234, 243, 246));
        jText_Username.setBackground(new Color(234, 243, 246));
        jLabel_Username.setText("Username");
        jLabel_Password.setText("Password");
        jButton_Entra.setText("Entra");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_Entra, GroupLayout.Alignment.LEADING,
                    		GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                    		Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING,
                    		layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(
                        		GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Username)
                            .addComponent(jLabel_Password))
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(
                        		GroupLayout.Alignment.LEADING, false)
                            .addComponent(jText_Username)
                            .addComponent(jPassword_Password,
                            		GroupLayout.DEFAULT_SIZE, 125,
                            		Short.MAX_VALUE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Username)
                    .addComponent(jText_Username,GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Password)
                    .addComponent(jPassword_Password, 
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Entra)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
		//------------------------------------------------------
        // Altre Impostazioni
		//------------------------------------------------------

		// Le Finestre hanno una visualizzazione di default dipendente 
		// dal sistema operativo sulle quali si fa girare l'applicazione
		setDefaultLookAndFeelDecorated(false);

		// Alla chiusura delle finestre non eseguire 
		// nessuna operazione per default
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// Alcune finestre non sono piu' ridimensionabili
		this.setResizable(false);
		mainGui.setResizable(false);
		remGui.setResizable(true);
		insertGui.setResizable(false);
		sandbox.setResizable(true);

		// Imposto alcuni campi di testo come non modificabili
		jTextField_DNome.setEditable(false);
		jTextField_DBOAss.setEditable(false);
		jTextArea_DReg.setEditable(false);
		jTextArea_DComm.setEditable(false);
		textAreaRisultati.setEditable(false);

		//------------------------------------------------------
		// Cambio la gestione della chiusura delle finestre

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(1);
			}
		});

		mainGui.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(1);
			}
		});

		insertGui.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				jButton_Inserisci.setEnabled(true);
				ripristinaInsGui();
			}
		});

		remGui.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				jButton_Rimuovi.setEnabled(true);
				ripristinaRimGui();
			}
		});

		sandbox.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				jButton_Sandbox.setEnabled(true);
				ripristinaSandbox();
			}
		});
		//------------------------------------------------------
		
		//La lista list_BR2 � a seleziona multipla
		list_BR2.setMultipleMode(true);		
		
		pack();
    }

	//------------------------------------------------------       
	// Metodi Di Supporto
	//------------------------------------------------------
    
    /** Riorganizza una specifica lista l dopo un cambiamento*/
    public void aggiornaLista(List l)
	{
		arrayBR=queryService.getListRules();
		orderedBR=new String[arrayBR.length];
		l.removeAll();

		for (int i=0;i<arrayBR.length;i++) {
			String t=new String((arrayBR[i].name));
			orderedBR[i]=t;
		}
		Arrays.sort(orderedBR);
		
		for (int i=0;i<orderedBR.length;i++) {
			l.add(orderedBR[i]);
		}
	}
	
    /** Seleziona nella lista l, la regola con nome s,
     * deselezionando(b=true) o meno(b=false) le altre*/
	public boolean cercaSelez(List l,String s,boolean b)
	{
		boolean t=false;
		
		//deseleziono tutti
		if(b){
			for (int i=0;i<arrayBR.length;i++) {
				l.deselect(i);
				}
		}
		
		for (int i=0;i<arrayBR.length;i++) {
			String h=l.getItem(i);
			if (Pattern.matches(s,h)){
				l.select(i);
				t=true;
			}
		}
		return t;
	}
	
	/** Ritorna la BusinessRule associata ad un nome(b=true)
	 *  o ad una regola (b=false)*/
	public BusinessRule getBusinessRuleAss(String n,boolean b)
	{
		BusinessRule r=new BusinessRule("","","","");
		//con b=true cerco per nome;
		
		if(b==true){
			for(int i=0;i<arrayBR.length;i++) {
				if(n.equals(arrayBR[i].name)) {
					r=arrayBR[i];
				}
			}
		}
		else{
			//con b=false cerco per regola;
			for(int i=0;i<arrayBR.length;i++) {
				if(n.equals(arrayBR[i].rule)) {
					r=arrayBR[i];
				}
			}
		}
		return r;
	}
	
	/** Ripristina Finestra Inserimento (Cancella campi e ripristina liste)*/
    public void ripristinaInsGui(){
		jTextField_Nome.setText("");
		jTextField_Regola.setText("");
		jTextArea_Comm.setText("");
		statusBar_Ins.setText("Ready!");
		aggiornaLista(list_BR1);
		aggiornaLista(list_BR2);
		aggiornaLista(list_RegIns);
    }
    
	/** Ripristina Finestra Rimozione (Cancella campi e ripristina liste)*/
    public void ripristinaRimGui(){
    	jTextField_Cerca.setText("");
		jTextField_DNome.setText("");
		jTextField_DBOAss.setText("");
		jTextArea_DReg.setText("");
		jTextArea_DComm.setText("");
		statusBar_Rim.setText("Ready!");
		aggiornaLista(list_BR1);
		aggiornaLista(list_BR2);
		aggiornaLista(list_RegIns);
    }
    
	/** Ripristina Finestra Sandbox (Cancella campi)*/
    public void ripristinaSandbox(){
    	textAreaQuery.setText("");
    	textAreaRisultati.setText("");
    	statusBar_Sandbox.setText("Ready!");
    }
    
	//------------------------------------------------------
    //------------------------------------------------------
	/* 
	 * Definizioni dei vari eventi
	 */

    //------------------------------------------------------
    /** Eventi di loginGui */
    
	/** Evento legato al pulsante Entra.*/
	private void jButton_EntraActionPerformed(ActionEvent evt) {                                              

		char[] inputP = jPassword_Password.getPassword();
		String inputU = jText_Username.getText();

		String inputPswd=new String(inputP);

		try {
			//mi connetto al server
			queryService=new GUICommunicator(inputU,  inputPswd);
			compiler=new Validator(inputU,  inputPswd);
			mainGui.pack();
			mainGui.setVisible(true);
			this.setVisible(false);
		}
		catch (Exception ecc){
				JOptionPane.showMessageDialog(this,  ecc.getMessage(),
						"ERRORE",  JOptionPane.ERROR_MESSAGE);
		} 	
	}
	
    //------------------------------------------------------
	/** Eventi di mainGui */

	/** Evento legato al pulsante Inserisci.*/
	private void jButton_InserisciActionPerformed(ActionEvent evt) {                                                  
		insertGui.pack();
		insertGui.setVisible(true);
		aggiornaLista(list_RegIns);
		insertGui.requestFocus();
		jButton_Inserisci.setEnabled(false);
	}  

	/** Evento legato al pulsante Rimuovi.*/
	private void jButton_RimuoviActionPerformed(ActionEvent evt) {                                                

		//appena apro la finestra di rimozione,  aggiorno la lista con tutte
		//le regole presenti nel repository.
		aggiornaLista(list_BR1);
		aggiornaLista(list_BR2);

		remGui.pack();
		remGui.setVisible(true);
		remGui.requestFocus();
		jButton_Rimuovi.setEnabled(false);
	}                                               

	/** Evento legato al pulsante sandbox.*/
	private void jButton_SandboxActionPerformed(ActionEvent evt) {                                                
		sandbox.pack();
		sandbox.setVisible(true);
		sandbox.requestFocus();
		jButton_Sandbox.setEnabled(false);
	}                                               
	
    //------------------------------------------------------
	/** Eventi di insertGui */
	
	/** Evento legato al pulsante Valida.*/
	private void jButton_ValActionPerformed(ActionEvent evt) {                                            
		
		String Nome=jTextField_Nome.getText();
		String BOAss=(String)jComboBox_BOAss.getSelectedItem();
		String Reg=jTextField_Regola.getText();
		String Comm=jTextArea_Comm.getText();

		BusinessRule r=new BusinessRule(Nome,  BOAss,  Reg,  Comm);
		
		try {			
			boolean v=compiler.validate(r);
			if (v) {
				
				arrayBR=queryService.getListRules();
				aggiornaLista(list_RegIns);
				// business rule viene inserita
				JOptionPane.showMessageDialog(this,  
						"Business Rule inserita e validata correttamente",  
						"Message",  JOptionPane.INFORMATION_MESSAGE);
				aggiornaLista(list_BR1);
				aggiornaLista(list_BR2);
				aggiornaLista(list_RegIns);
			}
			else {
				//la regola ha un nome che e' gia' presente nel repository.
				cercaSelez(list_RegIns,Nome,true);
				BusinessRule x=getBusinessRuleAss(Nome,true);
				statusBar_Ins.setText("Regola  :  " + x.rule);
				JOptionPane.showMessageDialog(this,
						"ERR08: Business Rule gia' presente nel repository",
						"ERRORE",  JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (Exception ecc) {
			//la regola ha un nome diverso,ma la regola stessa � gia presente 
			//nel repository.
			BusinessRule x=getBusinessRuleAss(Reg,false);
			cercaSelez(list_RegIns,x.name,true);
			statusBar_Ins.setText("Regola  :  " + x.rule);
			JOptionPane.showMessageDialog(this,  ecc.getMessage(),
					"ERRORE",  JOptionPane.ERROR_MESSAGE);
		}
		insertGui.requestFocus();
	}

	
	/** Evento legato al pulsante Cancella.*/
    private void jButton_CancellaInsActionPerformed(ActionEvent evt) {
    	ripristinaInsGui();
    	aggiornaLista(list_RegIns);
    }

    /** Evento legato al pulsante Esci.*/
    private void jButton_EsciInsActionPerformed(ActionEvent evt) {
		insertGui.setVisible(false);
		ripristinaInsGui();
		jButton_Inserisci.setEnabled(true);
		mainGui.requestFocus();
    }
	
    /** Evento legato al click del mouse sui componenti della lista.*/
    private void list_RegIns_MouseClick(MouseEvent evt) {
		int z=list_RegIns.getSelectedIndex();
		if(z!=-1){
			String nome=list_RegIns.getItem(z);
			BusinessRule x=getBusinessRuleAss(nome,true);
			statusBar_Ins.setText("Regola  :  " + x.rule);
		}
	}
    
    //------------------------------------------------------
    /** Eventi di remGui */
    
	/** Evento legato al pulsante Cerca.*/
	private void jButton_CercaActionPerformed(ActionEvent evt) {
		
		if(arrayBR.length!=0){
			//cerca il nome della business rule nella lista e lo seleziona,
			//se presente.
			String c=jTextField_Cerca.getText();

			boolean t=cercaSelez(list_BR1,c,true);
		
			BusinessRule r=getBusinessRuleAss(c,true);
			if (t) {
				// mostro le informazioni riguardanti la BR
				jTextField_DNome.setText(r.name);
				jTextField_DBOAss.setText(r.associated);
				jTextArea_DReg.setText(r.rule);
				jTextArea_DComm.setText(r.comment);
				statusBar_Rim.setText("Business Rule Selezionata !");
				cercaSelez(list_BR2,c,false);
			} else{
				jTextField_DNome.setText("");
				jTextField_DBOAss.setText("");
				jTextArea_DReg.setText("");
				jTextArea_DComm.setText("");
				statusBar_Rim.setText("Ready!");
				JOptionPane.showMessageDialog(this,
						"ERR09: Business Rule Non Trovata !",
						"ERRORE",  JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(this,
					"ERR10: Repository Vuoto !",
					"ERRORE",  JOptionPane.ERROR_MESSAGE);
		}
	}                                            

	/** Evento legato al pulsante RimBR.*/
	private void jButton_RimBRActionPerformed(ActionEvent evt) {                                              
		
		arrayBR=queryService.getListRules();
		//Messaggio per dare la conferma della cancellazione delle
		//BR selezionate
		if(arrayBR.length!=0){
			int n=JOptionPane.showConfirmDialog(this,
					"Vuoi davvero eliminare le Business Rule selezionate?",
					"Confirm",  JOptionPane.YES_NO_OPTION);
			if (n==0) {
				// L'utente conferma la cancellazione
				int[] int_sel=list_BR2.getSelectedIndexes();
				String[] BR_sel=new String[int_sel.length];

				for (int i=0;i<int_sel.length;i++) {
					BR_sel[i]=list_BR2.getItem(int_sel[i]);
				}

				for (int i=0;i<BR_sel.length;i++) {
					list_BR2.remove(BR_sel[i]);
					queryService.deleteRuleByName(BR_sel[i]);
				}
				jTextField_DNome.setText("");
				jTextField_DBOAss.setText("");
				jTextArea_DReg.setText("");
				jTextArea_DComm.setText("");
				statusBar_Rim.setText("Business Rule Cancellate!");

				aggiornaLista(list_BR1);
				aggiornaLista(list_BR2);
				aggiornaLista(list_RegIns);
			}
		}else{
			JOptionPane.showMessageDialog(this, 
					"ERR10: Repository Vuoto !",  "ERRORE", 
					JOptionPane.ERROR_MESSAGE);
		}
		remGui.requestFocus();
	}
	
	/** Evento legato al pulsante Deseleziona.*/
    private void jButton_DeselActionPerformed(ActionEvent evt) {
    	aggiornaLista(list_BR2);	
    }
    
    /** Evento legato al click del mouse sui componenti della lista.*/
    private void list_BR1_MouseClick(MouseEvent evt) {
    	int z=list_BR1.getSelectedIndex();
    	if(z!=-1){    		
    		String nome=list_BR1.getItem(z);
    		BusinessRule x=getBusinessRuleAss(nome,true);
    		jTextField_DNome.setText(x.name);
    		jTextField_DBOAss.setText(x.associated);
    		jTextArea_DReg.setText(x.rule);
    		jTextArea_DComm.setText(x.comment);
    	}
    }

    //------------------------------------------------------
    /** Eventi di sandbox */
	
	/** Evento legato al pulsante Esegui.*/
	private void jButton_EseguiActionPerformed(ActionEvent evt) {                                              

		String Query=textAreaQuery.getText();
		try {
			//calcolo il tempo dell'operazione di querying
			long prima=java.lang.System.currentTimeMillis();
			String risultato=queryService.makeQuery(Query);
			long dopo=java.lang.System.currentTimeMillis();
			textAreaRisultati.setText(risultato);
			if (risultato.length()!=0) {
				statusBar_Sandbox.setText(
						"Impiegati:" + (dopo - prima) + " millisecondi"
						);
			}
			else {
				statusBar_Sandbox.setText("Nessun Risultato Trovato");
			}

		}
		catch (Exception ecc) {
			textAreaRisultati.setText("");
			statusBar_Sandbox.setText("Ready!");
			JOptionPane.showMessageDialog(this,
					"ERR02: Query Errata",  "ERRORE",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/** Evento legato al pulsante Cancella.*/
    private void jButton_CancellaSandboxActionPerformed(ActionEvent evt) {
    	ripristinaSandbox();
    }

    /** Evento legato al pulsante Esci.*/
    private void jButton_EsciSandboxActionPerformed(ActionEvent evt) {
		sandbox.setVisible(false);
		ripristinaSandbox();
		jButton_Sandbox.setEnabled(true);
		mainGui.requestFocus();
    }
        
	
    //------------------------------------------------------
    //------------------------------------------------------
	/** Lancia la Gui */
	
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }    
}
