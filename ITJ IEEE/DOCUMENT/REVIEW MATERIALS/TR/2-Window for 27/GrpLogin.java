/****************************************************************/
/*                      GrpLogin	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GrpLogin extends JFrame
{
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel login;
	private JTextField userid;
	private JPasswordField sctkey;
	private JButton request;
	private JButton reqcode;
	private JSeparator jSeparator1;
	private JLabel signup;
	private JLabel check;
	private JPanel contentPane;
	public GrpLogin()
	{
		super();
		initializeComponent();
		this.setVisible(true);
	}
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		login = new JLabel();
		userid = new JTextField();
		sctkey = new JPasswordField();
		request = new JButton("");
		reqcode = new JButton("");
		jSeparator1 = new JSeparator();
		signup = new JLabel();
		check = new JLabel();
		contentPane = (JPanel)this.getContentPane();
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel1.setText("Login Information");
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setFont(new Font("Garamond",Font.BOLD,30));
		jLabel2.setText("Existing Users");
		jLabel2.setFont(new Font("Garamond",Font.BOLD,20));
		jLabel2.setForeground(new Color(255, 255, 255));
		jLabel3.setText("User ID ");
		jLabel3.setForeground(new Color(255, 255, 255));
		jLabel3.setFont(new Font("Garamond",Font.BOLD,15));
		jLabel4.setText("Private Key ");
		jLabel4.setForeground(new Color(255, 255, 255));
		jLabel4.setFont(new Font("Garamond",Font.BOLD,15));
		jLabel5.setIcon(new ImageIcon("login.jpg"));
		jLabel6.setText("New Users");
		jLabel6.setForeground(new Color(255, 255, 255));
		jLabel6.setFont(new Font("Garamond",Font.BOLD,20));
		request.setBackground(new Color(51, 51, 51));
		request.setForeground(new Color(255, 255, 255));
		request.setIcon(new ImageIcon("images\\forgotkey.JPG"));
		request.setText("Forgot");
		request.setFont(new Font("Garamond",Font.BOLD,15));
		request.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
						request_actionPerformed(e);
		}

		});
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setIcon(new ImageIcon("images\\signin.JPG"));
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				login_mouseClicked(e);
			}

		});
		userid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				userid_actionPerformed(e);
			}

		});
		sctkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sctkey_actionPerformed(e);
			}

		});
		signup.setIcon(new ImageIcon("images\\signup.JPG"));
		signup.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				signup_mouseClicked(e);
			}

		});
		check.setIcon(new ImageIcon("images\\applieduser.JPG"));
		check.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				check_mouseClicked(e);
			}

		});
		reqcode.setBackground(new Color(51, 51, 51));
		reqcode.setIcon(new ImageIcon("images\\forgotcode.JPG"));
				reqcode.setForeground(new Color(255, 255, 255));

				reqcode.setFont(new Font("Garamond",Font.BOLD,15));
				reqcode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
								reqcode_actionPerformed(e);
				}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(12, 145, 244));
		addComponent(contentPane, jLabel1, 180,60,453,40);
		addComponent(contentPane, jLabel2, 130,120,350,40);
		addComponent(contentPane, jLabel3, 130,170,310,18);
		addComponent(contentPane, jLabel4, 130,219,300,18);
		addComponent(contentPane, jLabel5, 600,90,225,225);
		addComponent(contentPane, jLabel6, 130,350,350,40);
		addComponent(contentPane, login, 275,271,138,27);
		addComponent(contentPane, request, 475,271,120,27);
		addComponent(contentPane, userid, 230,170,158,22);
		addComponent(contentPane, sctkey, 230,221,158,22);
		addComponent(contentPane, jSeparator1, 138,337,626,23);
		addComponent(contentPane, signup, 160,400,160,28);
		addComponent(contentPane, check, 350,400,160,28);
		addComponent(contentPane, reqcode, 540,400,120,28);
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
	private void request_actionPerformed(ActionEvent e)
	{
			System.out.println("\nrequest_actionPerformed(ActionEvent e) called.");
			// TODO: Add any handling code here
			//new VerifyInfo("key");
	}
	private void reqcode_actionPerformed(ActionEvent e)
		{
				System.out.println("\nreqcode_actionPerformed(ActionEvent e) called.");
				// TODO: Add any handling code here
				//new VerifyInfo("code");
	}
	private void login_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		try
				{
				String id=userid.getText();
				char k[]=sctkey.getPassword();
				String key=new String(k);
//				int result=db.getResult(id, key);
				int result;
//				if(result==1)
//				{
//					if(id.length()>4)
//					{
//						if(id.substring(2, 5).equals("GCI"))
//							new GrpCtrlInt(id,key);
//						if(id.substring(2, 5).equals("LGC"))
//							new LclGrpCtrl(id,key);
//						if(id.substring(2, 5).equals("USR"))
//							new Users(id,key);
//						}
//					else
//						new GrpCtrler(id,key);
//				}
				//else
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
//		new SendRequest("G1GC");
	}
	private void check_mouseClicked(MouseEvent e)
	{
		System.out.println("\nlogin_mouseClicked(MouseEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			String code=JOptionPane.showInputDialog("Give your Secret Code");
			//System.out.println("The Id "+check+" and Secret Code "+code);
		// val=Float.parseFloat(code);
			//String result=db.checkPassword(code);
			String result="result/";
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
			//System.out.println(ex);
			ex.printStackTrace();
		}
		new GrpLogin();
	}
//= End of Testing =


}
