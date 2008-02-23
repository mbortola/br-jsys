package brjsys.gui;

/****************************************************************/
/*                      GUI	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/**
 * Summary description for GUI
 *for $i in //*[@comment] return $i
 */
public class Gui extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private Connect c=new Connect("admin","happy");
	// Variables declaration
	private JButton Inserisci;
	private JButton Cancella;
	private JButton faiQuery;
	
	private JPanel contentPane;
	// End of variables declaration
	
	public Gui()
	{
		super();
		initializeComponent();

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		Inserisci = new JButton();
		Cancella = new JButton();
		faiQuery= new JButton();
		
		contentPane = (JPanel)this.getContentPane();

		faiQuery.setBackground(Color.WHITE);
		faiQuery.setForeground(Color.BLACK);
		faiQuery.setText("Fai Query");
		faiQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){faiQuery_actionPerformed(e);}
		});
		
		
		//
		// Inserisci
		//
		Inserisci.setBackground(Color.WHITE);
		Inserisci.setForeground(Color.BLACK);
		Inserisci.setText("INSERISCI");
		Inserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Inserisci_actionPerformed(e);
			}

		});
		//
		// Cancella
		//
		Cancella.setBackground(Color.WHITE);
		Cancella.setForeground(Color.BLACK);
		Cancella.setText("CANCELLA");
		Cancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Cancella_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		addComponent(contentPane, Inserisci,10,10,120,28);
		addComponent(contentPane, Cancella, 10,48,120,28);
		addComponent(contentPane,faiQuery,10,86,120,28);
		//
		// GUI
		//
		this.setTitle("Br-jsys");
		this.setLocation(new Point(3, 2));
		this.setSize(new Dimension(160,150));
		this.setResizable(false);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void Inserisci_actionPerformed(ActionEvent e)
	{
		new InsertGui();

	}

	private void Cancella_actionPerformed(ActionEvent e)
	{
		String id=JOptionPane.showInputDialog(new Frame(),"Inserisci id regola");

		// TODO: Add any handling code here

	}

	private void faiQuery_actionPerformed(ActionEvent e){
			String query=JOptionPane.showInputDialog(new Frame(),"Scrivi una Query");
			try {
	//			c.simpleQuery(query);
			} catch (Exception e1) {e1.printStackTrace();} 
	}
	
	public static void main(String[] args)
	{
		new Gui();
	}
//	= End of Testing =


}
