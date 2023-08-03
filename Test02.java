//Test02.java
//Following the coding standards.

package jav.adj.jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

class Test02 {
	public static void main(String[] args) {

		Scanner sc = null;
		String desg1 = null;
		String desg2 = null;
		String desg3 = null;
		Connection con=null;
		Statement st = null;
		ResultSet rs= null;

		try{
			//reading values from end-user
			sc = new Scanner(System.in);
			System.out.print("Enter the Designation-1 :: ");
			desg1 = sc.next();
			System.out.print("Enter the Designation-1 :: ");
			desg2 = sc.next();
			System.out.print("Enter the Designation-1 :: ");
			desg3 = sc.next();

			//converting the values in to required query values.
			String DESG1 = "'"+desg1.toUpperCase()+"'";
			String DESG2 = "'"+desg2.toUpperCase()+"'";
			String DESG3 = "'"+desg3.toUpperCase()+"'";

			//loading class
				//autoomatic
			
			//connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");

			//statement object
			if(con != null)
				st = con.createStatement();

			//preaparing query
			//select empno,ename,job,sal,depno from emp where job in ('desg1','desg2','desg3');

			String query ="SELECT EMPNO,ENAME,JOB,SAL  FROM EMP WHERE JOB IN ("+DESG1+","+DESG2+","+DESG3+") ORDER BY JOB" ;
			System.out.println(query);

			//send and execute query
			if(st != null)
				rs = st.executeQuery(query);
			
			//processing of query
			if(rs != null)
				System.out.println("Details  of the Employees with selected designation are :: ");
			while(rs.next() != false)
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			
		} //try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		finally{
			try{
				if(rs != null)
					rs.close(); 
			}
			catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(st != null)
					st.close(); 
			}
			catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(con != null)
					con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		} //finally

	} //main
} //class


//Moving to IDE.