import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
class Topology extends Thread
{
	public void run()
	{
		try
		{			
				ServerSocket ssoc = new ServerSocket(1111);					
				while(true)
				{
				Socket soc = ssoc.accept();
				System.out.print("Server has connected!\n");				
				DataOutputStream dos= new DataOutputStream(soc.getOutputStream());	
				DataInputStream dis = new DataInputStream(soc.getInputStream());
				String request,request1,node1,fneigh1="",bneigh1="",fneigh2="",bneigh2="",pw1,concat,concat1,node,pwd,lasttoken="",ip1="",port1="";	
				 StringTokenizer st1,st2,st3;
				 int count,flag=0;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
				Statement st=con.createStatement();	
				ResultSet rs,rs1,rs2,rs3;				
				System.out.println("while true");
				request=dis.readUTF();
				System.out.println(request);
				st2=new StringTokenizer(request,"$");				
				while(st2.hasMoreTokens())
					{
						lasttoken=st2.nextToken();
						System.out.println(lasttoken);
					}
					st1=new StringTokenizer(request,"$");
					if(lasttoken.equals("1"))
					{
					node1=st1.nextToken();
					System.out.println(node1);
					fneigh1=st1.nextToken();
					System.out.println(fneigh1);
					pw1=st1.nextToken();
					System.out.println(pw1);
					ip1=st1.nextToken();
					System.out.println(ip1);
					port1=st1.nextToken();
					System.out.println(port1);
					rs=st.executeQuery("select * from topology12");
					if(rs.wasNull())
					{
						st.executeUpdate("insert into topology12 values('"+node1+"','"+fneigh1+"','"+"null"+"','"+"null"+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
						dos.writeUTF("inserted");
					}
					else
					{
						while(rs.next())
						{
							node=rs.getString(1);
							pwd=rs.getString(6);
							if(node.equals(node1) || pw1.equals(pwd))
							{
								flag=1;
							}
						}
						if(flag==0)
						{
							st.executeUpdate("insert into topology12 values('"+node1+"','"+fneigh1+"','"+"null"+"','"+"null"+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
							dos.writeUTF("inserted");
						}
						else if(flag==1)
						{
							dos.writeUTF("exist");
							flag=0;
						}
					}
				}				
				else if(lasttoken.equals("2"))
				{
					node1=st1.nextToken();
					System.out.println(node1);
					fneigh1=st1.nextToken();
					System.out.println(fneigh1);
					fneigh2=st1.nextToken();
					System.out.println(bneigh1);
					pw1=st1.nextToken();
					System.out.println(pw1);
					ip1=st1.nextToken();
					System.out.println(ip1);
					port1=st1.nextToken();
					System.out.println(port1);
					rs1=st.executeQuery("select * from topology12");
					if(rs1.wasNull())
					{
						st.executeUpdate("insert into topology12 values('"+node1+"','"+fneigh1+"','"+fneigh2+"','"+"null"+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
					}
					else
					{
						while(rs1.next())
						{
							node=rs1.getString(1);
							pwd=rs1.getString(6);
							if(node.equals(node1) || pw1.equals(pwd))
							{
								flag=1;
							}
						}
						if(flag==0)
						{
							st.executeUpdate("insert into topology12 values('"+node1+"','"+fneigh1+"','"+fneigh2+"','"+"null"+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
							dos.writeUTF("inserted");
						}
						else if(flag==1)
						{
							dos.writeUTF("exist");
							flag=0;
						}
					}						
				}		
					else if(lasttoken.equals("3"))
				{
					node1=st1.nextToken();
					System.out.println(node1);
					bneigh1=st1.nextToken();
					System.out.println(fneigh1);					
					pw1=st1.nextToken();
					System.out.println(pw1);
					ip1=st1.nextToken();
					System.out.println(ip1);
					port1=st1.nextToken();
					System.out.println(port1);
					rs1=st.executeQuery("select * from topology12");
					if(rs1.wasNull())
					{
						st.executeUpdate("insert into topology12 values('"+node1+"','"+"null"+"','"+"null"+"','"+bneigh1+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
					}
					else
					{
						while(rs1.next())
						{
							node=rs1.getString(1);
							pwd=rs1.getString(6);
							if(node.equals(node1) || pw1.equals(pwd))
							{
								flag=1;
							}
						}
						if(flag==0)
						{
							st.executeUpdate("insert into topology12 values('"+node1+"','"+"null"+"','"+"null"+"','"+bneigh1+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
							dos.writeUTF("inserted");
						}
						else if(flag==1)
						{
							dos.writeUTF("exist");
							flag=0;
						}
					}						
				}						
					else if(lasttoken.equals("4"))
				{
					node1=st1.nextToken();
					System.out.println(node1);
					bneigh1=st1.nextToken();
					System.out.println(fneigh1);
					bneigh2=st1.nextToken();
					System.out.println(bneigh1);
					pw1=st1.nextToken();
					System.out.println(pw1);
					ip1=st1.nextToken();
					System.out.println(ip1);
					port1=st1.nextToken();
					System.out.println(port1);
					rs1=st.executeQuery("select * from topology12");
					if(rs1.wasNull())
					{
						st.executeUpdate("insert into topology12 values('"+node1+"','"+"null"+"','"+"null"+"','"+bneigh1+"','"+bneigh2+"','"+pw1+"','"+ip1+"','"+port1+"')");
					}
					else
					{
						while(rs1.next())
						{
							node=rs1.getString(1);
							pwd=rs1.getString(6);
							if(node.equals(node1) || pw1.equals(pwd))
							{
								flag=1;
							}
						}
						if(flag==0)
						{
							st.executeUpdate("insert into topology12 values('"+node1+"','"+"null"+"','"+"null"+"','"+bneigh1+"','"+bneigh2+"','"+pw1+"','"+ip1+"','"+port1+"')");
							dos.writeUTF("inserted");
						}
						else if(flag==1)
						{
							dos.writeUTF("exist");
							flag=0;
						}
					}						
				}					
				else if(lasttoken.equals("5"))
				{
					node1=st1.nextToken();
					System.out.println(node1);
					fneigh1=st1.nextToken();
					System.out.println(fneigh1);
					bneigh1=st1.nextToken();
					System.out.println(bneigh1);
					pw1=st1.nextToken();
					System.out.println(pw1);
					ip1=st1.nextToken();
					System.out.println(ip1);
					port1=st1.nextToken();
					System.out.println(port1);
					rs1=st.executeQuery("select * from topology12");
					if(rs1.wasNull())
					{
						st.executeUpdate("insert into topology12 values('"+node1+"','"+fneigh1+"','"+"null"+"','"+bneigh1+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
					}
					else
					{
						while(rs1.next())
						{
							node=rs1.getString(1);
							pwd=rs1.getString(6);
							if(node.equals(node1) || pw1.equals(pwd))
							{
								flag=1;
							}
						}
						if(flag==0)
						{
							st.executeUpdate("insert into topology12 values('"+node1+"','"+fneigh1+"','"+"null"+"','"+bneigh1+"','"+"null"+"','"+pw1+"','"+ip1+"','"+port1+"')");
							dos.writeUTF("inserted");
						}
						else if(flag==1)
						{
							dos.writeUTF("exist");
							flag=0;
						}
					}						
				}					
			}				
		}
		catch (Exception ex)
		{
		}
	}
}
class FetchNode extends Thread
{
	Connection con1;
	Statement st1;
	ResultSet rs,rs1,rs2;
	DataOutputStream dos1;
	DataInputStream dis1;
	String request,request1,node1,fneigh1="",bneigh1="",fneigh2="",bneigh2="",pw1,concat="",concat1,node,pwd,lasttoken="",ip1="",port1="";	
	StringTokenizer str1,str2;
	public void run()
	{		
		try
		{
			ServerSocket ssoc1 = new ServerSocket(2222);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			st1=con1.createStatement();	
			while(true)
			{	
				Socket soc1 = ssoc1.accept();
				System.out.print("Server has connected!\n");	
				dos1=new DataOutputStream(soc1.getOutputStream());
				dis1=new DataInputStream(soc1.getInputStream());
				request=dis1.readUTF();
				System.out.println("request :"+request);
				if(request.equals("fetch"))
				{
					System.out.println("request :"+request);
					rs2=st1.executeQuery("select * from topology12");
					System.out.println("topology");
					while(rs2.next())
					{
						node1=rs2.getString(1);
						concat=concat+"$"+node1;
						System.out.println("n_name :"+node1);
						fneigh1=rs2.getString(2);
						fneigh2=rs2.getString(3);
						bneigh1=rs2.getString(4);
						bneigh2=rs2.getString(5);
						pw1=rs2.getString(6);
						ip1=rs2.getString(7);
						port1=rs2.getString(8);
					}
						dos1.writeUTF("fetched"+"$"+concat);		
				}
			}
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class SelectNode extends Thread
{
	Connection con1;
	Statement st1;
	ResultSet rs,rs1,rs2,rs3,rs4;
	DataOutputStream dos1;
	DataInputStream dis1;
	Vector v1=new Vector();
	Vector v2=new Vector();
	Vector v3=new Vector();
	String request,request1,node1="",fneigh1="",bneigh1="",fneigh2="",bneigh2="",pw1,concat="",concat1,node,pwd,lasttoken="",ip1="",desti,lastToken,port1="";	
	String node11="",fneigh11="",bneigh11="",fneigh22="",bneigh22="",pw11,ip11="",port11="";	
	String node111="",fneigh111="",bneigh111="",fneigh222="",bneigh222="",pw111,ip111="",port111="";	
	StringTokenizer str1,str2;
	String  nfnode1="",nffneigh1="",nffneigh2="",	nfbneigh1="",nfbneigh2="",nfpw1="",nfip1="",nfport1="";
	String  nfnode11="",nffneigh11="",nffneigh22="",	nfbneigh11="",nfbneigh22="",nfpw11="",nfip11="",nfport11="";
	String  fnode1="",ffneigh1="",ffneigh2="",	fbneigh1="",fbneigh2="",fpw1="",fip1="",fport1="";
	String nonfornode="",nonforbneigh="";
	int flag=0;
	public void run()
	{		
		try
		{
			ServerSocket ssoc1 = new ServerSocket(3333);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			st1=con1.createStatement();	
			while(true)
			{	
				Socket soc1 = ssoc1.accept();
				System.out.print("Server has connected!\n");	
				dos1=new DataOutputStream(soc1.getOutputStream());
				dis1=new DataInputStream(soc1.getInputStream());
				request=dis1.readUTF();
				System.out.println("request:"+request);
				if(request.equals("fetch forward"))
				{
					rs=st1.executeQuery("select * from topology12");
				}				
				while(rs.next())
				{
					System.out.println("within while");
					node1=rs.getString(1);						
					System.out.println("n_name :"+node1);					
					fneigh1=rs.getString(2);
					System.out.println(fneigh1);
					fneigh2=rs.getString(3);
					System.out.println(fneigh2);
					bneigh1=rs.getString(4);
					System.out.println(bneigh1);
					bneigh2=rs.getString(5);
					System.out.println(bneigh2);
					pw1=rs.getString(6);
					System.out.println(pw1);
					ip1=rs.getString(7);
					System.out.println(ip1);
					port1=rs.getString(8);
					System.out.println(port1);
					if(fneigh1.equals("null")&&fneigh2.equals("null"))
					{
						v1.addElement(node1);
						v1.addElement(fneigh1);
						v1.addElement(fneigh2);
						v1.addElement(bneigh1);
						v1.addElement(bneigh2);
						v1.addElement(pw1);
						v1.addElement(ip1);
						v1.addElement(port1);											
					}
					else
					{
						System.out.println("within else");
						v2.addElement(node1);
						v2.addElement(fneigh1);
						v2.addElement(fneigh2);
						v2.addElement(bneigh1);
						v2.addElement(bneigh2);
						v2.addElement(pw1);
						v2.addElement(ip1);
						v2.addElement(port1);						
					}						
				}
						int size1=v1.size();
						System.out.println("vectorsize1:"+size1);
						int size2=v2.size();
						System.out.println("vectorsize2:"+size2);
						Enumeration enum1=v1.elements();
						System.out.println("enum1:"+enum1);
						Enumeration enum2=v2.elements();
						System.out.println("enum2:"+enum2);
						while(enum1.hasMoreElements())
						{							
							 nfnode1=(String)enum1.nextElement();
							 System.out.println("nfnode1:"+nfnode1);
							 nffneigh1=(String)enum1.nextElement();
							nffneigh2=(String)enum1.nextElement();
							nfbneigh1=(String)enum1.nextElement();
							nfbneigh2=(String)enum1.nextElement();
							nfpw1=(String)enum1.nextElement();
							nfip1=(String)enum1.nextElement();
							nfport1=(String)enum1.nextElement();
							st1.executeUpdate("insert into nonforwardingnodes12 values('"+nfnode1+"','"+nffneigh1+"','"+nffneigh2+"','"+nfbneigh1+"','"+nfbneigh2+"','"+nfpw1+"','"+nfip1+"','"+nfport1+"','"+0+"')");							
						}
						while(enum2.hasMoreElements())
						{							
							 fnode1=(String)enum2.nextElement();
							 ffneigh1=(String)enum2.nextElement();
							ffneigh2=(String)enum2.nextElement();
							fbneigh1=(String)enum2.nextElement();
							fbneigh2=(String)enum2.nextElement();
							fpw1=(String)enum2.nextElement();
							fip1=(String)enum2.nextElement();
							fport1=(String)enum2.nextElement();
							st1.executeUpdate("insert into forwardingnodes12 values('"+fnode1+"','"+ffneigh1+"','"+ffneigh2+"','"+fbneigh1+"','"+fbneigh2+"','"+fpw1+"','"+fip1+"','"+fport1+"','"+1+"')");							
						}
						rs2=st1.executeQuery("select * from nonforwardingnodes12"); 
						while(rs2.next())
						{
							nonfornode=rs2.getString(1);
						}
						rs3=st1.executeQuery("select * from topology12 where nodename='"+nonfornode+"'"); 
						if(rs3.next())
						{
							nonforbneigh=rs3.getString(5);
						}
						rs4=st1.executeQuery("select * from topology12 where nodename='"+nonforbneigh+"'"); 
						if(rs4.next())
						{
							 nfnode11=rs4.getString(1);
							 v1.addElement(nfnode11);
							 System.out.println("nfnode1:"+nfnode1);
							 nffneigh11=rs4.getString(2);
							 v1.addElement(nffneigh11);
							nffneigh22=rs4.getString(3);
							v1.addElement(nffneigh22);
							nfbneigh11=rs4.getString(4);
							v1.addElement(nfbneigh11);
							nfbneigh22=rs4.getString(5);
							v1.addElement(nfbneigh22);
							nfpw11=rs4.getString(6);
							v1.addElement(nfpw11);
							nfip11=rs4.getString(7);
							v1.addElement(nfip11);
							nfport11=rs4.getString(8);
							v1.addElement(nfport11);
							st1.executeUpdate("insert into nonforwardingnodes12 values('"+nfnode11+"','"+nffneigh11+"','"+nffneigh22+"','"+nfbneigh11+"','"+nfbneigh22+"','"+nfpw11+"','"+nfip11+"','"+nfport11+"','"+0+"')");						
						}						
						System.out.println("vector1:"+v1);
						System.out.println("vector2:"+v2);
						st1.executeUpdate("delete from forwardingnodes12 where nodename='"+nonforbneigh+"'");						
						dos1.writeUTF("forwarded nodes are selected");						
				}
			}
		catch (Exception e2)
		{
			System.out.println(e2);
		}
	}
}
class LoginNode extends Thread
{
	Connection con1;
	Statement st1;
	ResultSet rs,rs1,rs2,rs3;
	DataOutputStream dos1;
	DataInputStream dis1;
	String request,node="",password="",password1,reply,nodes="",portno;
	String nodes1="",nodes2,node11,node22,node1="",node111="";
	StringTokenizer str1,str2;
	public void run()
	{
		try
		{
			ServerSocket ssoc1 = new ServerSocket(4444);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			st1=con1.createStatement();
			while(true)
			{
				Socket soc1 = ssoc1.accept();
				System.out.print("Server has connected!\n");	
				dos1=new DataOutputStream(soc1.getOutputStream());
				dis1=new DataInputStream(soc1.getInputStream());
				request=dis1.readUTF();
				System.out.println("request:"+request);
				str1=new StringTokenizer(request,"$");				
				node=str1.nextToken();	
				System.out.println("node:"+node);
				password=str1.nextToken();	
				System.out.println("password:"+password);
				rs2=st1.executeQuery("select * from nonforwardingnodes12");
				System.out.println("after rs2");
				while(rs2.next())
				{
					System.out.println("within while");
					if(nodes1.equals(""))
					{
						nodes1=rs2.getString(1);
						System.out.println("nodes1:"+nodes1);
					}
					else
					{
						node111=nodes1+"$"+rs2.getString(1);
					}				
				}
					System.out.println("node111:"+nodes1);
					StringTokenizer str5=new StringTokenizer(node111,"$");
					str5.hasMoreTokens();				
					node11=str5.nextToken();
					System.out.println("node11:"+node11);
					node22=str5.nextToken();	
					System.out.println("node22:"+node22);
					node1="";
					if(node11.equals(node)||node22.equals(node))
					{
						System.out.println("within if");
						rs1=st1.executeQuery("select * from nonforwardingnodes12 where nodename='"+node+"'");				
					if(rs1.next())
					{
					node1=rs1.getString(1);				
					password1=rs1.getString(6);
					String ip_address=rs1.getString(7);
					String portno=rs1.getString(8);	
					String nodestatus=rs1.getString(9);
					if(node1.equals(node) &&password1.equals(password))
					{
					dos1.writeUTF("Login successfully"+"$"+portno+"$"+node1+"$"+ip_address+"$"+nodestatus);
					}
					else 
					{
					dos1.writeUTF("Login failed"+"$"+portno+"$"+node1+"$"+ip_address+"$"+nodestatus);
					}				
				}	
				
					
				}
				else
				{
					rs1=st1.executeQuery("select * from forwardingnodes12 where nodename='"+node+"'");				
					if(rs1.next())
					{
						node1=rs1.getString(1);				
						password1=rs1.getString(6);
						String ip_address=rs1.getString(7);
						String portno=rs1.getString(8);	
						String nodestatus=rs1.getString(9);
						if(node1.equals(node) &&password1.equals(password))
						{
						dos1.writeUTF("Login successfully"+"$"+portno+"$"+node1+"$"+ip_address+"$"+nodestatus);
						}
						else 
						{
						dos1.writeUTF("Login failed"+"$"+portno+"$"+node1+"$"+ip_address+"$"+nodestatus);
						}				
				}		
			}
		}
	}
		catch (Exception e3)
		{
			System.out.println(e3);
		}
	}
}
class TransferNode extends Thread
{
	
	public void run()
	{
		Connection con,con1;
		Statement st,st1;
		ResultSet rs,rs1,rs2;
		DataOutputStream dos,dos1;
		DataInputStream dis,dis1;
		String request,reply,nodes="",forw1,forw2,back1,back2,tok1,tok2,req,node;	
		StringTokenizer str1;
		try
		{
			ServerSocket ssoc = new ServerSocket(5555);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			st=con.createStatement();
			while(true)
			{
				Socket soc = ssoc.accept();
				System.out.print("Server has connected!\n");	
				dos=new DataOutputStream(soc.getOutputStream());
				dis=new DataInputStream(soc.getInputStream());
				request=dis.readUTF();
				System.out.println("request:"+request);
				str1=new StringTokenizer(request,"$");
				str1.hasMoreTokens();
				req=str1.nextToken();
				System.out.println("req:"+req);
				String source=str1.nextToken();
				System.out.println("source:"+source);
				if(req.equals("fetch nodes"))
				{
					nodes="";
					rs=st.executeQuery("select * from topology12 ");
					while(rs.next())
					{	
						node=rs.getString(1);
						if(!source.equals(node))
						{
							if(nodes.equals(""))
								nodes=node;
							else
						      nodes=nodes+"$"+node;
						}
					}				
					dos.writeUTF(nodes);											
				}
				else
				{
					System.out.println("invalid statement");
				}
			}			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
}
class Forwarding extends Thread
{
	Connection con,con1;
	Statement st,st1;
	ResultSet rs,rs1,rs2,rs3,rs4,rs5;
	DataOutputStream dos,dos1;
	DataInputStream dis,dis1;
	Socket soc1;
	String request,reply,nodes="",forw1,forw2,back1,back2,tok1,tok2,ip,port1="",port2="";	
	StringTokenizer str1;
	public void run()
	{
		try
		{
			ServerSocket ssoc1= new ServerSocket(6666);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			st1=con1.createStatement();
			while(true)
			{
				Socket soc1 = ssoc1.accept();
				System.out.print("Server has connected!");	
				dos1=new DataOutputStream(soc1.getOutputStream());
				System.out.println("after dos1");
				dis1=new DataInputStream(soc1.getInputStream());
				System.out.println("after dis1");
				request=dis1.readUTF();
				System.out.println(request);
				str1=new StringTokenizer(request,"$");
				str1.hasMoreTokens();
				tok1=str1.nextToken();
				System.out.println("tok1"+tok1);
				tok2=str1.nextToken();
				System.out.println("tok2"+tok2);
				if(tok1.equals("fetch"))
				{
						System.out.println("sample");
						rs1=st1.executeQuery("select * from topology12 where nodename='"+tok2+"'");
						System.out.println("sample1");
						rs1.next();					
						System.out.println("sample2");
						forw1=rs1.getString(2);
						System.out.println("sample3");
						forw2=rs1.getString(3);
						System.out.println("sample4");			
						String concat=forw1+"$"+forw2;
						dos1.writeUTF(concat);
				}
			}
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class DataTransfer extends Thread
{
	Connection con,con1;
	Statement st,st1;
	ResultSet rs,rs1,rs2,rs3,rs4,rs5;
	DataOutputStream dos,dos1,dos2;
	DataInputStream dis,dis1,dis2;
	String request,reply,forw1,forw2,back1,back2,tok1,tok2,tok3,ide,ip,port1="",port2="",ip_address,portno,pwd,lastToken,req,source;	
	String concat1;
	StringTokenizer str1,str2;
	public static String[] nodename=new String[20];
	public static String[] nodes=new String[20];
	public static String[] ipaddress=new String[20];
	public static String[] portnum=new String[10];
	public static String[] concat=new String[10];	
	public static String[] ports=new String[10];	
	int i=1;
	public void run()
	{							
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			st1=con1.createStatement();	
			ServerSocket ssoc1= new ServerSocket(7777);					
			while(true)
			{
				Socket soc1 = ssoc1.accept();
				System.out.print("Server has connected!\n");	
				dos1=new DataOutputStream(soc1.getOutputStream());
				dis1=new DataInputStream(soc1.getInputStream());
				request=dis1.readUTF();
				System.out.println(request);
				str1=new StringTokenizer(request,"$");
				req=str1.nextToken();
				source=str1.nextToken();
				if(req.equals("fetch"))
				{
					rs=st1.executeQuery("select * from topology12");
					System.out.println("Nodes			IPAddress		Ports");
					while(rs.next())
					{
						if(!nodes[i].equals(source))
						{
						nodes[i]=rs.getString(1);
						ipaddress[i]=rs.getString(7);
						ports[i]=rs.getString(8);
						System.out.println(nodes[i]+"		"+ipaddress[i]+"		"+ports[i]);						
						concat[i]=nodes[i]+"$"+ipaddress[i]+"$"+ports[i];
						i=i+1;						
						}
					}	
					for(int i=1;i<=5;i++)
						{
							concat1=concat[i];
							dos1.writeUTF(concat1);
						}
				}
			}
	}
			catch (Exception e5)
			{
				
			}					
	}
}
class ip_port extends Thread
{
	public void run()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			Statement st1=con1.createStatement();	
			ServerSocket ssoc6= new ServerSocket(8888);		
			DataOutputStream dos6;
			DataInputStream dis6;
			ResultSet rs;
			String reply="";
			while(true)
			{
				Socket soc6 = ssoc6.accept();
				System.out.print("Server has connected! to get ip address and port number\n");	
				dos6=new DataOutputStream(soc6.getOutputStream());
				dis6=new DataInputStream(soc6.getInputStream());
				String request=dis6.readUTF();	
				rs=st1.executeQuery("select * from topology12 where nodename='"+request+"'");
				rs.next();
				{
					String ip=rs.getString(7);
					String port=rs.getString(8);					
					reply=ip+"$"+port;				
						
				}
				
				dos6.writeUTF(reply);
			}
		}
		catch (Exception ex)
		{
		}
			
	}
}
class neighip extends Thread
{
	public void run()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			Statement st1=con1.createStatement();	
			ServerSocket ssoc6= new ServerSocket(7000);		
			DataOutputStream dos6;
			DataInputStream dis6;
			ResultSet rs,rs1;
			String reply="";
			while(true)
			{
				Socket soc6 = ssoc6.accept();
				System.out.print("Server has connected! to get ip address and port number1\n");	
				dos6=new DataOutputStream(soc6.getOutputStream());
				dis6=new DataInputStream(soc6.getInputStream());
				String request=dis6.readUTF();	
				System.out.println("request:"+request);
				rs=st1.executeQuery("select * from topology12 where nodename='"+request+"'");
				rs.next();
				{
					String neigh1=rs.getString(2);
					System.out.println("neigh1:"+neigh1);
					String neigh2=rs.getString(3);
					System.out.println("neigh2:"+neigh2);
					if(!neigh1.equals("null"))
					{
						System.out.println("within first");
						rs1=st1.executeQuery("select * from topology12 where nodename='"+neigh1+"'");
						System.out.println("after rs1"+rs1);
						if(rs1.next())
						{
							System.out.println("within if");
						String ip=rs1.getString(7);
						System.out.println(ip);
						String port=rs1.getString(8);
						System.out.println(port);
						reply=ip+"$"+port;	
						System.out.println(reply);
						}
					}
					else if(!neigh2.equals("null"))
					{
						System.out.println("within second");
						rs1=st1.executeQuery("select * from topology12 where nodename='"+neigh2+"'");
						System.out.println("after rs1"+rs1);
						if(rs1.next())
						{
							System.out.println("within if");
						String ip=rs1.getString(7);
						System.out.println(ip);
						String port=rs1.getString(8);
						System.out.println(port);
						reply=ip+"$"+port;	
						System.out.println(reply);
						}
					}
					else
					{
						System.out.println("within else");
						dos6.writeUTF("one neighbour"+"$"+"no");
					}						
				}				
				dos6.writeUTF(reply);
			}
		}
		catch (Exception ex)
		{
		}
			
	}
}
class nodefailure extends Thread
{
	public void run()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			Statement st1=con1.createStatement();	
			ServerSocket ssoc6= new ServerSocket(8000);		
			DataOutputStream dos6;
			DataInputStream dis6;
			ResultSet rs,rs1,rs2,rs3;
			String reply="",nodestatus="",node1="",fneigh1="",fneigh2="",bneigh1="",bneigh2="",pw1="",ip1="",port1="";
			String bneigh223="",node111="",fneigh111="",fneigh222="",bneigh111="",bneigh222="",pw111="",ip111="",port111="";
			while(true)
			{
				Socket soc6 = ssoc6.accept();
				System.out.print("Server has connected! to change the node status\n");	
				dos6=new DataOutputStream(soc6.getOutputStream());
				dis6=new DataInputStream(soc6.getInputStream());
				String request=dis6.readUTF();	
				System.out.println("request:"+request);				
				rs1=st1.executeQuery("select * from topology12 where nodename='"+request+"'");				
				System.out.println("after rs1:");
				if(rs1.next())
				{
					
					System.out.println("within if");
					node1=rs1.getString(1);					
					System.out.println("node1 :"+node1);
					fneigh1=rs1.getString(2);
					System.out.println(fneigh1);
					fneigh2=rs1.getString(3);
					System.out.println(fneigh2);
					bneigh1=rs1.getString(4);
					System.out.println(bneigh1);
					bneigh2=rs1.getString(5);
					System.out.println(bneigh2);
					pw1=rs1.getString(6);
					System.out.println(pw1);
					ip1=rs1.getString(7);
					System.out.println(ip1);
					port1=rs1.getString(8);	
					System.out.println(port1);	
					st1.executeUpdate("delete  from forwardingnodes12 where nodename='"+request+"'");
					rs2=st1.executeQuery("select * from topology12 where nodename='"+fneigh1+"'");
					if(rs2.next())
					{
						 bneigh223=rs2.getString(5);
						rs3=st1.executeQuery("select * from topology12 where nodename='"+bneigh223+"'");
						if(rs3.next())
						{
							System.out.println("within if");
						node111=rs3.getString(1);					
						System.out.println("node1 :"+node111);
						fneigh111=rs3.getString(2);
						System.out.println(fneigh111);
						fneigh222=rs3.getString(3);
						System.out.println(fneigh222);
						bneigh111=rs3.getString(4);
						System.out.println(bneigh111);
						bneigh222=rs3.getString(5);
						System.out.println(bneigh222);
						pw111=rs3.getString(6);
						System.out.println(pw111);
						ip111=rs3.getString(7);
						System.out.println(ip111);
						port111=rs3.getString(8);	
						System.out.println(port111);	
						st1.executeUpdate("delete  from nonforwardingnodes12 where nodename='"+bneigh223+"'");
						}
						st1.executeUpdate("insert into forwardingnodes12 values('"+node111+"','"+fneigh111+"','"+fneigh222+"','"+bneigh111+"','"+bneigh222+"','"+pw111+"','"+ip111+"','"+port111+"','"+1+"')");
					}
				}
				st1.executeUpdate("insert into nonforwardingnodes12 values('"+node1+"','"+fneigh1+"','"+fneigh2+"','"+bneigh1+"','"+bneigh2+"','"+pw1+"','"+ip1+"','"+port1+"','"+0+"')");
				
				dos6.writeUTF("status changed"+"$"+request+"$"+bneigh223);
				System.out.println("after the dos");
			}
			
		}
		catch (Exception ex1)
		{
		}
	}
}
class forwardnode extends Thread
{
	public void run()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			Statement st1=con1.createStatement();	
			ServerSocket ssoc6= new ServerSocket(7770);		
			DataOutputStream dos6;
			DataInputStream dis6;
			ResultSet rs,rs1;
			String reply="",forwnodes="";
			while(true)
			{
				Socket soc6 = ssoc6.accept();
				System.out.print("Server has connected! to get the forwarding nodes onlyn");	
				dos6=new DataOutputStream(soc6.getOutputStream());
				dis6=new DataInputStream(soc6.getInputStream());
				String request=dis6.readUTF();	
				System.out.println("request:"+request);
				rs=st1.executeQuery("select * from forwardingnodes12");
				while(rs.next())
				{
					if(forwnodes.equals(""))
					{
						forwnodes=rs.getString(1);	
					}
					else
					{
						forwnodes=forwnodes+"$"+rs.getString(1);
					}									
				}				
				dos6.writeUTF(forwnodes);
			}
		}
		catch (Exception ex)
		{
		}
			
	}
}
class nonforwardnode extends Thread
{
	public void run()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con1=DriverManager.getConnection("Jdbc:Odbc:selvi","","");
			Statement st1=con1.createStatement();	
			ServerSocket ssoc6= new ServerSocket(6660);		
			DataOutputStream dos6;
			DataInputStream dis6;
			ResultSet rs,rs1;
			String reply="",nonforwnodes="";
			while(true)
			{
				Socket soc6 = ssoc6.accept();
				System.out.print("Server has connected! to get the forwarding nodes onlyn");	
				dos6=new DataOutputStream(soc6.getOutputStream());
				dis6=new DataInputStream(soc6.getInputStream());
				String request=dis6.readUTF();	
				System.out.println("request:"+request);
				rs=st1.executeQuery("select * from nonforwardingnodes12");
				while(rs.next())
				{
					if(nonforwnodes.equals(""))
					{
						nonforwnodes=rs.getString(1);	
					}
					else
					{
						nonforwnodes=nonforwnodes+"$"+rs.getString(1);
					}									
				}				
				dos6.writeUTF(nonforwnodes);
			}
		}
		catch (Exception ex)
		{
		}
			
	}
}
	
		
 class Serversample
{
	public static void main(String[] args) 
	{
		Topology tp=new Topology();	
		FetchNode fn=new FetchNode();
		SelectNode sn=new SelectNode();
		LoginNode ln=new LoginNode();
		TransferNode tn=new TransferNode();
		Forwarding f=new Forwarding();
		DataTransfer d=new DataTransfer();
		ip_port ip=new ip_port();
		neighip nip=new neighip();
		nodefailure nf=new nodefailure();
		forwardnode forw=new forwardnode();
		nonforwardnode nonforw=new nonforwardnode();
		tp.start();	
		fn.start();
		sn.start();
		ln.start();
		tn.start();
		f.start();
		d.start();
		ip.start();
		nip.start();
		nf.start();
		forw.start();
		nonforw.start();
	}
}