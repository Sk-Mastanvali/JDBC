package jav.adj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc =null;
		Connection con = null;
		Statement st =null;
		ResultSet rs=null;
		try {
			sc = new Scanner(System.in);
			String initChar = null;
			System.out.print("Enter the intial character ::");
			initChar = sc.next();
			
			//Converting initial query into required query
			initChar = "'"+initChar.toUpperCase()+"%'";
			
			//loading of class
			//Class.forName("oracle.jdbc.driver.Oracledriver");
				//auto-loading
			
			//connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");
			
			//statement object
			if(con != null )
				st = con.createStatement();
			
			//preparing query
			//select empno,ename,job,sal from emp where ename like ('A%')
			String query ="select empno,ename,job,sal from emp where ename like ("+initChar+")";
			System.out.println("The query is :: "+query);
			
			//sending and executing query
			if(st != null)
				rs = st.executeQuery(query);
			
			//processing query
			System.out.println("Deatails of the employee whose intial character is " +initChar);
	
			if(rs != null) {
				boolean isEmpty = false;
				while(rs.next()) {
					isEmpty = true;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}
				if(isEmpty == false)
					System.out.println("NO data to display.");
			
			} //if
		} //try
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rs != null)
					rs.close();
			}
			catch(SQLException se) {
				if(se.getErrorCode()>=900 && se.getErrorCode()<=99)
					System.out.println("Error in sql keywords");
				se.printStackTrace();
			}
			
			try {
				if(st != null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc != null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		} //finally
	}//main
}//class.

