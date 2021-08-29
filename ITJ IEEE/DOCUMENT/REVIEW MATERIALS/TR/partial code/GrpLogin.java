/****************************************************************/
/*                      GrpLogin	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Summary description for GrpLogin
 *
 */
public class GrpLogin extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel login;
	private JTextField userid;
	private JPasswordField sctkey;
	private JSeparator jSeparator1;
	private JLabel signup;
	private JLabel check;
	private JPanel contentPane;
	DBClass db=new DBClass();
	// End of variables declaration


	public GrpLogin()
	{
		super();
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
		jLabel1 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		login = new JLabel();
		userid = new JTextField();
		sctkey = new JPasswordField();
		jSeparator1 = new JSeparator();
		signup = new JLabel();
		check = new JLabel();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel1.setText("Login Information");
		jLabel1.setFont(new Font("Monotype Corsiva",Font.BOLD,40));
		//
		// jLabel3
		//
		jLabel3.setText("User ID");
		//
		// jLabel4
		//
		jLabel4.setText("Private Key");
		//
		// jLabel5
		//
		jLabel5.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\login.jpg"));
		//
		// login
		//
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\signin.JPG"));
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				login_mouseClicked(e);
			}

		});
		//
		// userid
		//
		userid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				userid_actionPerformed(e);
			}

		});
		//
		// sctkey
		//
		sctkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sctkey_actionPerformed(e);
			}

		});
		//
		// jSeparator1
		//
		//
		// jButton1
		//
		signup.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\signup.JPG"));
		signup.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				signup_mouseClicked(e);
			}

		});
		//
		// check
		//
		check.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\applieduser.JPG"));
		check.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				check_mouseClicked(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(204, 204, 255));
		addComponent(contentPane, jLabel1, 279,79,313,40);
		addComponent(contentPane, jLabel3, 130,170,125,18);
		addComponent(contentPane, jLabel4, 128,219,60,18);
		addComponent(contentPane, jLabel5, 487,96,164,255);
		addComponent(contentPane, login, 168,271,138,27);
		addComponent(contentPane, userid, 199,170,158,22);
		addComponent(contentPane, sctkey, 200,221,158,22);
		addComponent(contentPane, jSeparator1, 138,337,626,23);
		addComponent(contentPane, signup, 268,375,160,28);
		addComponent(contentPane, check, 479,375,157,28);
		//
		// GrpLogin
		//
		this.setTitle("Group Login Window");
		this.setLocation(new Point(75, 100));
		this.setSize(new Dimension(868, 546));
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
	private void login_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		try
				{
				String id=userid.getText();
				char k[]=sctkey.getPassword();
				String key=new String(k);
				int result=db.getResult(id, key);

				if(result==1)
				{
					if(id.length()>4)
					{
						if(id.substring(2, 5).equals("GCI"))
							new GrpCtrlInt(id,key);
						if(id.substring(2, 5).equals("LGC"))
							new LclGrpCtrl(id,key);
						if(id.substring(2, 5).equals("USR"))
							new Users(id,key);
					}
					else
						new GrpCtrler(id,key);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter your ID or Secret Key Correctly");
				}
				}
				catch(Exception ex)
				{
					System.out.println("Error in Logging..."+ex);
				}
	}
	private void userid_actionPerformed(ActionEvent e)
	{
		System.out.println("\nuserid_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void sctkey_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsctkey_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	private void signup_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		new SendRequest("G1GC");
	}
	private void check_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			String code=JOptionPane.showInputDialog("Give your Secret Code");
			System.out.println("The Id "+check+" and Secret Code "+code);
			String result=db.checkPassword(code);
			String res[]=result.split("/");
			res[0].trim();
			res[1].trim();
			System.out.println("The id "+res[0]+" and private key is "+res[1]);
			if(res[1].equals("0"))
			{
				JOptionPane.showMessageDialog(this, "We are not Assign any Private Key for U...");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Your Group Id is "+res[0]+" and Your Private Key is "+res[1]);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Not able to retrieve the Password");
}
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
		new GrpLogin();
	}
//= End of Testing =


}
