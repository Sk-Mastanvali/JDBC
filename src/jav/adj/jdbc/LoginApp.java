package jav.adj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con= null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			sc = new Scanner(System.in);
			String user = null;
			int pswd = 0;
			if(sc != null) {
				//System.out.println("Enter the user name ::");
				//user = sc.next();
				System.out.println("Enter the id :: ");
				pswd = sc.nextInt();
			}//if
			
			//user = "'"+user+"'";
			//pswd ="'"+pswd+"'";
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mastan","123456");
			
			if(con != null)
				st = con.createStatement();
			
			String query = "select count(*) from emp_chennai where eid = "+pswd;
			
			if(st != null)
				rs = st.executeQuery(query);
			
			if(rs != null)
				rs.next();
			int count = rs.getInt(1);
			
			if(count ==0)
				System.out.println("Invalid.");
			else
				System.out.println("valid.");
		}//try
		catch (Exception e){
			System.out.println(e);
		}finally {
			try {
				if (st != null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if (sc != null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
