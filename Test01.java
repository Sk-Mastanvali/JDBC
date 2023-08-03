//Test01.java

import java.util.*;
import java.sql.*;

class Test01 {
	public static void main(String[] args) throws Exception {
		
		//reading inputs from the end-user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the starting range of salary :: ");
		float startSalary = sc.nextFloat();
		System.out.print("Enter the ending range of salary :: ");
		float endSalary = sc.nextFloat();

		//loading of class
		//Class.forName("oracle.jdbc.driver.OracleDriver")
			//auto loading
		
		//Connection object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");

		//statement object
		Statement st = con.createStatement();

		//preparing query
		//select empno,ename,job,sal from emp where sal >= 1000 and sal<= 3000;
		String query ="select empno,ename,job,sal from emp where sal >="+startSalary+" and sal<="+endSalary;
		System.out.println(query);

		//send and execute query
		ResultSet rs = st.executeQuery(query);

		System.out.println("Employees having the Salary range from" +startSalary+"to"+ endSalary);

		//processing of rsultset
		while(rs.next() != false)
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		
		//closing of objects
		rs.close();
		st.close();
		con.close();
		sc.close();
	}
}


//These is the first code using jdbc.