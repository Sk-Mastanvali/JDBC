package jav.adj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PSInsertTest {

	private static final String eiq = "INSERT INTO EMP_CHENNAI VALUES(?,?,?)";
	
	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps =null;
		
		try {
			sc = new Scanner(System.in);
			int count = 0;
			if(sc != null)
				System.out.print("Enter the number of Employees :");
			count = sc.nextInt();
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mastan","123456");
			
			if(con!=null)
				ps = con.prepareStatement(eiq);
			
			//reading values from end user.
			if(ps != null && sc != null)
				for(int i=1;i<=count;i++) {
					System.out.println("Employee "+i+" details ::");
					System.out.print("Employee ID :"); int id = sc.nextInt();
					System.out.print("Employee name : ");String name =sc.next();
					System.out.print("Employee salary : ");double sal =sc.nextDouble();
					
					//set each employee details as pre-compiled.
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setDouble(3, sal);
					
					//Execute
					int result = ps.executeUpdate();
					
					//process execution
					if(result == 0)
						System.out.println("Not Inserted.");
					else
						System.out.println(i +"rows inserted successfully.");
				}//for
		}//try
		catch(Exception e) {
			System.out.println(e);
		}//catch
	}//main
}//class
