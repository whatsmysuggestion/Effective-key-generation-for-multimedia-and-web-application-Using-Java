/****************************************************************/
/*                      key	                            */
/*                                                              */
/****************************************************************/
import java.math.BigInteger;
import java.util.*;


class calculation
{
	 long great,a;
	 double aa,bb,cc,rm;
	 long rd;
	 long eval;
	 long calE(long pi,long p,long q)
	 {
		  great=0;
		  aa=Math.log(pi)/Math.log(10);
		  bb=Math.floor(aa);
		  cc=Math.pow(10,bb);
		  rm=Math.random()*cc;
		  //System.out.println("rm :"+rm);
		  rd=Math.round(rm);
		  //System.out.println("rd :"+rd);
		  while(great != 1)
		  {
			   rd=rd+1;
			   great=GCD(rd,pi);
			   pi=(p-1)*(q-1);
		  }
		  return rd;
	 }

	 long GCD(long e,long pi)
	 {
		 //System.out.println("e :"+e);
		  if(e > pi)
		  {
			   while(e%pi != 0)
			   {
					a=e%pi;
					e=pi;
					pi=a;
			   }
			   great=pi;
		  }
		  else
		  {
			   while(pi%e != 0)
			   {
					a=pi%e;
					//System.out.println("a :"+a);
					pi=e;
					//System.out.println("pi :"+pi);
					e=a;
					//System.out.println("e12 :"+e);
			   }
			   great=e;
		  }
		  return great;
	 }
}

public class GenKeys 
{

	String pstr = "";
	String qstr = "";
	String s, output;
	long p,q,pi,e,val,ds,r,qd;;
	static long d,n;
	int i,cnt,inc=0;
	long rst[] = new long[100];
	long div[] = new long[100];
	long qud[] = new long[100];
	long rem[] = new long[100];
	String fe = "";
	String fd = "";
	String fn = "";
	String PubKey = "";
	String PriKey = "";
	String concat="";
		// End of variables declaration
	
	GenKeys()
	{		
	}

	public String getKeys()
	{
		calculation cal = new calculation();
		Random rnd1 = new Random(0);
		Random rnd2 = new Random(0);
		BigInteger prime1 = BigInteger.probablePrime(10, rnd1);
		BigInteger prime2 = BigInteger.probablePrime(15, rnd2);
		p = prime1.longValue();
		q = prime2.longValue();

		//System.out.println(p);
		//System.out.println(q);
	//	q=p;
			 n=p*q;
  			 pi=(p-1)*(q-1);
  			 e=cal.calE(pi,p,q);
  			 //System.out.println("e :"+e);

			qd=pi/e;
   			r=pi%e;
   			cnt=0;
   			rst[cnt]=pi;
   			div[cnt]=e;
   			qud[cnt]=qd;
   			rem[cnt]=r;
			//System.out.println("val	ds	qd	r");
   			do
   			{
				cnt++;
				val=div[cnt-1];	//val=e
				ds=rem[cnt-1];//ds = r
				qd=val/ds; // qd=e/r
				r=val%ds;  //  r=e%r
				//System.out.println(val+"\t"+ds+"\t"+qd+"\t"+r);
				if(r != 0)
				{
					 rst[cnt]=val;		//e
					 div[cnt]=ds;		//r
					 qud[cnt]=qd;		//e/r
					 rem[cnt]=r; 		//e%r
				}
   			}while(r != 0);
   			long p1,q1,s1,t1,p2,q2,s2,t;

			p1=rst[cnt-1];
			q1=-qud[cnt-1];
			s1=div[cnt-1];
			t=1;

			for(i=(cnt-2);i>=0;i--)
			{
				 p2=rst[i];
				 q2=-qud[i];
				 s2=div[i];
				 if(s1==rem[i])
				 {
				   if(p1==s2)
	   				{
						p1=p2;
						t1=t;
						t=q1;
						q1=t1+(q1*q2);
						s1=s2;
	   				}
				 }
			}
			if(q1<0)
				 d=pi+q1;
			else
				 d=q1;
				fe = String.valueOf(e);
				fd = String.valueOf(d);
				fn = String.valueOf(n);
		
				//output ="\n\nPublic Key :"+"\n   Exponent Value (e) = "+fe+"\n   N Value (n)        ="+fn+"\n\nPrivate Key :"+"\n  Decryption Key (d)  ="+fd+"\n  N Value (n)         ="+fn;
	            //         System.out.println(output);
				inc++;
				if(inc==10)
					inc=0;
				else
				{
					if(fd.length()==7)
						fd+=inc;
					if(fd.length()==6)
					{
						//String s=Convert.intToString(inc,);
						fd=fd+inc;
						fd = String.valueOf(fd);
						fd+=inc;
					}
					if(fd.length()==5)
					{
						fd+=inc;
						fd+=inc;
						fd+=inc;
					}
					concat+=fd+"#";
					System.out.println("The private key is "+concat);
				}
				return concat;
	}

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		//GenKeys gd = new GenKeys();
		//for(int i=0;i<2;i++)
		//gd.getKeys();
	}



}
