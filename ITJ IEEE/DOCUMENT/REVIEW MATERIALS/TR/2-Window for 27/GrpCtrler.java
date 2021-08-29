/****************************************************************/
/*                      GrpCtrler	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
public class GrpCtrler extends JFrame
{
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel inbox;
	private JLabel add;
	private JLabel compose;
	private JLabel outbox;
	private JLabel leave;
	private JLabel keygenerate;
	private JLabel signout;
	private JLabel tree;
	private JPanel contentPane;
	private String id,sctkey;
	private int c,n;
	public GrpCtrler(String id,String sctkey)
	{
		super();
		this.id = id;
		this.sctkey=sctkey;
		initializeComponent();
		this.setVisible(true);
	}
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		inbox = new JLabel();
		add = new JLabel();
		compose = new JLabel();
		outbox = new JLabel();
		leave = new JLabel();
		keygenerate = new JLabel();
		signout = new JLabel();
		tree = new JLabel();
		contentPane = (JPanel)this.getContentPane();
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel1.setText("Welcome Group Controler");
		jLabel1.setFont(new Font("Garamond",Font.BOLD,20));
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setIcon(new ImageIcon("images\\securenet.JPG"));
		inbox.setIcon(new ImageIcon("images\\inbox.JPG"));
		inbox.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e)
		{
			inbox_mouseClicked(e);
		}
		});
		add.setIcon(new ImageIcon("images\\joinmem.JPG"));
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				add_mouseClicked(e);
			}
			});
		compose.setIcon(new ImageIcon("images\\compose.JPG"));
		compose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
			System.out.println("compose_mouseClicked(e);");
			}

		});
		outbox.setIcon(new ImageIcon("images\\outbox.JPG"));
		outbox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
			System.out.println("outbox_mouseClicked(e);");
			}

		});
		leave.setIcon(new ImageIcon("images\\leavemem.JPG"));
		leave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
			System.out.println("leave_mouseClicked(e);");
			}
			});
		keygenerate.setIcon(new ImageIcon("images\\keys.JPG"));
		keygenerate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				keygenerate_mouseClicked(e);
			}
			});
		signout.setIcon(new ImageIcon("images\\signout.JPG"));
		signout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				signout_mouseClicked(e);
			}

		});
		tree.setIcon(new ImageIcon("images\\tree.JPG"));
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("tree_mouseClicked(e);");
			}
			});
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(12, 145, 244));
		addComponent(contentPane, jLabel1, 234,58,519,30);
		addComponent(contentPane, jLabel2, 143,120,663,268);
		addComponent(contentPane, inbox, 29,478,116,36);
		addComponent(contentPane, add, 383,478,116,36);
		addComponent(contentPane, compose, 265,478,116,36);
		addComponent(contentPane, outbox, 147,478,116,36);
		addComponent(contentPane, leave, 501,478,116,36);
		addComponent(contentPane, keygenerate, 619,478,116,36);
		addComponent(contentPane, signout, 854,478,116,36);
		addComponent(contentPane, tree, 737,478,116,36);
		this.setTitle("Group Controller Window");
		this.setLocation(new Point(1, 1));
		this.setSize(new Dimension(1020, 740));
	}
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}
	private void inbox_mouseClicked(MouseEvent e)
	{
		System.out.println("\ninbox_mouseClicked(MouseEvent e) called.");
	}

	private void add_mouseClicked(MouseEvent e)
	{
		System.out.println("\nadd_mouseClicked(MouseEvent e) called.");
		try
		{
	//	DBClass db=new DBClass();
		String oper = JOptionPane.showInputDialog("Give the Operation that you need [UPDATE/ADD]");
		oper.trim();
		if(oper.equalsIgnoreCase("update"))
		{
			String upt = JOptionPane.showInputDialog("Give the IDs for to Update");
			upt.trim();
			String str[]=upt.split(" ");
			String rec1=str[0].trim();
			String rec2=str[1].trim();
			//db.updateRecord(rec1,rec2);
			JOptionPane.showMessageDialog(this, "Update the Information of "+rec1+" to "+rec2);
		}
		if(oper.equalsIgnoreCase("add"))
		{
			String add = JOptionPane.showInputDialog("Give the Member ID for to Join");
			//db.addMember(add);
			JOptionPane.showMessageDialog(this,"The Member "+add+" is Joined in the Group");
		}
		}
		catch(Exception ex)
		{
			System.out.println("Not able to make changes in the user database");
		}
	}

	private void compose_mouseClicked(MouseEvent e)
	{
		System.out.println("\ncompose_mouseClicked(MouseEvent e) called.");
	//	new ComposeMsg(id,sctkey);
	}
	private void outbox_mouseClicked(MouseEvent e)
	{
		System.out.println("\noutbox_mouseClicked(MouseEvent e) called.");
	}

	private void leave_mouseClicked(MouseEvent e)
	{
		System.out.println("\nleave_mouseClicked(MouseEvent e) called.");
		try
		{
		String del = JOptionPane.showInputDialog("Give the Member ID");
		del.trim();
		String s = del.substring(0,4);
		//c = db.getUsersCount(s);
		String no=del.substring(del.length()-1, del.length());
		int start=Integer.parseInt(no);
		String uid=del.substring(0,del.length()-1);
		for(int i=start;i<=c;i++)
		{
			int val=i+1;
			String id1=uid+i;
			String id2=uid+val;
			System.out.println("User "+id2+" is update as "+id1);
			Thread.sleep(500);
		}
		JOptionPane.showMessageDialog(this,"The User "+del+" Recordes are Removed from the Table");
		System.out.println("Records are Removed from the table");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Not able to Remove the records ");
		}
	}
	private void keygenerate_mouseClicked(MouseEvent e)
	{
		System.out.println("\nkeygenerate_mouseClicked(MouseEvent e) called.");
		try
		{
			String s = id.substring(0,2);
			FileInputStream fin=new FileInputStream("Kgc.txt");
			int ch;
			String kgc="";
			while((ch=fin.read())!=-1)
				kgc+=(char)ch;
			kgc.trim();

			System.out.println("The Adrs of KGC "+kgc);
			try
			{
			Socket skt=new Socket(kgc,7000);
			DataOutputStream dos=new DataOutputStream(skt.getOutputStream());
			String str="keys"+"#"+s+"#"+c;
			System.out.println(str);
			dos.writeUTF(str);
			JOptionPane.showMessageDialog(this, "The Keys are Generated for All Users in the Group");
			}
			catch(Exception ex)
			{
				System.out.println("The users information is not forwarded to the KGC "+ex);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Users information not able to retrieve from DB "+ex);
		}
	}


	private void signout_mouseClicked(MouseEvent e)
	{
		System.out.println("\nsignout_mouseClicked(MouseEvent e) called.");
		setVisible(false);
	}
	private void tree_mouseClicked(MouseEvent e)
	{
		System.out.println("\ntree_actionPerformed(ActionEvent e) called.");
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
			System.out.println(ex);
		}
		new GrpCtrler("G1GC","12345678");
	}
}
