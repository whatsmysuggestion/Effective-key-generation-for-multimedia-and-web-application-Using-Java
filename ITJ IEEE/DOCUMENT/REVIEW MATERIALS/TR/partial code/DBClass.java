import java.sql.*;

public class DBClass
{
	Connection c,c1;
	Statement s,s1;
	ResultSet rs;
	DBClass()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			c=DriverManager.getConnection("jdbc:odbc:EfficientKey","sa","");
			c1=DriverManager.getConnection("jdbc:odbc:EfficientKey","sa","");
			s=c.createStatement();
			s1=c1.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Database Connectivity Error "+e);
		}

	}
	public int getResult(String id,String pass) throws Exception
	{
		rs=s.executeQuery("select * from UserLogin where UserId = '"+id+"' and SctKey = '"+pass+"'");
		if(rs.next())
		{
			return 1;
		}
		else
			return 0;
	}
	public String getUsers(String gid)throws Exception
	{
		String users="";
		rs=s.executeQuery("select UserId from UserLogin where Userid like '"+gid+"%'");
		while(rs.next())
		{
			users+=rs.getString("UserId")+"#";

		}
		int l=users.length();
		users=users.substring(0,l-1);
		return users;
	}
	public String[] getUsers(String gid,int n)throws Exception
	{
		int i=0;
		String users[]=new String[n];
		rs=s.executeQuery("select UserId from UserLogin where UserId like '"+gid+"%'");
		while(rs.next())
		{
			users[i]=rs.getString("UserId");
			i++;
		}
		return users;
	}

	public String[] getReKeyingUsers(String gid,int n)throws Exception
	{
		int i=0;
		String users[]=new String[n];
		rs=s.executeQuery("select UserId from UserLogin where UserId like '"+gid+"%' and SctKey = '0'");
		while(rs.next())
		{
			users[i]=rs.getString("UserId");
			i++;
		}
		return users;
	}
	public void assignKeys(String gid,String keys[])throws Exception
	{
		int i=0;
		rs=s.executeQuery("select UserId from UserLogin where Userid like '"+gid+"%'");

		while(rs.next())
		{
			String id=rs.getString("UserId");
			s1.executeUpdate("Update UserLogin set SctKey = '"+keys[i]+"' where UserId = '"+id+"'");
			System.out.println("The key "+keys[i]+" are assigned to "+id+" user");

			i++;
		}
		System.out.println("The keys are assigned");
	}
	public void assignReKeys(String id[ ],String keys[ ])throws Exception
	{
		for(int i=0;i<keys.length;i++)
		{
			s.executeUpdate("Update UserLogin set SctKey = '"+keys[i]+"' where UserId = '"+id[i]+"'");
		}
		System.out.println("The Users keys are Rekeyinged-DBClass");

	}
	public int getUsersCount(String gid)throws Exception
	{
		int c=0;
		rs=s.executeQuery("select * from UserLogin where UserId like '"+gid+"%'");
		while(rs.next())
		{
			c++;
		}
		return c;

	}
	public int getNullUsers(String gid)throws Exception
	{
		int c=0;
		rs=s.executeQuery("select * from UserLogin where UserId like '"+gid+"%' and SctKey = '0'");
		while(rs.next())
		{
			c++;
		}
		return c;

	}
	public void addMember(String id)throws Exception
	{
		s.executeUpdate("Insert into UserLogin (UserId) values ('"+id+"')");
	}
	public void addMember(String id,double random)throws Exception
	{
		s.executeUpdate("Insert into UserLogin (UserId,SctCode) values ('"+id+"',"+random+")");
	}
	public String checkPassword(String code)throws Exception
	{
		String pass="";
		rs=s.executeQuery("select * from UserLogin where SctCode = '"+code+"'");
		if(rs.next())
		{
			pass+=rs.getString("UserId");
			pass+="/";
			pass+=rs.getString("SctKey");
		}
		return pass;
	}
	public void removeMember(String id)throws Exception
	{
		String gettable="";
		if(id.length()>4)
		{
			if(id.substring(2, 5).equals("GCI"))
				gettable="GrpCtrlIntmer";
			if(id.substring(2, 5).equals("LGC"))
				gettable="LclGrpCtrler";
			if(id.substring(2, 5).equals("USR"))
				gettable="Users";
		}
		gettable.trim();
		s.executeUpdate("Delete from "+gettable+" where Receiver = '"+id+"'");
		s.executeUpdate("Delete from UserLogin where UserId = '"+id+"'");
	}
	public String getSctKey(String id)throws Exception
	{
		String pass="";
		rs=s.executeQuery("Select * from UserLogin where UserId = '"+id+"'");
		if(rs.next())
		{
			pass=rs.getString("SctKey");
		}
		return pass;

	}
	public void updateRecord(String u1,String u2)throws Exception
	{
		String gettable="";
		if(u1.length()>4)
		{
			if(u1.substring(2, 5).equals("GCI"))
				gettable="GrpCtrlIntmer";
			if(u1.substring(2, 5).equals("LGC"))
				gettable="LclGrpCtrler";
			if(u1.substring(2, 5).equals("USR"))
				gettable="Users";
		}

		s.executeUpdate("Update "+gettable+" set Receiver = '"+u2+"' where Receiver = '"+u1+"'");
		System.out.println("Update the Table of user record");
		s.executeUpdate("Update UserLogin set UserId = '"+u2+"' where UserId = '"+u1+"'");
		System.out.println("Update the Table of Login record");
	}

}

