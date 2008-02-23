package brjsys.gui;

import java.awt.*; 
import java.awt.event.*; 
import java.io.IOException;

import javax.swing.*; 

public class InsertGui extends JFrame{ 
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1; 
	private JLabel jLabel2; 
	private JLabel jLabel3; 
	private JLabel jLabel4;
	
	private JTextField jTextField1; 
	private JTextField jTextField2; 
	private JTextField jTextField3;
	private JTextField jTextField4; 
	private JButton jButton1; 
	private JPanel contentPane; 

	public InsertGui(){ 
		super(); 
		initializeComponent(); 
		this.setVisible(true); 
	} 

	private void initializeComponent(){
		
		jLabel1 = new JLabel(); 
		jLabel2 = new JLabel(); 
		jLabel3 = new JLabel(); 
		jLabel4 = new JLabel(); 
		
		jTextField1 = new JTextField(); 
		jTextField2 = new JTextField(); 
		jTextField3 = new JTextField(); 
		jTextField4 = new JTextField();

		jButton1 = new JButton(); 
		contentPane = (JPanel)this.getContentPane(); 
		Font f= new Font("serif",Font.BOLD,12);

		jLabel1.setFont(f);
		jLabel2.setFont(f);
		jLabel3.setFont(f);
		jLabel4.setFont(f);

		jLabel1.setText("Nome"); 
		jLabel2.setText("Associato"); 
		jLabel3.setText("Regola"); 
		jLabel4.setText("Commento"); 

		jTextField1.setText(""); 
		jTextField2.setText(""); 
		jTextField3.setText(""); 
		jTextField4.setText(""); 
		
		jButton1.setBackground(Color.WHITE);
		jButton1.setForeground(Color.RED);
		jButton1.setText("Validazione"); 
		jButton1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				try {
					jButton1_actionPerformed(e);
				} catch (IOException e1) {	} 
			} 
		}); 

		contentPane.setLayout(null); 
		addComponent(contentPane, jLabel1, 20,10,70,18); 
		addComponent(contentPane, jLabel2, 20,60,70,18); 
		addComponent(contentPane, jLabel3, 20,110,70,18); 
		addComponent(contentPane, jLabel4, 20,160,70,18); 
		
		addComponent(contentPane, jTextField1, 110,60,100,22); 
		addComponent(contentPane, jTextField2, 110,110,225,22); 
		addComponent(contentPane, jTextField3, 110,160,100,22);
		addComponent(contentPane, jTextField4, 110,10,100,22);
		
		addComponent(contentPane, jButton1, 110,200,110,28); 

		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setTitle("Inserimento Business Rule"); 
		this.setLocation(new Point(0, 0)); 
		this.setSize(new Dimension(380, 280)); 
	} 


	private void addComponent(Container container,Component c,int x,int y,int width,int height) { 
		c.setBounds(x,y,width,height); 
		container.add(c); 
	} 

	private void jButton1_actionPerformed(ActionEvent e) throws IOException{
		try {
			JOptionPane.showMessageDialog(this,"Regola Inserita","Validazione effettuata",JOptionPane.DEFAULT_OPTION);
			
		} catch (Throwable e1) {e1.printStackTrace();}

	}  

} 
