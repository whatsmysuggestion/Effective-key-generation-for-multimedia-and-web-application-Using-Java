/****************************************************************/
/*                      ShowInbox	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
/**
 * Summary description for ShowInbox
 *
 */
public class ShowInbox extends JFrame
{
	// Variables declaration
	Connection con;
	Statement st;
	ResultSet rs;

	String id,key,str,sender,receiver,data,subject,flag;
	DataInputStream dis;
	String val1,val2,val3,gettable,stext;
	FileInputStream fis;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTable table;
	private JScrollPane jScrollPane1;
	private JTextArea textarea;
	private JScrollPane jScrollPane2;
	private JLabel view;
	private JLabel send;
	private JLabel sendtoall;
	private JLabel delete;
	private JLabel back;
	private JPanel contentPane;
	// End of variables declaration


	public ShowInbox(String user,String pass)
	{
		super();
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
		id=user;
		key=pass;
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
		jLabel2 = new JLabel();
		table = new JTable();
		jScrollPane1 = new JScrollPane();
		textarea = new JTextArea();
		jScrollPane2 = new JScrollPane();
		view = new JLabel();
		send = new JLabel();
		sendtoall = new JLabel();
		delete = new JLabel();
		back = new JLabel();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setIcon(new ImageIcon("D:\\Eff_Source\\EKey\\Mailbox.gif"));
		//
		// jLabel2
		//
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setText("Your Inbox Messages are...");
		jLabel2.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		//
		// jTable1
		//
		table.setModel(new DefaultTableModel(4, 4));
		//
		// jScrollPane1
		//
		showTable();
		jScrollPane1.setViewportView(table);
		jScrollPane1.setBackground(new Color(51, 51, 51));
		jScrollPane1.setForeground(new Color(255, 255, 255));
		//
		// textarea
		//
		//
		// jScrollPane2
		//
		jScrollPane2.setViewportView(textarea);
		//
		// view
		//
		view.setIcon(new ImageIcon("show.jpg"));
		view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				view_mouseClicked(e);
			}
			});
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
		// sendtoall
		//
		sendtoall.setIcon(new ImageIcon("sendtoall.jpg"));
		sendtoall.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				sendtoall_mouseClicked(e);
			}
			});
		//
		// delete
		//
		delete.setIcon(new ImageIcon("delete.jpg"));
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				delete_mouseClicked(e);
			}
			});
		//
		// back
		//
		back.setIcon(new ImageIcon("back.jpg"));
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				back_mouseClicked(e);
			}
			});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(204, 204, 255));
		addComponent(contentPane, jLabel1, 40,100,193,233);
		addComponent(contentPane, jLabel2, 204,17,492,49);
		addComponent(contentPane, jScrollPane1, 211,102,661,228);
		addComponent(contentPane, jScrollPane2, 44,349,827,152);
		addComponent(contentPane, view, 92,520,140,38);
		addComponent(contentPane, send, 237,520,140,38);
		addComponent(contentPane, sendtoall, 382,520,140,38);
		addComponent(contentPane, delete, 527,520,140,38);
		addComponent(contentPane, back, 671,520,140,38);
		//
		// ShowInbox
		//
		this.setTitle("Show Inbox Window");
		this.setLocation(new Point(50, 51));
		this.setSize(new Dimension(925, 627));
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
	private void view_mouseClicked(MouseEvent e)
	{
		System.out.println("\nview_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		int row=table.getSelectedRow();
		val1 = table.getValueAt(row,0).toString().trim();
		val2 = table.getValueAt(row,1).toString().trim();
		val3 = table.getValueAt(row,3).toString().trim();
    	if(val1 == null || val2 == null || val3 == null)
	    {
    		val1="";
	    	val2="";
	    	val3="";
	    }
	    try
		{
	     		rs=st.executeQuery("Select * from "+gettable+" where Receiver = '"+val1+"' and 	Sender = '"+val2+"' and Message = '"+val3+"'");
				if(rs.next())
				{
					String sctkey=rs.getString("Sctkey");
					stext = rs.getString("Message");
					System.out.println("The File "+stext+" is going to Decrypt");
					new Decrypting(stext,sctkey);
				}
				fis=new FileInputStream("Decrypt.txt");
				int i;
				String str="";
				while((i=fis.read())!=-1)
					str+=((char)i);
				str=str.substring(0,str.length()-4 );
				textarea.setText(str);
				System.out.println("View Successfully");
			 }
		     catch(Exception ex)
		     {
			       	System.out.println("Record not Viewed "+ex);
			 }
	}
	private void send_mouseClicked(MouseEvent e)
	{
		System.out.println("\nsend_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		int row=table.getSelectedRow();
			val1 = table.getValueAt(row,0).toString();
			val2 = table.getValueAt(row,1).toString();
			val3 = table.getValueAt(row,3).toString();
			if(val1 == null || val2 == null || val3 == null)
	       	{
				val1="";
	      		val2="";
	       		val3="";
	       	}
	       	try
			{
				rs=st.executeQuery("Select * from "+gettable+" where Receiver = '"+val1+"' and 	Sender = '"+val2+"' and Message = '"+val3+"'");
				while(rs.next())
				{
					key=rs.getString("Sctkey");
					data=rs.getString("Message");
				}
				System.out.println("The File "+data+" and sctkey is "+key);
				String str=JOptionPane.showInputDialog(this,"Give the Receiver id");
				String sub=JOptionPane.showInputDialog(this,"Give the Subject");
				sendTo(sub+".txt",str, sub, key,data);
				JOptionPane.showMessageDialog(this, "Successfully Send to the "+ receiver);
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(this, "Exception arised " + ex);
			}
	}

	private void sendtoall_mouseClicked(MouseEvent e)
	{
		System.out.println("\nsendtoall_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		int row=table.getSelectedRow();
			val1 = table.getValueAt(row,0).toString();
			val2 = table.getValueAt(row,1).toString();
			val3 = table.getValueAt(row,3).toString();
			if(val1 == null || val2 == null || val3 == null)
	       	{
				val1="";
	      		val2="";
	       		val3="";
	       	}
	       	try
			{
				rs=st.executeQuery("Select * from "+gettable+" where Receiver = '"+val1+"' and 	Sender = '"+val2+"' and Message = '"+val3+"'");
				while(rs.next())
				{
					key=rs.getString("Sctkey");
					data=rs.getString("Message");
				}
				String str=JOptionPane.showInputDialog(this,"Give the Receivers ID");
				String sub=JOptionPane.showInputDialog(this,"Give the Subject");
				sendToAll(sub+".txt",str,sub,key, data);
				JOptionPane.showMessageDialog(this, "Successfully Send to All");
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(this, "Exception arised " + ex);
			}
	}

	private void delete_mouseClicked(MouseEvent e)
	{
		System.out.println("\ndelete_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		int row=table.getSelectedRow();
			val1 = table.getValueAt(row,0).toString();
			val2 = table.getValueAt(row,1).toString();
			val3 = table.getValueAt(row,3).toString();
    		if(val1 == null || val2 == null || val3 == null)
	      	{
    			val1="";
	       		val2="";
	       		val3="";
	       	}
	       	try
			{

			     st.executeUpdate("Delete from "+gettable+" where Receiver = '"+val1+"' and Sender = '"+val2+"' and Message = '"+val3+"' ");
			     File f=new File(val3);
			     if(f.exists())
			    	 f.delete();
			     System.out.println("Deleted Successfully");
			 }
		     catch(Exception ex)
			{
	           	System.out.println("Record not deleted "+ex);
			 }
	}
	private void back_mouseClicked(MouseEvent e)
	{
		System.out.println("\nback_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		setVisible(false);
	}


	//
	// TODO: Add any method code to meet your needs in the following area
	//

	public void sendTo(String fname,String receiver, String subject, String sctkey,String sname)
	{
		try
		{
			FileInputStream fis=new FileInputStream(sname);
			FileOutputStream fos=new FileOutputStream(fname);
			int ch;
			while((ch=fis.read())!=-1)
				fos.write((char)ch);
			fos.close();
			fis=new FileInputStream(fname);
			byte[] b=new byte[fis.available()];
			fis.read(b);
			InetAddress ia = InetAddress.getLocalHost();
			String rec = receiver.substring(0, 2);
			fis=new FileInputStream("Kgc.txt");
			String kgc="";
			while((ch=fis.read())!=-1)
				kgc+=(char)ch;
			kgc.trim();
			if (rec.equals("G1"))
			{
				Socket skt = new Socket(ia, 3000);
				DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
				String packet = receiver+"#"+id+"#"+sctkey+"#"+subject+"#"+fname;
				System.out.println(packet);
				dos.writeUTF(packet);
				Thread.sleep(250);
				System.out.println("Send the File to the server");
				dos.writeUTF(new String(b));
				Thread.sleep(500);
				sendToOutbox(receiver,id,sctkey,subject,fname);
			} else {
				Socket skt = new Socket(kgc, 7000);
				DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
				String packet = receiver+"#"+id+"#"+sctkey+"#"+subject+"#"+fname;
				System.out.println("The " + packet + " is send to the KGC");
				dos.writeUTF(packet);
				Thread.sleep(250);
				System.out.println("Send the File to the server");
				dos.writeUTF(new String(b));
				Thread.sleep(500);
				sendToOutbox(receiver,id,sctkey,subject,fname);
			}


		} catch (Exception ex) {
			System.out.println("Message not send to the " + receiver + " " + ex);
		}
	}
	public void sendToOutbox(String receiver,String ia,String sctkey,String subject, String dtxt)
	{
		try
		{

		int flag = 1;
		st.executeUpdate("Insert into "+gettable+" values ('"+subject+"','"+ia+"','"+sctkey+"','"+subject+"','"+dtxt+"','"+flag+"')");

		}
		catch(Exception ex)
		{
			System.out.println("Not able to insert in the outbox "+ex);
		}
	}
	public void sendToAll(String fname,String receiver,String subject, String sctkey, String sname)
	{
		int count = 0;

		try
		{
			FileInputStream fis=new FileInputStream(sname);
			FileOutputStream fos=new FileOutputStream(fname);
			int ch;
			while((ch=fis.read())!=-1)
				fos.write((char)ch);
			fis.close();
			fos.close();
			fis=new FileInputStream(fname);
			byte[] b=new byte[fis.available()];
			fis.read(b);
				InetAddress ia = InetAddress.getLocalHost();
				int i=0;
				StringTokenizer st = new StringTokenizer(receiver);
				count =st.countTokens();
				for (i = 0; i<count ; i++)
				{
					String str=st.nextToken();
					Socket skt = new Socket(ia, 3000);
					DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
					String packet = str+"#"+id+"#"+sctkey+"#"+subject+"#"+fname;
					dos.writeUTF(packet);
					Thread.sleep(250);
					System.out.println("Send the File to the server");
					dos.writeUTF(new String(b));
					Thread.sleep(500);
					System.out.println("Successfully send to the " +str);
					sendToOutbox(str,id,sctkey,subject,fname);
					Thread.sleep(500);
				}
		}
		catch (Exception ex)
		{
				System.out.println("Not able to tokenize " + ex);
		}

	}
	public void showTable()
	{
		String header[]={"Receiver","Sender","Subject","Messages" };
		int i=0;
		try
		{
			rs=st.executeQuery("Select * from "+gettable+" where Receiver = '"+id+"' and Flag = 0");
			while(rs.next())
			{
				i++;
			}
		}
		catch(Exception ex)
		{
			System.out.println("No datas found "+ex);
		}
		Object data[][]=new Object[i][4];
		i=0;
		try
		{
			rs=st.executeQuery("Select * from "+gettable+" where Receiver = '"+id+"' and Flag = 0");
			while(rs.next())
			{
				data[i][0]=rs.getString("Receiver");
				data[i][1]=rs.getString("Sender");
				data[i][2]=rs.getString("Subject");
				data[i][3]=rs.getString("Message");
				i++;

			}

		}
		catch(Exception ex)
		{
			System.out.println("Not able to retrive record "+ex);
		}
		table = new JTable(data,header);
		jScrollPane1 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
		//new ShowInbox("G1GCI1","");
	}
//= End of Testing =


}
