package brjsys.gui;


import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.GUICommunicator;
import brjsys.validator.Validator;

/**
 * Gui.java
 * 
 * Interfaccia Grafica per il prodotto Brjsys
 * @author Filippo Carraro
 * @version 0.9 5 Mar 2008
 * 
 */
public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Costruttore: Crea un nuovo frame e ne inizializza le componenti 
	 */
	public Gui() {
		initComponents(); 
	}

	/** Inizializzazione Componenti Grafiche */

	private void initComponents() {

		//------------------------------------------------------
		/*Inizializzazione Finestra Principale*/

		MainGui = new JFrame("Brjsys");

		/* Inizializzazione delle Componenti della Finestra Principale*/
		jButton_Inserisci = new JButton();
		jButton_Rimuovi = new JButton();
		jButton_Sandbox = new JButton();

		//------------------------------------------------------
		/* Inizializzazione Finestra SandBox*/

		Sandbox = new JFrame("Sandbox");

		PannelloQuery = new JTabbedPane();
		jScrollPane_Query = new JScrollPane();
		TextAreaQuery = new JTextArea();
		PannelloRisultati = new JTabbedPane();
		jScrollPane_Ris = new JScrollPane();
		TextAreaRisultati = new JTextArea();
		jButton_Esegui = new JButton();
		jSeparator = new JSeparator();
		statusBar = new JLabel();

		//------------------------------------------------------
		/*Inizializzazione Finestra Inserimento Nuova Business Rule*/
		InsertGui = new JFrame("Inserisci");

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

		RemGui = new JFrame("Rimuovi");

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
		/**
		 * Inizializzazione Finestra Login
		 **/

		/* Inizializzazione delle Componenti della Finestra di Login */
		jPassword_Password = new JPasswordField();
		JText_Username = new JTextField();
		jLabel_Username = new JLabel();
		jLabel_Password = new JLabel();
		jButton_Entra = new JButton();



		//------------------------------------------------------       
		// MainGui
		//------------------------------------------------------
		/* Action Listener associato al tasto Inserisci */
		jButton_Inserisci.setText("Inserisci Business Rule");
		jButton_Inserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_InserisciActionPerformed(evt);
			}
		});

		/** Action Listener associato al tasto Rimuovi */

		jButton_Rimuovi.setText("Rimuovi Business Rule");
		jButton_Rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_RimuoviActionPerformed(evt);
			}
		});

		/* Action Listener associato al tasto Sandbox */
		jButton_Sandbox.setText("Sandbox");
		jButton_Sandbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_SandboxActionPerformed(evt);
			}
		});

		/* 
		 * Costruzione Di MainGui 
		 */

		GroupLayout MainGuiLayout = new GroupLayout(MainGui.getContentPane());
		MainGui.getContentPane().setLayout(MainGuiLayout);

		MainGuiLayout.setHorizontalGroup(
				MainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(MainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(MainGuiLayout.createParallelGroup(
								GroupLayout.Alignment.TRAILING)
								.addComponent(jButton_Sandbox, 
										GroupLayout.Alignment.LEADING, 
										GroupLayout.DEFAULT_SIZE, 
										139, Short.MAX_VALUE)
										.addGroup(GroupLayout.Alignment.LEADING, 
												MainGuiLayout.createParallelGroup(
														GroupLayout.Alignment.LEADING,
														false)
														.addComponent(jButton_Inserisci,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
																.addComponent(jButton_Rimuovi,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
		);
		MainGuiLayout.setVerticalGroup(
				MainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(MainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton_Inserisci)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton_Rimuovi)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton_Sandbox, GroupLayout.DEFAULT_SIZE,
								49, Short.MAX_VALUE)
								.addContainerGap())
		);

		//------------------------------------------------------       
		// Sandbox
		//------------------------------------------------------

		/* Action Listener associato al tasto Esegui */
		jButton_Esegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_EseguiActionPerformed(evt);
			}
		});

		/*
		 * Costruzione Di Sandbox 
		 */

		Sandbox.setBackground(new java.awt.Color(184, 207, 215));

		PannelloQuery.setBackground(new java.awt.Color(184, 207, 215));

		TextAreaQuery.setBackground(new java.awt.Color(255, 255, 204));
		TextAreaQuery.setColumns(20);
		TextAreaQuery.setRows(5);
		jScrollPane_Query.setViewportView(TextAreaQuery);

		PannelloQuery.addTab("Query", jScrollPane_Query);

		PannelloRisultati.setBackground(new java.awt.Color(184, 207, 215));

		TextAreaRisultati.setBackground(new java.awt.Color(255, 255, 204));
		TextAreaRisultati.setColumns(20);
		TextAreaRisultati.setRows(5);
		jScrollPane_Ris.setViewportView(TextAreaRisultati);
		TextAreaRisultati.setEditable(false);

		PannelloRisultati.addTab("Risultati", jScrollPane_Ris);

		jButton_Esegui.setText("Esegui");

		statusBar.setText("Waiting...");


		GroupLayout SandboxLayout = new GroupLayout(Sandbox.getContentPane());
		Sandbox.getContentPane().setLayout(SandboxLayout);
		SandboxLayout.setHorizontalGroup(
				SandboxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(PannelloQuery, GroupLayout.DEFAULT_SIZE, 468,
						Short.MAX_VALUE)
						.addComponent(jButton_Esegui, GroupLayout.DEFAULT_SIZE,
								468,
								Short.MAX_VALUE)
								.addComponent(jSeparator,
										GroupLayout.DEFAULT_SIZE, 468,
										Short.MAX_VALUE)
										.addComponent(PannelloRisultati,
												GroupLayout.DEFAULT_SIZE,
												468, Short.MAX_VALUE)
												.addComponent(statusBar,
														GroupLayout.DEFAULT_SIZE,
														468,
														Short.MAX_VALUE)
		);
		SandboxLayout.setVerticalGroup(
				SandboxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(SandboxLayout.createSequentialGroup()
						.addComponent(PannelloQuery, GroupLayout.PREFERRED_SIZE,
								161, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton_Esegui, GroupLayout.PREFERRED_SIZE,
										32, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(PannelloRisultati, GroupLayout.PREFERRED_SIZE,
												161, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, 10,
														GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(statusBar)
														.addContainerGap(GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))

		);

		//------------------------------------------------------       
		// InsertGui
		//------------------------------------------------------

		/** Action Listener associato al tasto Valida */
		jButton_Val.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_ValActionPerformed(evt);
			}
		});

		/*
		 * Costruzione Di InsertGui 
		 */

		InsertGui.setBackground(new java.awt.Color(255, 255, 204));

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

		GroupLayout InsertGuiLayout = new GroupLayout(InsertGui.getContentPane());
		InsertGui.getContentPane().setLayout(InsertGuiLayout);
		InsertGuiLayout.setHorizontalGroup(
				InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, InsertGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(jButton_Val, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
								.addGroup(InsertGuiLayout.createSequentialGroup()
										.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_Nome)
												.addComponent(jLabel_BOAss)
												.addComponent(jLabel_Reg)
												.addComponent(jLabel_Comm))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(jScrollPane_Reg, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
														.addComponent(jTextField_BOAss, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
														.addComponent(jTextField_Nome, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
														.addComponent(jScrollPane_Comm, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
														.addContainerGap())
		);
		InsertGuiLayout.setVerticalGroup(
				InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(InsertGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel_Nome)
								.addComponent(jTextField_Nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_BOAss)
										.addComponent(jTextField_BOAss, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_Reg)
												.addComponent(jScrollPane_Reg, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(InsertGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel_Comm)
														.addComponent(jScrollPane_Comm, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jButton_Val, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		//------------------------------------------------------       
		// RemGui
		//------------------------------------------------------

		/* Action Listener associato al tasto RimBRAssociate */
		jButton_RimBR.setText("RIMUOVI SELEZIONATE");
		jButton_RimBR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_RimBRActionPerformed(evt);
			}
		});

		/* Action Listener associato al tasto Valida */
		jButton_Cerca.setText("CERCA");
		jButton_Cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_CercaActionPerformed(evt);
			}
		});

		/* 
		 * Costruzione Di RemGui 
		 */

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
								.addGap(10, 10, 10)
								.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane_DComm, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
										.addComponent(jScrollPane_DReg, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
										.addComponent(jTextField_DBOAss, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
										.addComponent(jTextField_DNome, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
										.addContainerGap())
		);
		jPanel_DettIntLayout.setVerticalGroup(
				jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel_DettIntLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel_DNome)
								.addComponent(jTextField_DNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_DBOAss)
										.addComponent(jTextField_DBOAss, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_DReg)
												.addComponent(jScrollPane_DReg, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel_DettIntLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel_DComm)
														.addComponent(jScrollPane_DComm, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jTabbedPane_Dettagli.addTab("Details", jPanel_DettInt);

		GroupLayout RemGuiLayout = new GroupLayout(RemGui.getContentPane());
		RemGui.getContentPane().setLayout(RemGuiLayout);
		RemGuiLayout.setHorizontalGroup(
				RemGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, RemGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(RemGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(list_BR, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING, RemGuiLayout.createSequentialGroup()
										.addComponent(jTextField_Cerca, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton_Cerca, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
										.addComponent(jButton_RimBR, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
										.addComponent(jTabbedPane_Dettagli, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
										.addContainerGap())
		);
		RemGuiLayout.setVerticalGroup(
				RemGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, RemGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(RemGuiLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButton_Cerca, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField_Cerca, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(list_BR, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTabbedPane_Dettagli, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton_RimBR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(16, 16, 16))
		);


		//------------------------------------------------------       
		// LoginGui
		//------------------------------------------------------

		setTitle("LoginGUI");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setName("LoginGUI"); 

		/** Action Listener associato al tasto Entra */
		jButton_Entra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_EntraActionPerformed(evt);
			}
		});

		/** 
		 * Costruzione Di LoginGui 
		 **/

		jLabel_Username.setText("Username");
		jLabel_Password.setText("Password");
		jButton_Entra.setText("Entra");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(jButton_Entra, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel_Username)
												.addComponent(jLabel_Password))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(JText_Username)
														.addComponent(jPassword_Password, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel_Username)
								.addComponent(JText_Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_Password)
										.addComponent(jPassword_Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton_Entra)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		//------------------------------------------------------
		//------------------------------------------------------

		// Le Finestre hanno una visualizzazione di default
		//dipendente dal sistema operativo
		// sulle quali si fa girare l'applicazione
		setDefaultLookAndFeelDecorated(false);

		// Alla chiusura delle finestre non eseguire nessuna operazione per
		// default
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// Le finestre non sono pi� ridimensionabili
		this.setResizable(false);
		MainGui.setResizable(false);
		RemGui.setResizable(false);
		InsertGui.setResizable(false);
		Sandbox.setResizable(false);

		// Imposto alcuni campi di testo come non modificabili
		jTextField_DNome.setEditable(false);
		jTextField_DBOAss.setEditable(false);
		jTextArea_DReg.setEditable(false);
		jTextArea_DComm.setEditable(false);

		// Cambio la gestione della chiusura delle finestre
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(1);
			}
		});

		MainGui.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				MainGui.setVisible(false);
				InsertGui.setVisible(false);
				RemGui.setVisible(false);
				Sandbox.setVisible(false);
				System.exit(1);
			}
		});

		InsertGui.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				jButton_Inserisci.setEnabled(true);
			}
		});

		RemGui.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				jButton_Rimuovi.setEnabled(true);
				list_BR.removeAll();
			}
		});

		Sandbox.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				jButton_Sandbox.setEnabled(true);
			}
		});

		pack();
	}


	/*
	 * Definizioni dei vari eventi
	 */


	/** LoginGui:  Evento legato al pulsante Entra*/
	private void jButton_EntraActionPerformed(ActionEvent evt) {                                              

		char[] inputP = jPassword_Password.getPassword();
		String inputU = JText_Username.getText();

		String inputPswd=new String(inputP);

		try{
			queryService=new GUICommunicator(inputU,inputPswd);
			compiler=new Validator(inputU,inputPswd);
			MainGui.pack();
			MainGui.setVisible(true);
			this.setVisible(false);
		}
		catch(Exception ecc)
		{
			JOptionPane.showMessageDialog(this,ecc.getMessage(),"Login error", 
					JOptionPane.ERROR_MESSAGE);	
		} 	
	}                                             

	/** MainGui:  Evento legato al pulsante Rimuovi*/
	private void jButton_RimuoviActionPerformed(ActionEvent evt) {                                                

		//appena apro la finestra di rimozione,aggiorno la lista con tutte
		//le regole presenti nel repository.
		ArrayBR=queryService.getListRules();
		list_BR.setMultipleMode(true);

		for(int i=0;i<ArrayBR.length;i++){
			String z=(ArrayBR[i].name);
			list_BR.add(z);
		}

		RemGui.pack();
		RemGui.setVisible(true);
		RemGui.requestFocus();
		jButton_Rimuovi.setEnabled(false);
	}                                               

	/** MainGui:  Evento legato al pulsante Inserisci*/
	private void jButton_InserisciActionPerformed(ActionEvent evt) {                                                  
		InsertGui.pack();
		InsertGui.setVisible(true);
		InsertGui.requestFocus();
		jButton_Inserisci.setEnabled(false);
	}                                                 
	/** MainGui:  Evento legato al pulsante Sandbox*/
	private void jButton_SandboxActionPerformed(ActionEvent evt) {                                                
		Sandbox.pack();
		Sandbox.setVisible(true);
		Sandbox.requestFocus();
		jButton_Sandbox.setEnabled(false);
	}                                               

	/** InsertGui:  Evento legato al pulsante Valida*/
	private void jButton_ValActionPerformed(ActionEvent evt) {                                            

		String Nome=jTextField_Nome.getText();
		String BOAss=jTextField_BOAss.getText();
		String Reg=jTextArea_Reg.getText();
		String Comm=jTextArea_Comm.getText();

		BusinessRule r=new BusinessRule(Nome,BOAss,Reg,Comm);

		try {
			boolean v=compiler.validate(r);
			if (v){
				// business rule viene inserita
				JOptionPane.showMessageDialog(this, 
						"Business Rule inserita e validata correttamente", 
						"Message",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				//la regola ha un nome che e' gia' presente nel repository.
				JOptionPane.showMessageDialog(this, 
						"Business Rule gia' presente nel repository", 
						"Message",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception ecc){
			JOptionPane.showMessageDialog(this,ecc.getMessage(),"ERROR", 
					JOptionPane.ERROR_MESSAGE);
		}
	}                                           

	/** RemGui:  Evento legato al pulsante Cerca*/
	private void jButton_CercaActionPerformed(ActionEvent evt) {                                              
		//cerca il nome della business rule nella lista e lo seleziona, 
		//se presente.
		String c=jTextField_Cerca.getText();

		boolean t=false;

		//deseleziono tutti
		for(int i=0;i<ArrayBR.length;i++){
			list_BR.deselect(i);
		}

		for(int i=0;i<ArrayBR.length;i++){
			String h=list_BR.getItem(i);
			if (c.equals(h)){
				list_BR.select(i);
				t=true;
			}
		}
		if (t){
			JOptionPane.showMessageDialog(this,"Business Rule Selezionata !", 
					"BR", JOptionPane.INFORMATION_MESSAGE);
			// mostro le informazioni riguardanti la BR
			int is=list_BR.getSelectedIndex();
			// sapendo quale indice e' selezionato so a quale BR mi riferisco.
			// ne estraggo i campi e li mostro negli appositi campi.
			jTextField_DNome.setText(ArrayBR[is].name);
			jTextField_DBOAss.setText(ArrayBR[is].associated);
			jTextArea_DReg.setText(ArrayBR[is].rule);
			jTextArea_DComm.setText(ArrayBR[is].comment);
		}else
			JOptionPane.showMessageDialog(this,"Business Rule Non Trovata !", 
					"BR", JOptionPane.ERROR_MESSAGE);
	}                                            

	/** RemGui:  Evento legato al pulsante RimBR*/
	private void jButton_RimBRActionPerformed(ActionEvent evt) {                                              

		//Messaggio per dare la conferma della cancellazione delle BR selezionate
		int n=JOptionPane.showConfirmDialog(this,
				 "Vuoi davvero eliminare le Business Rule selezionate?", 
				 "Confirm",JOptionPane.YES_NO_OPTION);
		if (n==0){
			// L'utente conferma la cancellazione

			int[] int_sel=list_BR.getSelectedIndexes();
			String[] BR_sel=new String[int_sel.length];

			for(int i=0;i<int_sel.length;i++){
				BR_sel[i]=list_BR.getItem(int_sel[i]);
			}

			for(int i=0;i<BR_sel.length;i++){
				list_BR.remove(BR_sel[i]);
				queryService.deleteRuleByName(BR_sel[i]);
			}
		}
	}                                             

	/** Sandbox:  Evento legato al pulsante Esegui*/
	private void jButton_EseguiActionPerformed(ActionEvent evt) {                                              

		String Query=TextAreaQuery.getText();
		try{
			long prima=java.lang.System.currentTimeMillis();
			String risultato=queryService.makeQuery(Query);
			long dopo=java.lang.System.currentTimeMillis();
			TextAreaRisultati.setText(risultato);
			if (risultato.length()!=0){
				statusBar.setText("Impiegati:" + (dopo - prima) +
						" millisecondi");
			}
			else{
				statusBar.setText("Nessun Risultato Trovato");
			}

		}
		catch(Exception ecc){
			JOptionPane.showMessageDialog(this,ecc.getMessage(), 
					"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Main (Programma principale ) 
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Gui().setVisible(true);
			}
		});
	}


	
	/* Dichiarazione Variabili*/
	
	/**Array delle Business Rule nel repository.*/
	private BusinessRule ArrayBR[];	

	/**Validatore*/
	Validator compiler=null;
	
	/**GUICommunicator*/
	GUICommunicator queryService=null;

	/* Dichiarazione Componenti Grafiche*/
	/**Frame per l'inserimento.*/
	private JFrame InsertGui;
	
	private JTextField JText_Username;
	/**Finestra principale.*/
	private JFrame MainGui;
	/**Pannello di inserimento query. */	
	private JTabbedPane PannelloQuery;
	/**Pannello di visualizzazione risultati query.*/
	private JTabbedPane PannelloRisultati;
	/**Pannello di rimozione business rule.*/
	private JFrame RemGui;
	/**Pannello di inserimento query.*/
	private JFrame Sandbox;
	private JTextArea TextAreaQuery;
	private JTextArea TextAreaRisultati;
	private JButton jButton_Cerca;
	private JButton jButton_Entra;
	private JButton jButton_Esegui;
	private JButton jButton_Inserisci;
	private JButton jButton_RimBR;
	private JButton jButton_Rimuovi;
	private JButton jButton_Sandbox;
	private JButton jButton_Val;
	private JLabel jLabel_BOAss;
	private JLabel jLabel_Comm;
	private JLabel jLabel_DBOAss;
	private JLabel jLabel_DComm;
	private JLabel jLabel_DNome;
	private JLabel jLabel_DReg;
	private JLabel jLabel_Nome;
	private JLabel jLabel_Password;
	private JLabel jLabel_Reg;
	private JLabel jLabel_Username;
	private JPanel jPanel_DettInt;
	private JPasswordField jPassword_Password;
	private JScrollPane jScrollPane_Comm;
	private JScrollPane jScrollPane_DComm;
	private JScrollPane jScrollPane_DReg;
	private JScrollPane jScrollPane_Query;
	private JScrollPane jScrollPane_Reg;
	private JScrollPane jScrollPane_Ris;
	private JTabbedPane jTabbedPane_Dettagli;
	private JTextArea jTextArea_Comm;
	private JTextArea jTextArea_DComm;
	private JTextArea jTextArea_DReg;
	private JTextArea jTextArea_Reg;
	private JTextField jTextField_BOAss;
	private JTextField jTextField_Cerca;
	private JTextField jTextField_DBOAss;
	private JTextField jTextField_DNome;
	private JTextField jTextField_Nome;
	private java.awt.List list_BR;
	private JSeparator jSeparator;
	private JLabel statusBar;

}