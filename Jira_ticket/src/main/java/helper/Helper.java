package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Jira;

public class Helper {

	public static String loginUser(String email, String passWordd) {
		
		String result="";
		String url="jdbc:mysql://localhost:3306/finalProject?characterEncoding=latin1";
		String uname="student";
		String pass="student";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,uname,pass);
			
			PreparedStatement ps=con.prepareStatement("select * from userDetails  where email =? and passWordd =?");
			
			ps.setString(1, email);
			ps.setString(2, passWordd);
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
			  result = rs.getString(2);
			  break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean InsertUser(String firstname, String lastname, String mobile, String email, String password) {
		boolean result=false;
		String url="jdbc:mysql://localhost:3306/finalProject?characterEncoding=latin1";
		String uname="student";
		String pass="student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection(url,uname,pass);
			
			PreparedStatement pst=cn.prepareStatement("insert into userDetails(firstname, lastname, mobile, email, passwordd)" + "values(?,?,?,?,?)");
			
			pst.setString(1, firstname);
			pst.setString(2, lastname);
			pst.setString(3, mobile);
			pst.setString(4, email);
			pst.setString(5, password);

			int row=pst.executeUpdate();
			
			if(row>0)
				result=true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public static boolean createticket( String resAssinee, String resrepoter, String resheading, String resstatus,String resnotify) {
		boolean result=false;
			String url="jdbc:mysql://localhost:3306/createticket?characterEncoding=latin1";
			String user="student";
			String passw="student";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,user,passw);
				PreparedStatement pst=con.prepareStatement("insert into Details2 ( Assignee, repoter, Heading, Sdatus, Notify) values(?,?,?,?,?)");
				 int i=0;
				//pst.setString(1, resid);
				pst.setString(++i, resAssinee);
				pst.setString(++i, resrepoter);
				pst.setString(++i, resheading);
				pst.setString(++i, resstatus);
				pst.setString(++i, resnotify);
				//ResultSet rs=pst.executeQuery();
				int row=pst.executeUpdate();
				if(row>0)
				 {
					result= true;
				   
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return result;
	}
	
	public static ArrayList<Jira> Viewallticket() {
		
		String url="jdbc:mysql://localhost:3306/createticket?characterEncoding=latin1";
		String user="student";
		String passw="student";
		
		ArrayList<Jira> al=new ArrayList<Jira>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,passw);
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from Details2;");
			
			Jira j=null;
			
			while(rs.next()) {
				
				j=new Jira(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				
				al.add(j);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return al;	
	}
	
	public static boolean deleteid(int id) {
		boolean result= false;
		String url="jdbc:mysql://localhost:3306/createticket?characterEncoding=latin1";
		String user="student";
		String passw="student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,passw);
			
			PreparedStatement pt = con.prepareStatement("delete from Details2\r\n"
					+ " where Userid=?" );
			
			pt.setInt(1, id);
			
			int i=pt.executeUpdate();
			
			while(i>0) {
				result=true;
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	
	return result;
}
	public static ArrayList<String> showmail(){
		ArrayList<String> al=new ArrayList<String>();
		String url="jdbc:mysql://localhost:3306/finalProject?characterEncoding=latin1";
		String uname="student";
		String pass="student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userDetails");
			
			while(rs.next())
				al.add(rs.getString(5));
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}

	public static ArrayList<Jira> Update(int id) {
		boolean result=false;
		ArrayList<Jira> a1=new ArrayList<Jira>();
		String url="jdbc:mysql://localhost:3306/createticket?characterEncoding=latin1";
		String user="student";
		String passw="student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,passw);
			
			PreparedStatement pt=con.prepareStatement("select * from Details2 where Userid=?");
			
			//pt.setString(2, Assignee);
			pt.setInt(1, id);
			ResultSet rs=pt.executeQuery();
			
			//al.add();
			//int i= pt.executeUpdate();
			Jira jira=null;
			while(rs.next()) {
				jira= new Jira(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				a1.add(jira);
			break;}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return a1;
	}

	
	public static boolean edit(String assignee, String repoter, String heading, String status, String notify,int id) {
		boolean result=false;
		String url="jdbc:mysql://localhost:3306/createticket?characterEncoding=latin1";
		String user="student";
		String passw="student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,passw);
			
			PreparedStatement pt=con.prepareStatement("update Details2 set  Assignee=?, repoter=?, Heading=?,Sdatus=?,Notify=? where Userid=?");
			
			//int j=0;
			pt.setString(1, assignee);
			pt.setString(2, repoter);
			pt.setString(3, heading);
			pt.setString(4, status);
			pt.setString(5, notify);
			pt.setInt(6, id);
			
			int i=pt.executeUpdate();
			while(i>0) {
				result=true;
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}
