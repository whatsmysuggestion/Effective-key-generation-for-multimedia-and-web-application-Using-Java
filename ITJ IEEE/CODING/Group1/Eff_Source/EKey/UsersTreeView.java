import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import java.sql.*;

public class UsersTreeView extends JFrame {
	int n;
  public UsersTreeView()
  {
	  super("Group JTree View");
	  try
	  {
		  DBClass db=new DBClass();
		  n = db.getUsersCount("G1");
		  System.out.println("users are "+n);
		  String[] strs = db.getUsers("G1",n);

		  DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[strs.length];

		  for(int i=0;i<strs.length;i++)
		  {
			  for(int j=1;j<strs.length-1-i;j++)
			  {
				  if(strs[j].compareTo(strs[j+1])>0 )
				  {
					  String temp=strs[j];
					  strs[j]=strs[j+1];
					  strs[j+1]=temp;
				  }
			  }
		  }
		  for(int i=0;i<strs.length;i++)
			  System.out.println(strs[i]);
		  for(int i = 0; i < strs.length; i++)
			  nodes[i] = new DefaultMutableTreeNode(strs[i]);

		  for(int i=1;i<strs.length;i++)
		  {
			  System.out.println("The user "+strs[i]+" is going to add in the Tree");
			  if(strs[i].substring(2, 5).equals("GCI") )
				  nodes[0].add(nodes[i]);
			  if((strs[i].substring(2, 6).equals("LGC1"))||(strs[i].substring(2, 6).equals("LGC2")))
				  nodes[1].add(nodes[i]);
			  if((strs[i].substring(2, 6).equals("LGC3"))||(strs[i].substring(2, 6).equals("LGC4")))
				  nodes[2].add(nodes[i]);
			  if(strs[i].substring(2, 6).equals("USR1"))
			  {
				  if(strs.length==3)
					  nodes[0].add(nodes[i]);
				  else if(strs.length==5)
					  nodes[1].add(nodes[i]);
				  else if(strs.length==7)
				  		nodes[1].add(nodes[i]);
				  else
					  nodes[3].add(nodes[i]);
			  }
			  if(strs[i].substring(2, 6).equals("USR2"))
			  {
			  	  	if(strs.length==3)
			  		  nodes[0].add(nodes[i]);
			  		else if(strs.length==5)
			  		  nodes[1].add(nodes[i]);
			  		else if(strs.length==7)
			  		  nodes[1].add(nodes[i]);
			  		else
			  			nodes[3].add(nodes[i]);
			  }
			  if(strs[i].substring(2, 6).equals("USR3"))
			  {
				  if(strs.length==5)
					  nodes[0].add(nodes[i]);
				  else if(strs.length==7)
				  		nodes[2].add(nodes[i]);
				  else if(strs.length==9)
					  nodes[1].add(nodes[i]);
				  else
					  nodes[4].add(nodes[i]);
			  }
			  if(strs[i].substring(2, 6).equals("USR4"))
			  {
				  if((strs.length==7)||(strs.length==9))
					  nodes[2].add(nodes[i]);
				  else
					  nodes[4].add(nodes[i]);
			  }
			  if(strs[i].substring(2, 6).equals("USR5"))
			  {
				  if((strs.length==9)||(strs.length==11))
					  nodes[2].add(nodes[i]);
				  else
					  nodes[5].add(nodes[i]);
			  }
			  if(strs[i].substring(2, 6).equals("USR6"))
			  {
				  if(strs.length==11)
					  nodes[2].add(nodes[i]);
				  else
					  nodes[5].add(nodes[i]);
			  }
			  if((strs[i].substring(2, 6).equals("USR7"))||(strs[i].substring(2, 6).equals("USR8")))
			  {
				  if(strs.length==13)
					  nodes[2].add(nodes[i]);
				  else
					  nodes[6].add(nodes[i]);
			  }
		  }
		  JTree tree = new JTree(nodes[0]);
		  tree.setEditable(true);
		  JScrollPane sp = new JScrollPane(tree);
		  getContentPane().add(sp, BorderLayout.CENTER);
		  this.setSize(500, 200);
		  this.setVisible(true);
	  }
	  catch(Exception e)
	  {
		  // System.out.println("Database Connectivity Error "+e);
		  e.printStackTrace();
	  }

  }

  public static void main(String args[])
  {
        	//new UsersTreeView();

  }
}


