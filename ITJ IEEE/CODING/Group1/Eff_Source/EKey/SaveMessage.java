import java.io.*;
import java.net.*;
import java.sql.*;
public class SaveMessage
{
	Socket s;
	ServerSocket ss;
	DataInputStream dis;
	String str,id,sctkey,sender,receiver,subject,fname,flag,gettable;
	Connection con,con1;
	Statement st,st1;
	ResultSet rs;
	DBClass db=new DBClass();
	public SaveMessage( )
	{
		try
		{
			System.out.println("Waiting for the Message");
			ss=new ServerSocket(3000);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:EfficientKey","sa","");
			st=con.createStatement();
			con1=DriverManager.getConnection("jdbc:odbc:EfficientKey","sa","");
			st1=con1.createStatement();

			while(true)
			{
				s=ss.accept();
				System.out.println("Server socket accepts socket request");
				dis=new DataInputStream(s.getInputStream());
				str=dis.readUTF();
				System.out.println(str);
				String[] parsestr=str.split("#");
				System.out.println("Message "+str);
				if(parsestr[0].equals("keys"))
				{
					String gid=parsestr[1];
					int n=parsestr.length;
					String keys[]=new String[n-2];
					for(int i=0;i<n-2;i++)
						keys[i]=parsestr[i+2];
					System.out.println("Retreive the keys");
					System.out.println("The gid is"+gid);
					db.assignKeys(gid, keys);
					//Thread.sleep(2000);
					System.out.println("The keys are assigned to the users");
					for(int i=0;i<keys.length;i++)
					{
						sendResponse(gid,keys[i]);
						Thread.sleep(1000);
						System.out.println("Send Response to the User");
					}
					continue;
				}
				if(parsestr[0].equals("rekeys"))
				{
					int n=parsestr.length;
					int count=(n-2)/2;
					String gid=parsestr[1];
					String users[]=new String[count];
					String keys[]=new String[count];
					int incr1=2,incr2=3;
					System.out.println("The records are "+count);
					for(int i=0;i<count;i++)
					{
						users[i]=parsestr[incr1];
						keys[i]=parsestr[incr2];
						System.out.println("The user "+users[i]+" is rekeyed with "+keys[i]);
						incr1=incr1+2;
						incr2=incr2+2;
					}
					System.out.println("The keys are assigned");

					for(int i=0;i<count;i++)
						System.out.println("The user "+users[i]+" is rekeyed with "+keys[i]);
					db.assignReKeys(users,keys);
					System.out.println("The keys are rekeyed");
					for(int i=0;i<keys.length;i++)
					{
						sendResponse(gid,keys[i]);
						System.out.println("Send Response to the User");
					}
					continue;
				}
				else
				{
					receiver=parsestr[0];
					sender=parsestr[1];
					sctkey=parsestr[2];
					subject=parsestr[3];
					fname=parsestr[4];

					String str=dis.readUTF();
					System.out.println("Receive the File");
					FileOutputStream fis=new FileOutputStream(fname);
					System.out.println("Write into the file");
					fis.write(str.getBytes());
					int flag=0;
					System.out.println("The receiver is "+receiver);
					if(receiver.length()>4)
					{
						if(receiver.substring(2,5).equals("GCI"))
							gettable="GrpCtrlIntmer";
						else if(receiver.substring(2,5).equals("LGC"))
							gettable="LclGrpCtrler";
						else
							gettable="Users";
					}
					else
						gettable="GrpCtrler";
					System.out.println("The table name is "+gettable);

					st.executeUpdate("Insert into "+gettable+" values ('"+receiver+"','"+sender+"','"+sctkey+"','"+subject+"','"+fname+"',"+flag+")");
					System.out.println("Successfully Inserted");
					continue;
				}
			}

		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}

	public void sendResponse(String gid,String keys)
	{
		try
		{
			rs=st.executeQuery("select UserId from UserLogin where UserId like '"+gid+"%' and SctKey = '"+keys+"'");
			if(rs.next())
			{
				String id=rs.getString("UserId");
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
				System.out.println("The table name is "+gettable);
				int flag=0;
				st1.executeUpdate("Insert into "+gettable+" values ('"+id+"','KGC','********','Your key','"+keys+"',"+flag+")");
				System.out.println("Successfully Inserted");
			}
		}
		catch(Exception e)
		{
			System.out.println("The Keying information is not send to the members");
		}
	}

	public static void main(String args[])
	{
		new SaveMessage();

	}
}