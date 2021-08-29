import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KGC
{


	ServerSocket ss;
	DataInputStream dis;
	DataOutputStream dos;
	String str,sctkey,sender,receiver,subject,data;
	Connection con;
	Statement st;
	ResultSet rs;
	int n,ch;
	FileInputStream fin;
	String node1="",node2="";

	public KGC( )
	{

		try
		{
			System.out.println("The KGC Waiting for the Message");
			ss=new ServerSocket(7000);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:EfficientKey","sa","");
			st=con.createStatement();

			fin = new FileInputStream("Group1.txt");
			while((ch=fin.read())!=-1)
				node1+=(char)ch;
			node1.trim();
			fin = new FileInputStream("Group2.txt");
			while((ch=fin.read())!=-1)
				node2+=(char)ch;
			node2.trim();

			System.out.println("The IP Address of Group1 "+node1);
			System.out.println("The IP Address of Group2 "+node2);

			while(true)
			{
				Socket s=ss.accept();
				System.out.println("Server socket accepts socket request");
				dis=new DataInputStream(s.getInputStream());
				str=dis.readUTF();
				System.out.println(str);
				String cnt[]=str.split("#");

				if (cnt[0].equals("keys") )
				{
					String info="keys";
					String id=cnt[1];
					n=Integer.parseInt(cnt[2]);
					String keys=generateKeys(n);
					sendResponse(info,id,keys);
				}
				else if(cnt[0].equals("rekeys"))
				{
					String info="rekeys";
					String gid=cnt[1];
					int n=Integer.parseInt(cnt[2]);
					String users[]=new String[n];
					for(int i=0;i<n;i++)
						users[i]=cnt[i+3];

					String keys=generateKeys(n);
					int l=keys.length();
					keys=keys.substring(0,l-1);
					String key[]=keys.split("#");

					String str="";
					for(int i=0;i<n;i++)
						str+=users[i]+"#"+key[i]+"#";
					sendResponse(info,gid,str);

				}
				else
					forwardMessage(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
	public void forwardMessage(String str)
	{
		try
		{
			String[] parsestr=str.split("#");
			receiver=parsestr[0];
			sender=parsestr[1];
			sctkey=parsestr[2];
			subject=parsestr[3];
			data=parsestr[4];
			if(receiver.substring(0, 2).equals("G2"))
			{
				Socket s1=new Socket(node2,3000);
				dos=new DataOutputStream(s1.getOutputStream());
				dos.writeUTF(str);
				String str1=dis.readUTF();
				dos.writeUTF(str1);
				System.out.println("The message is forwarded to "+receiver);
			}
			if(receiver.substring(0, 2).equals("G1"))
			{
				Socket s1=new Socket(node1,3000);
				dos=new DataOutputStream(s1.getOutputStream());
				dos.writeUTF(str);
				String str1=dis.readUTF();
				dos.writeUTF(str1);
				System.out.println("The message is forwarded to "+receiver);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Message are not forwarded to "+ receiver+" "+ex);
		}
	}

	public String generateKeys(int c)
	{
		String keys="";
		GenKeys gk=new GenKeys();
		for(int i=0;i<c;i++)
		{
			keys=gk.getKeys();
		}
		System.out.println(keys);
		return keys;
	}

	public void sendResponse(String info,String id,String keys)
	{
		try
		{
			String adrs;
			if(id.equals("G1"))
				adrs=node1;
			else
				adrs=node2;
			Socket s1=new Socket(adrs,3000);
			dos=new DataOutputStream(s1.getOutputStream());
			String s=info+"#"+id+"#"+keys;
			int n=s.length();
			s=s.substring(0,n-1);
			System.out.println(s);
			dos.writeUTF(s);
			System.out.println("Send the Key Response to the Group");
		}
		catch(Exception e)
		{
			System.out.println("Not able to send keys to the Grp Ctrler "+e);
		}
	}
	public static void main(String args[])
	{
		new KGC();

	}

}
