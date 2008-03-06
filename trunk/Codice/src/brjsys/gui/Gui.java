package brjsys.gui;

/**
 * Gui.java
 * 
 * Interfaccia Grafica per il prodotto Brjsys
 * @author Filippo Carraro
 * @version 5 Mar 2008
 * 
 */

//import java.util.Arrays;
import javax.swing.JOptionPane;

import brjsys.businessrules.BusinessRule;
import brjsys.communicator.GUICommunicator;
import brjsys.validator.Validator;

public class Gui extends javax.swing.JFrame {
    
    /** Creates new form GUI */
    public Gui() {
        initComponents(); 
    }
    
    /**
     * Inizializzazione
    */
 
    private void initComponents() {
    	
    	MainGui = new javax.swing.JFrame("Brjsys");
        jButton_Inserisci = new javax.swing.JButton();
        jButton_Rimuovi = new javax.swing.JButton();
        jButton_Sandbox = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_File = new javax.swing.JMenu();
        jMenuItem_Exit = new javax.swing.JMenuItem();
        jMenu_Help = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Sandbox = new javax.swing.JFrame("Sandbox");
        PannelloQuery = new javax.swing.JTabbedPane();
        jScrollPane_Query = new javax.swing.JScrollPane();
        TextAreaQuery = new javax.swing.JTextArea();
        PannelloRisultati = new javax.swing.JTabbedPane();
        jScrollPane_Ris = new javax.swing.JScrollPane();
        TextAreaRisultati = new javax.swing.JTextArea();
        jButton_Esegui = new javax.swing.JButton();
        
        jSeparator = new javax.swing.JSeparator();
        statusBar = new javax.swing.JLabel();
        
        InsertGui = new javax.swing.JFrame("Inserisci");
        jLabel_Nome = new javax.swing.JLabel();
        jTextField_Nome = new javax.swing.JTextField();
        jLabel_BOAss = new javax.swing.JLabel();
        jTextField_BOAss = new javax.swing.JTextField();
        jLabel_Reg = new javax.swing.JLabel();
        jLabel_Comm = new javax.swing.JLabel();
        jButton_Val = new javax.swing.JButton();
        jScrollPane_Reg = new javax.swing.JScrollPane();
        jTextArea_Reg = new javax.swing.JTextArea();
        jScrollPane_Comm = new javax.swing.JScrollPane();
        jTextArea_Comm = new javax.swing.JTextArea();
        RemGui = new javax.swing.JFrame("Rimuovi");
        jTextField_Cerca = new javax.swing.JTextField();
        jButton_RimBR = new javax.swing.JButton();
        jButton_Cerca = new javax.swing.JButton();
        jTabbedPane_Dettagli = new javax.swing.JTabbedPane();
        jPanel_DettInt = new javax.swing.JPanel();
        jLabel_DNome = new javax.swing.JLabel();
        jLabel_DBOAss = new javax.swing.JLabel();
        jLabel_DReg = new javax.swing.JLabel();
        jLabel_DComm = new javax.swing.JLabel();
        jScrollPane_DReg = new javax.swing.JScrollPane();
        jTextArea_DReg = new javax.swing.JTextArea();
        jTextField_DBOAss = new javax.swing.JTextField();
        jTextField_DNome = new javax.swing.JTextField();
        jScrollPane_DComm = new javax.swing.JScrollPane();
        jTextArea_DComm = new javax.swing.JTextArea();
        list_BR = new java.awt.List();
        jPassword_Password = new javax.swing.JPasswordField();
        JText_Username = new javax.swing.JTextField();
        jLabel_Username = new javax.swing.JLabel();
        jLabel_Password = new javax.swing.JLabel();
        jButton_Entra = new javax.swing.JButton();

    	setDefaultLookAndFeelDecorated(false);
    	
    	this.setResizable(false);
    	MainGui.setResizable(false);
    	RemGui.setResizable(false);
    	InsertGui.setResizable(false);
    	Sandbox.setResizable(false);
    	
        jButton_Inserisci.setText("Inserisci Business Rule");
        jButton_Inserisci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InserisciActionPerformed(evt);
            }
        });

        jButton_Rimuovi.setText("Rimuovi Business Rule");
        jButton_Rimuovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RimuoviActionPerformed(evt);
            }
        });

        jButton_Sandbox.setText("Sandbox");
        jButton_Sandbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SandboxActionPerformed(evt);
            }
        });

        jMenu_File.setText("File");

        jMenuItem_Exit.setText("Exit");
        jMenu_File.add(jMenuItem_Exit);

        jMenuBar1.add(jMenu_File);

        jMenu_Help.setText("Help");

        jMenuItem1.setText("About");
        jMenu_Help.add(jMenuItem1);

        jMenuBar1.add(jMenu_Help);

        javax.swing.GroupLayout MainGuiLayout = new javax.swing.GroupLayout(MainGui.getContentPane());
        MainGui.getContentPane().setLayout(MainGuiLayout);
        
        MainGuiLayout.setHorizontalGroup(
            MainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Sandbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_Inserisci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Rimuovi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainGuiLayout.setVerticalGroup(
            MainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Inserisci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Rimuovi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Sandbox, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        
        javax.swing.GroupLayout SandboxLayout = new javax.swing.GroupLayout(Sandbox.getContentPane());
        Sandbox.getContentPane().setLayout(SandboxLayout);
        SandboxLayout.setHorizontalGroup(
            SandboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PannelloQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addComponent(jButton_Esegui, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addComponent(PannelloRisultati, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        SandboxLayout.setVerticalGroup(
            SandboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SandboxLayout.createSequentialGroup()
                .addComponent(PannelloQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Esegui, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PannelloRisultati, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                
        );

        jButton_Esegui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EseguiActionPerformed(evt);
            }
        });
        
        InsertGui.setBackground(new java.awt.Color(255, 255, 204));

        jLabel_Nome.setText("Nome");

        jTextField_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NomeActionPerformed(evt);
            }
        });

        jLabel_BOAss.setText("BO Associato");

        jLabel_Reg.setText("Regola");

        jLabel_Comm.setText("Commento");

        jButton_Val.setText("VALIDA");
        jButton_Val.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ValActionPerformed(evt);
            }
        });

        jTextArea_Reg.setColumns(20);
        jTextArea_Reg.setRows(5);
        jScrollPane_Reg.setViewportView(jTextArea_Reg);

        jTextArea_Comm.setColumns(20);
        jTextArea_Comm.setRows(5);
        jScrollPane_Comm.setViewportView(jTextArea_Comm);

        javax.swing.GroupLayout InsertGuiLayout = new javax.swing.GroupLayout(InsertGui.getContentPane());
        InsertGui.getContentPane().setLayout(InsertGuiLayout);
        InsertGuiLayout.setHorizontalGroup(
            InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InsertGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addGroup(InsertGuiLayout.createSequentialGroup()
                        .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Nome)
                            .addComponent(jLabel_BOAss)
                            .addComponent(jLabel_Reg)
                            .addComponent(jLabel_Comm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane_Reg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jTextField_BOAss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jTextField_Nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jScrollPane_Comm, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                .addContainerGap())
        );
        InsertGuiLayout.setVerticalGroup(
            InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Nome)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_BOAss)
                    .addComponent(jTextField_BOAss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Reg)
                    .addComponent(jScrollPane_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Comm)
                    .addComponent(jScrollPane_Comm, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Val, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField_Cerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CercaActionPerformed(evt);
            }
        });

        jButton_RimBR.setText("RIMUOVI SELEZIONATE");
        jButton_RimBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RimBRActionPerformed(evt);
            }
        });

        jButton_Cerca.setText("CERCA");
        jButton_Cerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CercaActionPerformed(evt);
            }
        });

        jLabel_DNome.setText("Nome");

        jLabel_DBOAss.setText("BO Associato");

        jLabel_DReg.setText("Regola");

        jLabel_DComm.setText("Commento");

        jTextArea_DReg.setColumns(20);
        jTextArea_DReg.setRows(5);
        jScrollPane_DReg.setViewportView(jTextArea_DReg);

        jTextField_DNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DNomeActionPerformed(evt);
            }
        });

        jTextArea_DComm.setColumns(20);
        jTextArea_DComm.setRows(5);
        jScrollPane_DComm.setViewportView(jTextArea_DComm);

        javax.swing.GroupLayout jPanel_DettIntLayout = new javax.swing.GroupLayout(jPanel_DettInt);
        jPanel_DettInt.setLayout(jPanel_DettIntLayout);
        jPanel_DettIntLayout.setHorizontalGroup(
            jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DettIntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DReg)
                    .addComponent(jLabel_DBOAss)
                    .addComponent(jLabel_DNome)
                    .addComponent(jLabel_DComm))
                .addGap(10, 10, 10)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_DComm, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jScrollPane_DReg, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jTextField_DBOAss, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jTextField_DNome, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_DettIntLayout.setVerticalGroup(
            jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DettIntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DNome)
                    .addComponent(jTextField_DNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DBOAss)
                    .addComponent(jTextField_DBOAss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DReg)
                    .addComponent(jScrollPane_DReg, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DettIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DComm)
                    .addComponent(jScrollPane_DComm, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane_Dettagli.addTab("Details", jPanel_DettInt);

        javax.swing.GroupLayout RemGuiLayout = new javax.swing.GroupLayout(RemGui.getContentPane());
        RemGui.getContentPane().setLayout(RemGuiLayout);
        RemGuiLayout.setHorizontalGroup(
            RemGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RemGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(list_BR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RemGuiLayout.createSequentialGroup()
                        .addComponent(jTextField_Cerca, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Cerca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_RimBR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jTabbedPane_Dettagli, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                .addContainerGap())
        );
        RemGuiLayout.setVerticalGroup(
            RemGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RemGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cerca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Cerca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list_BR, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane_Dettagli, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_RimBR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        setTitle("LoginGUI");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("LoginGUI"); 
        
        jPassword_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword_PasswordActionPerformed(evt);
            }
        });

        JText_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText_UsernameActionPerformed(evt);
            }
        });

        jLabel_Username.setText("Username");

        jLabel_Password.setText("Password");

        jButton_Entra.setText("Entra");
        jButton_Entra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EntraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_Entra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Username)
                            .addComponent(jLabel_Password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JText_Username)
                            .addComponent(jPassword_Password, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Username)
                    .addComponent(JText_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Password)
                    .addComponent(jPassword_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Entra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField_DNome.setEditable(false);
        jTextField_DBOAss.setEditable(false);
        jTextArea_DReg.setEditable(false);
        jTextArea_DComm.setEditable(false);
        
        // Cambio la gestione della chiusura delle finestre
        MainGui.addWindowListener(new java.awt.event.WindowAdapter(){
        	public void windowClosing(java.awt.event.WindowEvent e)
        	{
        		MainGui.setVisible(false);
        		InsertGui.setVisible(false);
        		RemGui.setVisible(false);
        		Sandbox.setVisible(false);
        		System.exit(1);
        	}
        });
        
        InsertGui.addWindowListener(new java.awt.event.WindowAdapter(){
        	public void windowClosing(java.awt.event.WindowEvent e)
        	{
        		jButton_Inserisci.setEnabled(true);
        	}
        });
        
        RemGui.addWindowListener(new java.awt.event.WindowAdapter(){
        	public void windowClosing(java.awt.event.WindowEvent e)
        	{
        		jButton_Rimuovi.setEnabled(true);
        		list_BR.removeAll();
        	}
        });
        
        Sandbox.addWindowListener(new java.awt.event.WindowAdapter(){
        	public void windowClosing(java.awt.event.WindowEvent e)
        	{
        		jButton_Sandbox.setEnabled(true);
        	}
        });
        
        pack();
    }// </editor-fold>

    private void jPassword_PasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    	
    }                                                  

    //  ENTRA
    private void jButton_EntraActionPerformed(java.awt.event.ActionEvent evt) {                                              
               
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
        	JOptionPane.showMessageDialog(this,ecc.getMessage(),"Login error",JOptionPane.ERROR_MESSAGE);	
        } 	
}                                             
    
    //  RIMUOVI
    private void jButton_RimuoviActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
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
        jButton_Rimuovi.setEnabled(false);
}                                               

    private void JText_UsernameActionPerformed(java.awt.event.ActionEvent evt) {                                               
}                                              

    //	INSERISCI
    private void jButton_InserisciActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        InsertGui.pack();
        InsertGui.setVisible(true);
        jButton_Inserisci.setEnabled(false);
}                                                 
    //	SANDBOX
    private void jButton_SandboxActionPerformed(java.awt.event.ActionEvent evt) {                                                
        Sandbox.pack();
        Sandbox.setVisible(true);
        jButton_Sandbox.setEnabled(false);
    }                                               
    
    //  VALIDA
    private void jButton_ValActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	
    	String Nome=jTextField_Nome.getText();
    	String BOAss=jTextField_BOAss.getText();
    	String Reg=jTextArea_Reg.getText();
    	String Comm=jTextArea_Comm.getText();
    	
    	BusinessRule r=new BusinessRule(Nome,BOAss,Reg,Comm);
    	
    	try {
    		boolean v=compiler.validate(r);
    		if(v){
    			// business rule viene inserita
    			JOptionPane.showMessageDialog(this,"Business Rule inserita e validata correttamente","Message",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else{
    			//la regola ha un nome che � gi� presente nel repository.
    			JOptionPane.showMessageDialog(this,"Business Rule gi� presente nel repository","Message",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}
    	catch (Exception ecc){
    		JOptionPane.showMessageDialog(this,ecc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    	}
}                                           

    //  CERCA
    private void jButton_CercaActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	//cerca il nome della business rule nella lista e lo seleziona,se presente.
    	String c=jTextField_Cerca.getText();
    	
    	boolean t=false;
    	
    	//deseleziono tutti
    	for(int i=0;i<ArrayBR.length;i++){
    		list_BR.deselect(i);
    	}
    	
    	for(int i=0;i<ArrayBR.length;i++){
    		String h=list_BR.getItem(i);
    		if(c.equals(h)){
    			list_BR.select(i);
    			t=true;
    		}
    	}
    	if(t){
    		JOptionPane.showMessageDialog(this,"Business Rule Selezionata !","BR",JOptionPane.INFORMATION_MESSAGE);
    		// mostro le informazioni riguardanti la BR
    		int is=list_BR.getSelectedIndex();
    		// sapendo quale indice � selezionato so a quale BR mi riferisco.
    		// ne estraggo i campi e li mostro negli appositi campi.
    		jTextField_DNome.setText(ArrayBR[is].name);
    		jTextField_DBOAss.setText(ArrayBR[is].associated);
    		jTextArea_DReg.setText(ArrayBR[is].rule);
    		jTextArea_DComm.setText(ArrayBR[is].comment);
    	}else
    		JOptionPane.showMessageDialog(this,"Business Rule Non Trovata !","BR",JOptionPane.ERROR_MESSAGE);
}                                             

    private void jTextField_NomeActionPerformed(java.awt.event.ActionEvent evt) {                                                

}                                               
    
    //  RIMUOVI SELEZIONATE
    private void jButton_RimBRActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    	//Messaggio per dare la conferma della cancellazione delle BR selezionate
    	int n=JOptionPane.showConfirmDialog(this,"Vuoi davvero eliminare le Business Rule selezionate?","Confirm",JOptionPane.YES_NO_OPTION);
    	if(n==0){
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

    //  ESEGUI QUERY
    private void jButton_EseguiActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	
    	String Query=TextAreaQuery.getText();
    	try{
    		java.util.Date d=new java.util.Date();
    		long prima=d.getTime();
    		String risultato=queryService.makeQuery(Query);
    		long dopo=d.getTime();
    		TextAreaRisultati.setText(risultato);
    		statusBar.setText("Impiegati:" + (dopo - prima) + " millisecondi");
    	}
    	catch(Exception ecc){
    		JOptionPane.showMessageDialog(this,ecc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    private void jTextField_CercaActionPerformed(java.awt.event.ActionEvent evt) {                                                 

}                                                

    private void jTextField_DNomeActionPerformed(java.awt.event.ActionEvent evt) {                                                 

}   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new Gui().setVisible(true);
            }
        });
    }
    
    //-------------------------------------------------------
    // Dichiarazione variabili
    //-------------------------------------------------------	
    
    //  array delle business rules
    private BusinessRule ArrayBR[];	
    
	Validator compiler=null;
	GUICommunicator queryService=null;
    
    private javax.swing.JFrame InsertGui;
    private javax.swing.JTextField JText_Username;
    private javax.swing.JFrame MainGui;
    private javax.swing.JTabbedPane PannelloQuery;
    private javax.swing.JTabbedPane PannelloRisultati;
    private javax.swing.JFrame RemGui;
    private javax.swing.JFrame Sandbox;
    private javax.swing.JTextArea TextAreaQuery;
    private javax.swing.JTextArea TextAreaRisultati;
    private javax.swing.JButton jButton_Cerca;
    private javax.swing.JButton jButton_Entra;
    private javax.swing.JButton jButton_Esegui;
    private javax.swing.JButton jButton_Inserisci;
    private javax.swing.JButton jButton_RimBR;
    private javax.swing.JButton jButton_Rimuovi;
    private javax.swing.JButton jButton_Sandbox;
    private javax.swing.JButton jButton_Val;
    private javax.swing.JLabel jLabel_BOAss;
    private javax.swing.JLabel jLabel_Comm;
    private javax.swing.JLabel jLabel_DBOAss;
    private javax.swing.JLabel jLabel_DComm;
    private javax.swing.JLabel jLabel_DNome;
    private javax.swing.JLabel jLabel_DReg;
    private javax.swing.JLabel jLabel_Nome;
    private javax.swing.JLabel jLabel_Password;
    private javax.swing.JLabel jLabel_Reg;
    private javax.swing.JLabel jLabel_Username;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_Exit;
    private javax.swing.JMenu jMenu_File;
    private javax.swing.JMenu jMenu_Help;
    private javax.swing.JPanel jPanel_DettInt;
    private javax.swing.JPasswordField jPassword_Password;
    private javax.swing.JScrollPane jScrollPane_Comm;
    private javax.swing.JScrollPane jScrollPane_DComm;
    private javax.swing.JScrollPane jScrollPane_DReg;
    private javax.swing.JScrollPane jScrollPane_Query;
    private javax.swing.JScrollPane jScrollPane_Reg;
    private javax.swing.JScrollPane jScrollPane_Ris;
    private javax.swing.JTabbedPane jTabbedPane_Dettagli;
    private javax.swing.JTextArea jTextArea_Comm;
    private javax.swing.JTextArea jTextArea_DComm;
    private javax.swing.JTextArea jTextArea_DReg;
    private javax.swing.JTextArea jTextArea_Reg;
    private javax.swing.JTextField jTextField_BOAss;
    private javax.swing.JTextField jTextField_Cerca;
    private javax.swing.JTextField jTextField_DBOAss;
    private javax.swing.JTextField jTextField_DNome;
    private javax.swing.JTextField jTextField_Nome;
    private java.awt.List list_BR;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel statusBar;
    // End of variables declaration
    
}