/****************************************************************/
/*                      SendRequest	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Summary description for SendRequest
 *
 */
public class SendRequest extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JTextField sendto;
	private JTextField subject;
	private JTextArea textarea;
	private JScrollPane jScrollPane1;
	private JLabel send;
	private JLabel clear;
	private JPanel contentPane;
	public String receiver,sender,sub,datas;
	public int c;
	// End of variables declaration


	public SendRequest(String sendto)
	{
		super();
		receiver = sendto;
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
		jLabel6 = new JLabel();
		sendto = new JTextField();
		subject = new JTextField();
		textarea = new JTextArea();
		jScrollPane1 = new JScrollPane();
		send = new JLabel();
		clear = new JLabel();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("EULA.jpg"));
		//
		// jLabel4
		//
		jLabel4.setText("Your Message...");
		//
		// jLabel5
		//
		jLabel5.setText("Send To");
		//
		// jLabel6
		//
		jLabel6.setText("Subject");
		//
		// sendto
		//
		sendto.setText("Group Controller");
		sendto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sendto_actionPerformed(e);
			}

		});
		//
		// subject
		//
		subject.setText("join");
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
		send.setIcon(new ImageIcon("sendto.jpg"));
		send.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				send_mouseClicked(e);
			}
			});
		//
		// clear
		//
		clear.setIcon(new ImageIcon("clear.jpg"));
		clear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				clear_mouseClicked(e);
			}
			});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 204, 255));
		addComponent(contentPane, jLabel1, 61,70,182,433);
		addComponent(contentPane, jLabel4, 274,193,121,29);
		addComponent(contentPane, jLabel5, 277,114,60,24);
		addComponent(contentPane, jLabel6, 276,153,60,24);
		addComponent(contentPane, sendto, 365,110,264,22);
		addComponent(contentPane, subject, 365,150,268,22);
		addComponent(contentPane, jScrollPane1, 274,231,571,167);
		addComponent(contentPane, send, 400,440,110,30);
		addComponent(contentPane, clear, 650,437,110,30);
		//
		// SendRequest
		//
		this.setTitle("Send Request Window");
		this.setLocation(new Point(50, 50));
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

	private void send_mouseClicked(MouseEvent e)
	{
		System.out.println("\nsend_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
		sub=subject.getText();
		DBClass db=new DBClass();
		datas=textarea.getText();
		String user=receiver.substring(0,2);
		System.out.println(user);
		String id=user+"USR";
		System.out.println(id);
		c =db.getUsersCount(id);
		c++;
		id=user+"USR"+c;
		double no =Math.random()*System.currentTimeMillis();
		float val=Math.round(no);
		System.out.println("The Random number = "+val);
		db.addMember(id,val);
		System.out.println("Values r inserted in the Database");
		String sctkey="12345678";
		new Encrypting(sub+".txt",datas,sctkey);
		sendTo(sub+".txt",receiver,id, sub, sctkey);
		JOptionPane.showMessageDialog(this, "Your ID for your Private Key Retrievel is "+id+" and Secret Code = "+val);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,"Your Request are not send to the Group Controller");
		}
	}

	private void clear_mouseClicked(MouseEvent e)
	{
		System.out.println("\nclear_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		textarea.setText("");
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//

	public void sendTo(String fname,String receiver,String id, String subject, String sctkey)
	{
		try
		{
			FileInputStream fin = new FileInputStream(fname);
			byte[] b=new byte[fin.available()];
			fin.read(b);
			fin.close();
			File f = new File(fname);
			String fpath =f.getPath();
			InetAddress sender=InetAddress.getLocalHost();
			Socket skt=new Socket(sender,3000);
			DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
			String packet = receiver+"#"+id+"#"+sctkey+"#"+subject+"#"+fpath;
			System.out.println(packet);
			dos.writeUTF(packet);
			Thread.sleep(250);
			System.out.println("Send the File to the server");
			dos.writeUTF(new String(b));
			dos.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception arised "+e);
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
		//new SendRequest("G1GC");
	}
//= End of Testing =


}
