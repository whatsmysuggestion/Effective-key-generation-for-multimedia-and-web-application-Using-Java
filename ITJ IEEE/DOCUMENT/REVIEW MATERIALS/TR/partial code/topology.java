import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class addnode extends JFrame implements ActionListener
{
	JButton add = new JButton("add");
	JButton clear = new JButton("Clear");
	JLabel nodename=new JLabel("node name");
	JLabel fneighbour=new JLabel("Forward neighbor node");
	JLabel bneighbour=new JLabel("Backward neighbor node");
	JLabel fneighbour1=new JLabel("Forward neighbor node1");
	JLabel bneighbour1=new JLabel("Backward neighbor node1");
	JLabel pw=new JLabel("password");
	JLabel ip=new JLabel("ip-address");
	JLabel port=new JLabel("portnumber");
	JTextField node=new JTextField();
	JTextField fneigh=new JTextField();
	JTextField bneigh=new JTextField();
	JTextField fneigh1=new JTextField();
	JTextField bneigh1=new JTextField();
	JPasswordField pwd1=new JPasswordField();
	JTextField ip1=new JTextField();
	JTextField port1=new JTextField();
	JPanel p1 = new JPanel();
	JComboBox nodes=new JComboBox();
	JComboBox fnodes=new JComboBox();
	JRadioButton single=new JRadioButton("single fneighbour node");
	JRadioButton two=new JRadioButton("two fneighbour node");
	JRadioButton single1=new JRadioButton("single bneighbour node");
	JRadioButton two1=new JRadioButton("two bneighbour node");
	JRadioButton two2=new JRadioButton("one fneighbour and bneighbour node");
	ButtonGroup bg=new ButtonGroup();
	Container con;
	int flag=0;
	public addnode()
	{
			con = getContentPane();
			p1.setLayout(null);
			p1.add(add);
			p1.add(port);
			p1.add(port1);
			p1.add(clear);
			p1.add(ip);
			p1.add(ip1);
			p1.add(fneighbour1);
			p1.add(bneighbour1);
			p1.add(fneigh1);
			p1.add(bneigh1);
			bg.add(single);
			bg.add(two);
			bg.add(single1);
			bg.add(two1);
			bg.add(two2);
			single.setActionCommand("single fneighbour node");
			two.setActionCommand("two fneighbour node");
			single1.setActionCommand("single bneighbour node");
			two1.setActionCommand("two bneighbour node");
			two2.setActionCommand("one fneighbour and bneighbour node");
			p1.add(nodename);
			p1.add(fneighbour);
			p1.add(bneighbour);
			p1.add(pw);
			p1.add(pwd1);
			p1.add( node);
			p1.add(single);
			p1.add(two);
			p1.add(single1);
			p1.add(two1);
			p1.add(two2);
			p1.add( fneigh);
			p1.add(bneigh);
			p1.add(nodes);
			p1.add(fnodes);
			con.add(p1);
			nodename.setBounds(21,20,60,18); 
			fneighbour.setBounds(21,60,60,18);
			bneighbour.setBounds(21,140,60,18);
			fneighbour1.setBounds(21,100,60,18);
			bneighbour1.setBounds(21,180,60,18);
			pw.setBounds(21,220,60,18);
			pwd1.setBounds(95,220,100,22); 
			ip.setBounds(21,260,60,18);
			ip1.setBounds(95,260,100,22); 
			port.setBounds(21,300,60,18);
			port1.setBounds(95,300,100,22); 
			node.setBounds(95,20,100,22); 
			fneigh.setBounds(95,60,100,22); 
			bneigh.setBounds(95,140,100,22);
			fneigh1.setBounds(95,100,100,22); 
			bneigh1.setBounds(95,180,100,22);
			nodes.setBounds(280,20,100,22);
			fnodes.setBounds(280,100,100,22);
			add.setBounds(50,520,83,28); 
			clear.setBounds(175,520,83,28); 
			single.setBounds(35,340,100,24);
			two.setBounds(200,360,100,24);
			single1.setBounds(35,400,100,24);
			two1.setBounds(200,420,100,24);
			two2.setBounds(35,460,100,24);
			single.addActionListener(this);
			two.addActionListener(this);
			single1.addActionListener(this);
			two1.addActionListener(this);
			two2.addActionListener(this);
			add.addActionListener(this);
			setTitle("topology construction");
			nodename.setVisible(true);
			node.setVisible(true);
			fneighbour.setVisible(false);
			bneighbour.setVisible(false);
			fneigh.setVisible(false);
			bneigh.setVisible(false);
			fneighbour1.setVisible(false);
			bneighbour1.setVisible(false);
			fneigh1.setVisible(false);
			bneigh1.setVisible(false);
			nodes.setVisible(true);
			fnodes.setVisible(true);	
			pw.setVisible(true);
			pwd1.setVisible(true);
			ip.setVisible(true);
			ip1.setVisible(true);
			setSize(600,600);
			setVisible(true);
			}
			public void actionPerformed(ActionEvent ae)
			{
					String choice = ae.getActionCommand();	
					System.out.println(choice);							
					if(choice.equals("single fneighbour node"))
					{
						flag=1;	
						nodename.setVisible(true);
						node.setVisible(true);
						fneighbour.setVisible(true);
						fneigh.setVisible(true);	
						nodes.setVisible(true);
						fnodes.setVisible(true);	
						ip.setVisible(true);
						ip1.setVisible(true);
						port.setVisible(true);
						port1.setVisible(true);
						fneighbour1.setVisible(false);
						fneigh1.setVisible(false);
						bneighbour.setVisible(false);
						bneighbour1.setVisible(false);
						bneigh.setVisible(false);
						bneigh1.setVisible(false);																				
					}
					else if(choice.equals("two fneighbour node"))
					{
						flag=2;						
						nodename.setVisible(true);
						node.setVisible(true);
						fneighbour.setVisible(true);
						fneigh.setVisible(true);						
						fneighbour1.setVisible(true);						
						nodes.setVisible(true);
						fnodes.setVisible(true);	
						fneigh1.setVisible(true);
						ip.setVisible(true);
						ip1.setVisible(true);
						port.setVisible(true);
						port1.setVisible(true);
						bneighbour.setVisible(false);
						bneighbour1.setVisible(false);
						bneigh.setVisible(false);
						bneigh1.setVisible(false);									
					}
					else if(choice.equals("single bneighbour node"))
					{
						flag=3;	
						nodename.setVisible(true);
						node.setVisible(true);
						nodes.setVisible(true);
						fnodes.setVisible(true);
						bneighbour.setVisible(true);
						bneigh.setVisible(true);
						ip.setVisible(true);
						ip1.setVisible(true);
						port.setVisible(true);
						port1.setVisible(true);
						fneighbour.setVisible(false);
						fneigh.setVisible(false);						
						fneighbour1.setVisible(false);
						fneigh.setVisible(false);						
						bneighbour1.setVisible(false);					
						bneigh1.setVisible(false);												
					}
					else if(choice.equals("two bneighbour node"))
					{
						flag=4;	
						nodename.setVisible(true);
						node.setVisible(true);
						bneighbour.setVisible(true);
						bneighbour1.setVisible(true);
						bneigh.setVisible(true);
						bneigh1.setVisible(true);
						nodes.setVisible(true);
						fnodes.setVisible(true);	
						ip.setVisible(true);
						ip1.setVisible(true);
						port.setVisible(true);
						port1.setVisible(true);
						fneighbour.setVisible(false);
						fneigh.setVisible(false);						
						fneighbour1.setVisible(false);
						fneigh.setVisible(false);									
					}
					else if(choice.equals("one fneighbour and bneighbour node"))
					{
						flag=5;							
						nodename.setVisible(true);
						node.setVisible(true);
						fneighbour.setVisible(true);
						fneigh.setVisible(true);
						nodename.setVisible(true);
						nodes.setVisible(true);
						fnodes.setVisible(true);	
						node.setVisible(true);
						bneighbour.setVisible(true);
						bneigh.setVisible(true);
						ip.setVisible(true);
						ip1.setVisible(true);
						port.setVisible(true);
						port1.setVisible(true);
						fneighbour1.setVisible(false);
						fneigh1.setVisible(false);						
						bneighbour1.setVisible(false);						
						bneigh1.setVisible(false);																			
					}
					else if(choice.equals("add"))
					{
						try
						{				
							Socket soc=new Socket("localhost",1111);
							DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
							DataInputStream dis=new DataInputStream(soc.getInputStream());
							JOptionPane alert= new JOptionPane();					
							System.out.println(" Choice : "+choice);
							String reply,node11="",fneigh11="",bneigh11="",fneigh12="",bneigh12="",pw11,concat="",ip11="",port11="";
							System.out.println(flag);
							if(flag==1)
							{
								node11=node.getText();
								fneigh11=fneigh.getText();					
								pw11=pwd1.getText();
								ip11=ip1.getText();
								port11=port1.getText();
								concat=node11+"$"+fneigh11+"$"+pw11+"$"+ip11+"$"+port11+"$"+"1";
								System.out.println(concat);
								flag=0;
							}
							else if(flag==2)
							{
								node11=node.getText();
								fneigh11=fneigh.getText();
								fneigh12=fneigh1.getText();
								//bneigh1=bneigh.getText();
								//bneigh2=bneigh1.getText();
								pw11=pwd1.getText();
								ip11=ip1.getText();
								port11=port1.getText();
								concat=node11+"$"+fneigh11+"$"+fneigh12+"$"+pw11+"$"+ip11+"$"+port11+"$"+"2";	
								System.out.println(concat);
								flag=0;
							}	
							if(flag==3)
							{
								node11=node.getText();
								bneigh11=bneigh.getText();					
								pw11=pwd1.getText();
								ip11=ip1.getText();
								port11=port1.getText();
								concat=node11+"$"+bneigh11+"$"+pw11+"$"+ip11+"$"+port11+"$"+"3";
								System.out.println(concat);
								flag=0;
							}
							if(flag==4)
							{
								node11=node.getText();
								bneigh11=bneigh.getText();		
								bneigh12=bneigh1.getText();	
								pw11=pwd1.getText();
								ip11=ip1.getText();
								port11=port1.getText();
								concat=node11+"$"+bneigh11+"$"+bneigh12+"$"+pw11+"$"+ip11+"$"+port11+"$"+"4";
								System.out.println(concat);
								flag=0;
							}
							if(flag==5)
							{
								node11=node.getText();
								fneigh11=fneigh.getText();	
								//fneigh12=fneigh1.getText();	
								bneigh11=bneigh.getText();		
								//bneigh12=bneigh1.getText();	
								pw11=pwd1.getText();
								ip11=ip1.getText();
								port11=port1.getText();
								concat=node11+"$"+fneigh11+"$"+bneigh11+"$"+pw11+"$"+ip11+"$"+port11+"$"+"5";
								System.out.println(concat);
								flag=0;
							}
							if(true)
							{
								System.out.println(concat);
								dos.writeUTF(concat);
								reply=dis.readUTF();
								System.out.println(reply);
							}
							if(reply.equals("inserted"))
							{								
								alert.showMessageDialog(this,"this Node is  inserted! ! !","Add Node",JOptionPane.OK_OPTION);
								nodes.addItem(node11);
								nodename.setVisible(true);
								node.setVisible(true);
								nodes.setVisible(true);
								fnodes.setVisible(true);
								pw.setVisible(true);
								pwd1.setVisible(true);
								ip.setVisible(true);
								ip1.setVisible(true);
								fneighbour.setVisible(false);									
								fneigh.setVisible(false);
								bneighbour.setVisible(false);
								bneigh.setVisible(false);	
								fneighbour1.setVisible(false);	
								fneigh1.setVisible(false);
								bneigh1.setVisible(false);
								fnodes.addItem(fneigh11);							
								node.setText("");								
								fneigh.setText("");								
								bneigh.setText("");
								pwd1.setText("");								
								ip1.setText("");
							}
							else if(reply.equals("exist"))
							{
									nodes.removeItem(node11);
									fnodes.removeItem(fneigh11);
									alert.showMessageDialog(this,"this Node or pwd is  existed! ! !","Add Node",JOptionPane.OK_OPTION);									
									fneigh.setText("");									
									node.setText("");									
									bneigh.setText("");
									pwd1.setText("");									
									ip1.setText("");
									port1.setText("");
							}
					}catch(Exception ex)
					{

					}					
				}
				
	}
}
public class topology
{
	public static void main(String args[])
	{
		addnode an=new addnode();
	}
}