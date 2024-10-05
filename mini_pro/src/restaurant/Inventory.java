package restaurant;
import java.util.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
public class Inventory {

		Statement stmt;
		 ResultSet rs;
		 Connection con;
		 String qry=null;
		 Conn db=new Conn();
		 int count=0;
		      Scanner sc=new Scanner(System.in);
		      List <Item> list=new ArrayList <>();
		      Main m;
		      public void addP(Item s) {
		     boolean sts=false;
		     try {
		     con=(Connection) db.getDBConnection();
		     stmt=((Connection) con).createStatement();
		     count=stmt.executeUpdate("insert into restaurant(ID,Name,cost,rating,qty) values('"+s.getID()+"','"+s.getName()+"','"+s.getCost()+"','"+s.getRating()+"','"+s.getQty()+"')");
		     if(count==1)
		     sts=true;
		     else
		     throw new Exception();
		     }
		     catch(Exception ex) {
		     System.out.println(ex.getMessage());
		     }
		     //list.add(s);
		      }
		      public void update(Item s) {
		     boolean sts=false;
		     try {
		     con=db.getDBConnection();
		     stmt=con.createStatement();
		     count=stmt.executeUpdate("update restaurant set cost="+s.getCost()+" where name='"+s.getName()+"'");
		     if(count==1)
		     sts=true;
		     else
		     throw new Exception();
		     }catch(Exception ex) {
		     System.out.println(ex);
		     }
		     //System.out.println("Successfully updated");
		      }
		      public Item search(String idu) {
		    for(int i=0;i<list.size();i++) {
		    if(list.get(i).getID().equals(idu))
		    return list.get(i);
		    }
		return null;
		      }
		      public void Remove(String idr) {
		 	     boolean sts=false;
		 	     try {
		 	     con=db.getDBConnection();
		 	     stmt=con.createStatement();
		 	     count=stmt.executeUpdate("delete from restaurant where id='"+idr+"'");
		 	     if(count==1)
		 	     sts=true;
		 	     }catch(Exception ex) {
		 	     System.out.println(ex);
		 	     System.out.println("Successfully Deleted");
		 	     }
		 	     /*for(int i=0;i<list.size();i++) {
		      if(list.get(i).getid().equals(idr))
		       list.remove(i);
		      }*/
		      }
		      public void show() {
		     try {
		     con = db.getDBConnection();
		     stmt=(Statement) con.createStatement();
		     rs=((java.sql.Statement) stmt).executeQuery("select * from restaurant");
		     while(rs.next())
		     System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
		     }
		     catch(Exception ex) {
		     System.out.println(ex.getMessage());
		     }
		     //System.out.println(list);
		      }
		      public void logout() {
		    System.out.println("Logged out");
		    m.main(null);
		    for(Item s:list) {
		    System.out.println(s);
		    }
		      }

}
