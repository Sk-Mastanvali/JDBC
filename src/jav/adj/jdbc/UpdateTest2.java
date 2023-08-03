//update using student number.

package jav.adj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest2 {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con =null;
		Statement st = null;
		
		try {
			sc = new Scanner(System.in);
			int newNum =0;
			String newName =null,newCity=null;
			float newAvg=0.0f;
			int keyId =0;
		
			//reading inputs
			System.out.print("Enter the student number :");
			newNum = sc.nextInt();
			System.out.print("Enter the student name :");
			newName = sc.next();
			System.out.print("enter the city : ");
			newCity =sc.next();
			System.out.print("enter the average :");
			newAvg = sc.nextFloat();
			System.out.print("ENTER THE KEY ID :");
			keyId = sc.nextInt();
			
			//changing in to required query
				//no need prepare key

			System.out.println(keyId);	
			//loading a class
			//Class.forName("oracle.jdbc.driver.Oracledriver");

			//connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");

			//statement object
			if(con != null)
				st = con.createStatement();

			//preparing a query
			//SQL> INSERT INTO STUDENT VALUES(115,'MAHESH','MUMBAI',85.66);  its inserting of values
			//UPDATE STUDENT SET SNO=105,SNAME='MAHI',SADD='MUMBI',SAVG=75.98 WHERE SADD='delhi';
			String query = "UPDATE STUDENT SET SNO="+newNum+",SNAME='"+newName+"',SADD='"+newCity+"',SAVG="+newAvg+ "WHERE SNO="+keyId;
			
			//send and execute query
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