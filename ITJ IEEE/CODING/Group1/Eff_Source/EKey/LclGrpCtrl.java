/****************************************************************/
/*                      LclGrpCtrl	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Summary description for LclGrpCtrl
 *
 */
public class LclGrpCtrl extends JFrame
{
	// Variables declaration
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel inbox;
	private JLabel compose;
	private JLabel outbox;
	private JLabel signout;
	private JPanel contentPane;
	private String id,sctkey;
	// End of variables declaration


	public LclGrpCtrl(String id,String pass)
	{
		super();
		this.id=id;
		sctkey=pass;
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

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
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		inbox = new JLabel();
		compose = new JLabel();
		outbox = new JLabel();
		signout = new JLabel();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel2
		//
		jLabel2.setBackground(new Color(204, 204, 255));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setIcon(new ImageIcon("securenet.jpg"));
		//
		// jLabel3
		//
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel3.setText("Welcome Local Group Controller");
		jLabel3.setFont(new Font("Monotype Corsiva",Font.BOLD,40));
		//
		// inbox
		//
		inbox.setIcon(new ImageIcon("inbox.jpg"));
		inbox.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e)
		{
			inbox_mouseClicked(e);
		}
		});
		//
		// compose
		//
		compose.setIcon(new ImageIcon("compose.jpg"));
		compose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				compose_mouseClicked(e);
			}

		});
		//
		// outbox
		//
		outbox.setIcon(new ImageIcon("outbox.jpg"));
		outbox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				outbox_mouseClicked(e);
			}

		});
		//
		// signout
		//
		signout.setIcon(new ImageIcon("signout.jpg"));
		signout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				signout_mouseClicked(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(204, 204, 255));
		addComponent(contentPane, jLabel2, 143,105,663,261);
		addComponent(contentPane, jLabel3, 130,50,599,35);
		addComponent(contentPane, inbox, 30,478,141,36);
		addComponent(contentPane, compose, 510,478,141,36);
		addComponent(contentPane, outbox, 270,478,141,36);
		addComponent(contentPane, signout, 750,478,141,36);
		//
		// LclGrpCtrl
		//
		this.setTitle("Local Group Controller Window");
		this.setLocation(new Point(50, 50));
		this.setSize(new Dimension(930, 600));
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
	private void inbox_mouseClicked(MouseEvent e)
	{
		System.out.println("\ninbox_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		new Inbox(id,sctkey);
	}

	private void compose_mouseClicked(MouseEvent e)
	{
		System.out.println("\ncompose_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		new Compose(id,sctkey);
	}
	private void outbox_mouseClicked(MouseEvent e)
	{
		System.out.println("\noutbox_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		new Outbox(id,sctkey);
	}

	private void signout_mouseClicked(MouseEvent e)
	{
		System.out.println("\nsignout_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		setVisible(false);
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	// 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		//new LclGrpCtrl("","");
	}
//= End of Testing =


}
