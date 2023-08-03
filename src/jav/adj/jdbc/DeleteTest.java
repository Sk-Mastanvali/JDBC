package jav.adj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con =null;
		Statement st = null;
		int sno=0;
		
		try {
			sc = new Scanner(System.in);
			//reading inputs
			System.out.println("Enter the number of student we want to delete ::");
			sno = sc.nextInt();
			
			//loading a class
			//Class.forName("oracle.jdbc.driver.Oracledriver");
			
			//connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");
			
			//statement obj
			if(con != null)
				st = con.createStatement();
			
			//preparing a query
			//SQL> DELETE FROM STUDENT WHERE SNO=110;
			String query = "DELETE FROM STUDENT WHERE SNO="+sno;
			
			int count =0;
			count = st.executeUpdate(query);
			
			if(count == 0)
				System.out.println("No data to UPDATE");
			else
				System.out.println("Number of rows effected :" +count);
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
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
		}//finally

	}//main

}//class
