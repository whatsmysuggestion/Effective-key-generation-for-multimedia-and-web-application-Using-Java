/****************************************************************/
/*                      ComposeMsg	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.StringTokenizer;
import java.awt.event.*;
import javax.swing.*;
/**
 * Summary description for ComposeMsg
 *
 */
public class ComposeMsg extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel label;
	private JLabel jLabel5;
	private JTextField sendto;
	private JTextField subject;
	private JTextArea textarea;
	private JScrollPane jScrollPane1;
	private JButton send;
	private JButton sendtoall;
	private JButton clear;
	private JButton back;
	private JPanel contentPane;
	private String sctkey,id,gettable;
	private String to,sub,text;
	FileInputStream fin;
	Socket skt, skt1;
	Connection con;
	Statement st;
	ResultSet rs;
	//TransferPackets tp=new TransferPackets();
	// End of variables declaration


	public ComposeMsg(String uid, String pass)
	{
		super();
		id = uid;
		sctkey = pass;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:EfficientKey","sa","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Database Connectivity Error "+e);
		}

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
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		label=new JLabel();
		sendto = new JTextField();
		subject = new JTextField();
		textarea = new JTextArea();
		jScrollPane1 = new JScrollPane();
		send = new JButton();
		sendtoall = new JButton();
		clear = new JButton();
		back = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\EULA.JPG"));
		//
		// jLabel4
		//
		label.setText("Subject");
		jLabel5.setText("Send To");
		jLabel4.setText("Your Message...");
		//
		// sendto
		//
		sendto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sendto_actionPerformed(e);
			}

		});
		//
		// subject
		//
		subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				subject_actionPerformed(e);
			}

		});
		//
		// textarea
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(textarea);
		//
		// send
		//
		send.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\sendto.JPG"));
		send.setBackground(new Color(0, 0, 0));
		send.setForeground(new Color(255, 255, 255));
		send.setText("Send To");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				send_actionPerformed(e);
			}

		});
		//
		// sendtoall
		//
		sendtoall.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\sendtoall.JPG"));
		sendtoall.setBackground(new Color(51, 51, 51));
		sendtoall.setForeground(new Color(255, 255, 255));
		sendtoall.setText("Send To All");
		sendtoall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sendtoall_actionPerformed(e);
			}

		});
		//
		// clear
		//
		clear.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\clear.JPG"));
		clear.setBackground(new Color(0, 0, 0));
		clear.setForeground(new Color(255, 255, 255));
		clear.setText("Clear Text");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clear_actionPerformed(e);
			}

		});
		//
		// back
		//
		back.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\images\\back.JPG"));
		back.setBackground(new Color(0, 0, 0));
		back.setForeground(new Color(255, 255, 255));
		back.setText("Back to Inbox");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				back_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 204, 255));
		addComponent(contentPane, jLabel1, 61,70,182,433);
		addComponent(contentPane, label, 274,153,121,29);
		addComponent(contentPane, jLabel5, 274,114,60,18);
		addComponent(contentPane, jLabel4, 274,193,121,29);
		addComponent(contentPane, sendto, 365,110,264,22);
		addComponent(contentPane, subject, 365,150,268,22);
		addComponent(contentPane, jScrollPane1, 274,231,571,167);
		addComponent(contentPane, send, 284,440,110,30);
		addComponent(contentPane, sendtoall, 426,440,110,30);
		addComponent(contentPane, clear, 571,440,110,30);
		addComponent(contentPane, back, 711,440,110,30);
		//
		// ComposeMsg
		//
		this.setTitle("Compose Window");
		this.setLocation(new Point(50, 51));
		this.setSize(new Dimension(912, 554));
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
	private void sendto_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsendto_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void subject_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsubject_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void send_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsend_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
		to = sendto.getText();
		sub = subject.getText().trim();
		text = textarea.getText().trim();
		System.out.println("The text "+text+" is going to Encrypt with the key "+sctkey);
		new Encrypting(sub+".txt",text,sctkey);
		sendTo(sub+".txt",to, sub, sctkey);
		JOptionPane.showMessageDialog(this, "Successfully Send to the "
					+ to);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	private void sendtoall_actionPerformed(ActionEvent e)
	{
		System.out.println("\nsendtoall_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		to=sendto.getText();
		sub = subject.getText();
		text = textarea.getText().trim();
		try {
			System.out.println("The text "+text+" is going to Encrypt");
			new Encrypting(sub+".txt",text,sctkey);
			sendToAll(sub+".txt",to,sub, sctkey);
			JOptionPane.showMessageDialog(this, "Successfully Send to All Members");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Exception arised " + ex);
		}
	}

	private void clear_actionPerformed(ActionEvent e)
	{
		System.out.println("\nclear_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		textarea.setText("");
		sendto.setText("");
		subject.setText("");
	}

	private void back_actionPerformed(ActionEvent e)
	{
		System.out.println("\nback_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		setVisible(false);
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//

	public void sendTo(String fname,String receiver, String subject, String sctkey) {
		try {

			fin = new FileInputStream(fname);
			byte[] b=new byte[fin.available()];
			fin.read(b);
			fin.close();
			File f = new File(fname);
			String fpath =f.getPath();
			InetAddress ia = InetAddress.getLocalHost();
			String rec = receiver.substring(0, 2);
			fin=new FileInputStream("Kgc.txt");
			int ch;
			String kgc="";
			while((ch=fin.read())!=-1)
				kgc+=(char)ch;
			kgc.trim();

			if (rec.equals("G1")) {
				skt = new Socket(ia, 3000);
				DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
				String packet = receiver+"#"+id+"#"+sctkey+"#"+subject+"#"+fpath;
				System.out.println(packet);
				dos.writeUTF(packet);
				Thread.sleep(250);
				System.out.println("Send the File to the server");
				dos.writeUTF(new String(b));
				Thread.sleep(500);
				sendToOutbox(receiver,id,sctkey,subject,fpath);
			} else {
				skt = new Socket(kgc, 7000);
				DataOutputStream dos = new DataOutputStream(skt
						.getOutputStream());
				String packet = receiver+"#"+id+"#"+sctkey+"#"+subject+"#"+fpath;
				System.out.println("The " + packet + " is send to the KGC");
				dos.writeUTF(packet);
				Thread.sleep(250);
				System.out.println("Send the File to the server");
				dos.writeUTF(new String(b));
				Thread.sleep(500);
				sendToOutbox(receiver,id,sctkey,subject,fpath);
			}
			fin.close();

		} catch (Exception e) {
			System.out.println("Message not send to the " + receiver + " " + e);
		}
	}

	public void sendToAll(String fname,String receiver,String subject, String sctkey)
	{
		int count = 0;

		try
		{
			fin = new FileInputStream(fname);
			byte[] b=new byte[fin.available()];
			fin.read(b);
			fin.close();
			File f = new File(fname);
			String fpath =f.getPath();
			StringTokenizer st = new StringTokenizer(receiver);
			count =st.countTokens();
			InetAddress ia = InetAddress.getLocalHost();
			for(int i=0;i<count;i++)
			{
				String str=st.nextToken();
				str.trim();
				System.out.println("The packets are send to " + str);
				Socket skt = new Socket(ia, 3000);

				DataOutputStream dos = new DataOutputStream(skt
						.getOutputStream());
				String packet = str+"#"+id+"#"+sctkey+"#"+subject+"#"+fpath;
				dos.writeUTF(packet);
				Thread.sleep(250);
				System.out.println("Send the File to the server");
				dos.writeUTF(new String(b));
				Thread.sleep(500);
				sendToOutbox(str,id,sctkey,subject,fpath);
				Thread.sleep(1000);
			}
		}
		catch (Exception e)
		{
			System.out.println("Not able to tokenize " + e);
		}

	}
	public void sendToOutbox(String receiver,String sender,String sctkey,String subject, String dtxt)
	{
		try
		{
			if(id.length()>4)
			{
				if(id.substring(2,5).equals("GCI"))
					gettable="GrpCtrlIntmer";
				else if(id.substring(2,5).equals("LGC"))
					gettable="LclGrpCtrler";
				else
					gettable="Users";
			}
			else
				gettable="GrpCtrler";

		int flag = 1;

		st.executeUpdate("Insert into "+gettable+" values ('"+receiver+"','"+sender+"','"+sctkey+"','"+subject+"','"+dtxt+"',"+flag+")");

		}
		catch(Exception ex)
		{
			System.out.println("Not able to insert in the outbox "+ex);
		}
	}

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
		//new ComposeMsg("G1GC","12345678");
	}
//= End of Testing =


}
