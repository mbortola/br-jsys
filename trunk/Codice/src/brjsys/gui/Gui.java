package brjsys.gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.GUICommunicator;
import brjsys.validator.Validator;

/**
 * 
 * Interfaccia Grafica per il prodotto Brjsys
 * @author Filippo Carraro
 * @version 0.9 6 Mar 2008
 * 
 */

public class Gui extends JFrame {

	/***/
	private static final long serialVersionUID = 1L;
	
	/**Array delle Business Rule nel repository*/
	private BusinessRule arrayBR[];	

	/**  Validatore*/
	Validator compiler=null;

	/** Interfaccia con eXist*/
	GUICommunicator queryService=null;
	/**Frame di inserimento.*/
	private JFrame insertGui;
	/***/
	private JTextField JText_Username;
	/**Frame principale.*/
	private JFrame mainGui;
	/***/
	private JTabbedPane pannelloQuery;
	/***/
	private JTabbedPane pannelloRisultati;
	/**Frame di rimozione.*/
	private JFrame remGui;
	/**Frame di querying.*/
	private JFrame sandbox;
	/***/
	private JTextArea textAreaQuery;
	/***/
	private JTextArea textAreaRisultati;
	/***/
	private JButton jButton_Cerca;
	/***/
	private JButton jButton_Entra;
	/***/
	private JButton jButton_Esegui;
	/***/
	private JButton jButton_Inserisci;
	/***/
	private JButton jButton_RimBR;
	/***/
	private JButton jButton_Rimuovi;
	/***/
	private JButton jButton_sandbox;
	/***/
	private JButton jButton_Val;
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
	private JScrollPane jScrollPane_Reg;
	/***/
	private JScrollPane jScrollPane_Ris;
	/***/
	private JTabbedPane jTabbedPane_Dettagli;
	/***/
	private JTextArea jTextArea_Comm;
	/***/
	private JTextArea jTextArea_DComm;
	/***/
	private JTextArea jTextArea_DReg;
	/***/
	private JTextArea jTextArea_Reg;
	/***/
	private JTextField jTextField_BOAss;
	/***/
	private JTextField jTextField_Cerca;
	/***/
	private JTextField jTextField_DBOAss;
	/***/
	private JTextField jTextField_DNome;
	/***/
	private JTextField jTextField_Nome;
	/***/
	private java.awt.List list_BR;
	/***/
	private JSeparator jSeparator;
	/***/
	private JLabel statusBar;

	/**Costruttore. Crea un nuovo frame e ne inizializza le componenti */
	public Gui() {
		initComponents(); 
	}

	/** Inizializzazione Componenti Grafiche */

	private void initComponents() {

		//------------------------------------------------------
		/*
		 * Inizializzazione Finestra Principale
		 * 
		 * @param mainGui
		 */

		mainGui = new JFrame("Brjsys");

		/* Inizializzazione delle Componenti della Finestra Principale*/
		jButton_Inserisci = new JButton();
		jButton_Rimuovi = new JButton();
		jButton_sandbox = new JButton();

		//------------------------------------------------------
		/*Inizializzazione Finestra sandbox*/

		sandbox = new JFrame("Sandbox");

		/*Inizializzazione delle Componenti della Finestra sandbox*/
		pannelloQuery = new JTabbedPane();
		jScrollPane_Query = new JScrollPane();
		textAreaQuery = new JTextArea();
		pannelloRisultati = new JTabbedPane();
		jScrollPane_Ris = new JScrollPane();
		textAreaRisultati = new JTextArea();
		jButton_Esegui = new JButton();
		jSeparator = new JSeparator();
		statusBar = new JLabel();

		//------------------------------------------------------
		/*Inizializzazione Finestra Inserimento Nuova Business Rule*/
		insertGui = new JFrame("Inserisci");

		/** Inizializzazione delle Componenti della Finestra Inserimento */
		jLabel_Nome = new JLabel();
		jTextField_Nome = new JTextField();
		jLabel_BOAss = new JLabel();
		jTextField_BOAss = new JTextField();
		jLabel_Reg = new JLabel();
		jLabel_Comm = new JLabel();
		jButton_Val = new JButton();
		jScrollPane_Reg = new JScrollPane();
		jTextArea_Reg = new JTextArea();
		jScrollPane_Comm = new JScrollPane();
		jTextArea_Comm = new JTextArea();

		//------------------------------------------------------
		/*Inizializzazione Finestra Rimozione Business Rule*/

		remGui = new JFrame("Rimuovi");

		/* Inizializzazione delle Componenti della Finestra Rimozione */
		jTextField_Cerca = new JTextField();
		jButton_RimBR = new JButton();
		jButton_Cerca = new JButton();
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
		list_BR = new List();

		//------------------------------------------------------
		/*Inizializzazione Finestra Login*/

		/* Inizializzazione delle Componenti della Finestra di Login */
		jPassword_Password = new JPasswordField();
		JText_Username = new JTextField();
		jLabel_Username = new JLabel();
		jLabel_Password = new JLabel();
		jButton_Entra = new JButton();



		//------------------------------------------------------       
		// mainGui
		//------------------------------------------------------
		/* Action Listener associato al tasto Inserisci */

		jButton_Inserisci.setText("Inserisci Business Rule");
		jButton_Inserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_InserisciActionPerformed(evt);
			}
		});

		/* Action Listener associato al tasto Rimuovi */
		jButton_Rimuovi.setText("Rimuovi Business Rule");
		jButton_Rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_RimuoviActionPerformed(evt);
			}
		});

		/* Action Listener associato al tasto sandbox */
		jButton_sandbox.setText("Sandbox");
		jButton_sandbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_sandboxActionPerformed(evt);
			}
		});

		/*Costruzione Di mainGui */
		GroupLayout mainGuiLayout = new GroupLayout(mainGui.getContentPane());
		mainGui.getContentPane().setLayout(mainGuiLayout);

		mainGuiLayout.setHorizontalGroup(
				mainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(mainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(mainGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(jButton_sandbox,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  139,  Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING,  mainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING,  false)
										.addComponent(jButton_Inserisci,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE)
										.addComponent(jButton_Rimuovi,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE)))
										.addContainerGap(GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE))
		);
		mainGuiLayout.setVerticalGroup(
				mainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(mainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton_Inserisci)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton_Rimuovi)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton_sandbox,  GroupLayout.DEFAULT_SIZE,  49,  Short.MAX_VALUE)
						.addContainerGap())
		);

		//------------------------------------------------------       
		// sandbox
		//------------------------------------------------------

		/* Action Listener associato al tasto Esegui */
		jButton_Esegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_EseguiActionPerformed(evt);
			}
		});

		/*Costruzione Di sandbox */

		sandbox.setBackground(new java.awt.Color(184,  207,  215));

		pannelloQuery.setBackground(new java.awt.Color(184,  207,  215));

		textAreaQuery.setBackground(new java.awt.Color(255,  255,  204));
		textAreaQuery.setColumns(20);
		textAreaQuery.setRows(5);
		jScrollPane_Query.setViewportView(textAreaQuery);

		pannelloQuery.addTab("Query",  jScrollPane_Query);

		pannelloRisultati.setBackground(new java.awt.Color(184,  207,  215));

		textAreaRisultati.setBackground(new java.awt.Color(255,  255,  204));
		textAreaRisultati.setColumns(20);
		textAreaRisultati.setRows(5);
		jScrollPane_Ris.setViewportView(textAreaRisultati);
		textAreaRisultati.setEditable(false);

		pannelloRisultati.addTab("Risultati",  jScrollPane_Ris);

		jButton_Esegui.setText("Esegui");

		statusBar.setText("Waiting...");


		GroupLayout sandboxLayout = new GroupLayout(sandbox.getContentPane());
		sandbox.getContentPane().setLayout(sandboxLayout);
		sandboxLayout.setHorizontalGroup(
				sandboxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(pannelloQuery,  GroupLayout.DEFAULT_SIZE,  800,  Short.MAX_VALUE)
				.addComponent(jButton_Esegui,  GroupLayout.DEFAULT_SIZE, 800,  Short.MAX_VALUE)
				.addComponent(jSeparator,  GroupLayout.DEFAULT_SIZE,  800,  Short.MAX_VALUE)
				.addComponent(pannelloRisultati,  GroupLayout.DEFAULT_SIZE,  800,  Short.MAX_VALUE)
				.addComponent(statusBar,  GroupLayout.DEFAULT_SIZE,  800,  Short.MAX_VALUE)
		);
		sandboxLayout.setVerticalGroup(
				sandboxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(sandboxLayout.createSequentialGroup()
						.addComponent(pannelloQuery,  GroupLayout.PREFERRED_SIZE,  250,  GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton_Esegui,  GroupLayout.PREFERRED_SIZE,  32,  GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pannelloRisultati,  GroupLayout.PREFERRED_SIZE,  250,  GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator,  GroupLayout.PREFERRED_SIZE,  10,  GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(statusBar)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE))

		);

		//------------------------------------------------------       
		// insertGui
		//------------------------------------------------------

		/* Action Listener associato al tasto Valida */
		jButton_Val.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_ValActionPerformed(evt);
			}
		});

		/* Costruzione Di insertGui */

		insertGui.setBackground(new java.awt.Color(255,  255,  204));

		jLabel_Nome.setText("Nome");
		jLabel_BOAss.setText("BO Associato");
		jLabel_Reg.setText("Regola");
		jLabel_Comm.setText("Commento");
		jButton_Val.setText("VALIDA");
		jTextArea_Reg.setColumns(20);
		jTextArea_Reg.setRows(5);
		jScrollPane_Reg.setViewportView(jTextArea_Reg);

		jTextArea_Comm.setColumns(20);
		jTextArea_Comm.setRows(5);
		jScrollPane_Comm.setViewportView(jTextArea_Comm);

		GroupLayout insertGuiLayout = new GroupLayout(insertGui.getContentPane());
		insertGui.getContentPane().setLayout(insertGuiLayout);
		insertGuiLayout.setHorizontalGroup(
				insertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,  insertGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(jButton_Val,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  337,  Short.MAX_VALUE)
								.addGroup(insertGuiLayout.createSequentialGroup()
										.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_Nome)
												.addComponent(jLabel_BOAss)
												.addComponent(jLabel_Reg)
												.addComponent(jLabel_Comm))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(jScrollPane_Reg,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  270,  Short.MAX_VALUE)
														.addComponent(jTextField_BOAss,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  270,  Short.MAX_VALUE)
														.addComponent(jTextField_Nome,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  270,  Short.MAX_VALUE)
														.addComponent(jScrollPane_Comm,  GroupLayout.DEFAULT_SIZE,  270,  Short.MAX_VALUE))))
														.addContainerGap())
		);
		insertGuiLayout.setVerticalGroup(
				insertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(insertGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel_Nome)
								.addComponent(jTextField_Nome,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_BOAss)
										.addComponent(jTextField_BOAss,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_Reg)
												.addComponent(jScrollPane_Reg,  GroupLayout.PREFERRED_SIZE,  117,  GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(insertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel_Comm)
														.addComponent(jScrollPane_Comm,  GroupLayout.PREFERRED_SIZE,  117,  GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jButton_Val,  GroupLayout.PREFERRED_SIZE,  36,  GroupLayout.PREFERRED_SIZE)
														.addContainerGap(GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE))
		);

		//------------------------------------------------------       
		// remGui
		//------------------------------------------------------

		/* Action Listener associato al tasto RimBRAssociate */
		jButton_RimBR.setText("RIMUOVI SELEZIONATE");
		jButton_RimBR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_RimBRActionPerformed(evt);
			}
		});

		/** Action Listener associato al tasto Valida */
		jButton_Cerca.setText("CERCA");
		jButton_Cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_CercaActionPerformed(evt);
			}
		});

		/*Costruzione Di remGui */

		jLabel_DNome.setText("Nome");
		jLabel_DBOAss.setText("BO Associato");
		jLabel_DReg.setText("Regola");
		jLabel_DComm.setText("Commento");
		jTextArea_DReg.setColumns(20);
		jTextArea_DReg.setRows(5);
		jScrollPane_DReg.setViewportView(jTextArea_DReg);
		jTextArea_DComm.setColumns(20);
		jTextArea_DComm.setRows(5);
		jScrollPane_DComm.setViewportView(jTextArea_DComm);

		GroupLayout jPanel_DettIntLayout = new GroupLayout(jPanel_DettInt);
		jPanel_DettInt.setLayout(jPanel_DettIntLayout);
		jPanel_DettIntLayout.setHorizontalGroup(
				jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel_DettIntLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel_DReg)
								.addComponent(jLabel_DBOAss)
								.addComponent(jLabel_DNome)
								.addComponent(jLabel_DComm))
								.addGap(10,  10,  10)
								.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane_DComm,  GroupLayout.DEFAULT_SIZE,  413,  Short.MAX_VALUE)
										.addComponent(jScrollPane_DReg,  GroupLayout.DEFAULT_SIZE,  413,  Short.MAX_VALUE)
										.addComponent(jTextField_DBOAss,  GroupLayout.DEFAULT_SIZE,  413,  Short.MAX_VALUE)
										.addComponent(jTextField_DNome,  GroupLayout.DEFAULT_SIZE,  413,  Short.MAX_VALUE))
										.addContainerGap())
		);
		jPanel_DettIntLayout.setVerticalGroup(
				jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel_DettIntLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel_DNome)
								.addComponent(jTextField_DNome,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_DBOAss)
										.addComponent(jTextField_DBOAss,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_DReg)
												.addComponent(jScrollPane_DReg,  GroupLayout.PREFERRED_SIZE,  117,  GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel_DComm)
														.addComponent(jScrollPane_DComm,  GroupLayout.PREFERRED_SIZE,  117,  GroupLayout.PREFERRED_SIZE))
														.addContainerGap(GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE))
		);

		jTabbedPane_Dettagli.addTab("Details",  jPanel_DettInt);

		GroupLayout remGuiLayout = new GroupLayout(remGui.getContentPane());
		remGui.getContentPane().setLayout(remGuiLayout);
		remGuiLayout.setHorizontalGroup(
				remGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,  remGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(remGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(list_BR,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  511,  Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING,  remGuiLayout.createSequentialGroup()
										.addComponent(jTextField_Cerca,  GroupLayout.PREFERRED_SIZE,  347,  GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton_Cerca,  GroupLayout.PREFERRED_SIZE,  158,  GroupLayout.PREFERRED_SIZE))
										.addComponent(jButton_RimBR,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  511,  Short.MAX_VALUE)
										.addComponent(jTabbedPane_Dettagli,  GroupLayout.DEFAULT_SIZE,  511,  Short.MAX_VALUE))
										.addContainerGap())
		);
		remGuiLayout.setVerticalGroup(
				remGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,  remGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(remGuiLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButton_Cerca,  GroupLayout.PREFERRED_SIZE,  39,  GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField_Cerca,  GroupLayout.PREFERRED_SIZE,  30,  GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(list_BR,  GroupLayout.PREFERRED_SIZE,  137,  GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTabbedPane_Dettagli,  GroupLayout.PREFERRED_SIZE,  340,  GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton_RimBR,  GroupLayout.PREFERRED_SIZE,  40,  GroupLayout.PREFERRED_SIZE)
								.addGap(16,  16,  16))
		);


		//------------------------------------------------------       
		// LoginGui
		//------------------------------------------------------

		setTitle("LoginGUI");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setName("LoginGUI"); 

		/* Action Listener associato al tasto Entra */
		jButton_Entra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_EntraActionPerformed(evt);
			}
		});

		/* Costruzione Di LoginGui */

		jLabel_Username.setText("Username");
		jLabel_Password.setText("Password");
		jButton_Entra.setText("Entra");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING,  false)
								.addComponent(jButton_Entra,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING,  layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_Username)
												.addComponent(jLabel_Password))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING,  false)
														.addComponent(JText_Username)
														.addComponent(jPassword_Password,  GroupLayout.DEFAULT_SIZE,  125,  Short.MAX_VALUE))))
														.addContainerGap(GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel_Username)
								.addComponent(JText_Username,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_Password)
										.addComponent(jPassword_Password,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton_Entra)
										.addContainerGap(GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE))
		);

		//------------------------------------------------------
		//------------------------------------------------------

		// Le Finestre hanno una visualizzazione di default dipendente dal sistema operativo
		// sulle quali si fa girare l'applicazione
		setDefaultLookAndFeelDecorated(false);

		// Alla chiusura delle finestre non eseguire nessuna operazione per default
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// Le finestre non sono piu' ridimensionabili
		this.setResizable(false);
		mainGui.setResizable(false);
		remGui.setResizable(false);
		insertGui.setResizable(false);
		sandbox.setResizable(false);

		// Imposto alcuni campi di testo come non modificabili
		jTextField_DNome.setEditable(false);
		jTextField_DBOAss.setEditable(false);
		jTextArea_DReg.setEditable(false);
		jTextArea_DComm.setEditable(false);

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
				mainGui.setVisible(false);
				insertGui.setVisible(false);
				remGui.setVisible(false);
				sandbox.setVisible(false);
				System.exit(1);
			}
		});

		insertGui.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				jButton_Inserisci.setEnabled(true);
			}
		});

		remGui.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				jButton_Rimuovi.setEnabled(true);
				list_BR.removeAll();
			}
		});

		sandbox.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				jButton_sandbox.setEnabled(true);
			}
		});
		pack();
	}

	/* 
	 * Definizioni dei vari eventi
	 */

	/** Evento legato al pulsante Entra.*/
	private void jButton_EntraActionPerformed(ActionEvent evt) {                                              

		char[] inputP = jPassword_Password.getPassword();
		String inputU = JText_Username.getText();

		String inputPswd=new String(inputP);

		try {
			queryService=new GUICommunicator(inputU,  inputPswd);
			compiler=new Validator(inputU,  inputPswd);
			mainGui.pack();
			mainGui.setVisible(true);
			this.setVisible(false);
		}
		catch (Exception ecc)
		{
			ecc.printStackTrace();
			JOptionPane.showMessageDialog(this,  ecc.getMessage(),  "Login error",  JOptionPane.ERROR_MESSAGE);	
		} 	
	}                                             

	/** Evento legato al pulsante Rimuovi.*/
	private void jButton_RimuoviActionPerformed(ActionEvent evt) {                                                

		//appena apro la finestra di rimozione,  aggiorno la lista con tutte
		//le regole presenti nel repository.
		arrayBR=queryService.getListRules();
		list_BR.setMultipleMode(true);

		for (int i=0;i<arrayBR.length;i++) {
			String z=(arrayBR[i].name);
			list_BR.add(z);
		}

		remGui.pack();
		remGui.setVisible(true);
		remGui.requestFocus();
		jButton_Rimuovi.setEnabled(false);
	}                                               

	/**Evento legato al pulsante Inserisci.*/
	private void jButton_InserisciActionPerformed(ActionEvent evt) {                                                  
		insertGui.pack();
		insertGui.setVisible(true);
		insertGui.requestFocus();
		jButton_Inserisci.setEnabled(false);
	}    
	
	/** Evento legato al pulsante sandbox.*/
	private void jButton_sandboxActionPerformed(ActionEvent evt) {                                                
		sandbox.pack();
		sandbox.setVisible(true);
		sandbox.requestFocus();
		jButton_sandbox.setEnabled(false);
	}                                               

	/** Evento legato al pulsante Valida.*/
	private void jButton_ValActionPerformed(ActionEvent evt) {                                            

		String Nome=jTextField_Nome.getText();
		String BOAss=jTextField_BOAss.getText();
		String Reg=jTextArea_Reg.getText();
		String Comm=jTextArea_Comm.getText();

		BusinessRule r=new BusinessRule(Nome,  BOAss,  Reg,  Comm);

		try {
			boolean v=compiler.validate(r);
			if (v) {
				// business rule viene inserita
				JOptionPane.showMessageDialog(this,  
						"Business Rule inserita e validata correttamente",  
						"Message",  JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				//la regola ha un nome che e' gia' presente nel repository.
				JOptionPane.showMessageDialog(this,  "Business Rule gia' presente nel repository",  "Message",  JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception ecc) {
			JOptionPane.showMessageDialog(this,  ecc.getMessage(),  "ERROR",  JOptionPane.ERROR_MESSAGE);
		}
	}                                           

	/** Evento legato al pulsante Cerca.*/
	private void jButton_CercaActionPerformed(ActionEvent evt) {                                              
		//cerca il nome della business rule nella lista e lo seleziona,  se presente.
		String c=jTextField_Cerca.getText();

		boolean t=false;

		//deseleziono tutti
		for (int i=0;i<arrayBR.length;i++) {
			list_BR.deselect(i);
		}

		for (int i=0;i<arrayBR.length;i++) {
			String h=list_BR.getItem(i);
			if (c.equals(h)) {
				list_BR.select(i);
				t=true;
			}
		}
		if (t) {
			JOptionPane.showMessageDialog(this,  "Business Rule Selezionata !",  "BR",  JOptionPane.INFORMATION_MESSAGE);
			// mostro le informazioni riguardanti la BR
			int is=list_BR.getSelectedIndex();
			// sapendo quale indice e' selezionato so a quale BR mi riferisco.
			// ne estraggo i campi e li mostro negli appositi campi.
			jTextField_DNome.setText(arrayBR[is].name);
			jTextField_DBOAss.setText(arrayBR[is].associated);
			jTextArea_DReg.setText(arrayBR[is].rule);
			jTextArea_DComm.setText(arrayBR[is].comment);
		} else
			JOptionPane.showMessageDialog(this,  "Business Rule Non Trovata !",  "BR",  JOptionPane.ERROR_MESSAGE);
	}                                            

	/** Evento legato al pulsante RimBR.*/
	private void jButton_RimBRActionPerformed(ActionEvent evt) {                                              

		//Messaggio per dare la conferma della cancellazione delle BR selezionate
		int n=JOptionPane.showConfirmDialog(this,  "Vuoi davvero eliminare le Business Rule selezionate?",  "Confirm",  JOptionPane.YES_NO_OPTION);
		if (n==0) {
			// L'utente conferma la cancellazione

			int[] int_sel=list_BR.getSelectedIndexes();
			String[] BR_sel=new String[int_sel.length];

			for (int i=0;i<int_sel.length;i++) {
				BR_sel[i]=list_BR.getItem(int_sel[i]);
			}

			for (int i=0;i<BR_sel.length;i++) {
				list_BR.remove(BR_sel[i]);
				queryService.deleteRuleByName(BR_sel[i]);
			}
		}
	}                                             

	/**Evento legato al pulsante Esegui.*/
	private void jButton_EseguiActionPerformed(ActionEvent evt) {                                              

		String Query=textAreaQuery.getText();
		try {
			long prima=java.lang.System.currentTimeMillis();
			String risultato=queryService.makeQuery(Query);
			long dopo=java.lang.System.currentTimeMillis();
			textAreaRisultati.setText(risultato);
			if (risultato.length()!=0) {
				statusBar.setText("Impiegati:" + (dopo - prima) + " millisecondi");
			}
			else {
				statusBar.setText("Nessun Risultato Trovato");
			}

		}
		catch (Exception ecc) {
			JOptionPane.showMessageDialog(this,  ecc.getMessage(),  "ERROR",  JOptionPane.ERROR_MESSAGE);
		}
	}

	/**Lancia la Gui */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Gui().setVisible(true);
			}
		});
	}
}