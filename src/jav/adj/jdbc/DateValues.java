package jav.adj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateValues {
	public static String idq ="INSERT INTO PERSON_DETAILS VALUES (?,?,?,?,?)";
	
	static String user;
	static String pswd;
	
	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			sc = new Scanner(System.in);
			
			System.out.println("user :");
			user =sc.next();	
			System.out.println("password :");
			pswd =sc.next();
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,pswd);
			
			if(con == null)
				System.out.println("Not Connected.");
			else
				ps = con.prepareStatement(idq);
			
			int pid =0;
			String pname,pdob,pdoj,pdom = null;
			if(sc != null) {
				System.out.println("person id :");pid = sc.nextInt();
				System.out.println("name:");pname = sc.next();
				System.out.println("DOb : DD-MM-YYYY ::");pdob = sc.next();
				System.out.println("DOJ : YYYY-MM-DD ::");pdoj = sc.next();
				System.out.println("Dom : mm-dd-yyyy :: ");pdom = sc.next();
				
				//System.out.println(pdob+pdoj+pdom);
				
				//converting string date objects to sql date objects.
				//DOB
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				java.util.Date udob = sdf.parse(pdob);
				//System.out.println(udob);
				long ms = udob.getTime();
				java.sql.Date sdob = new java.sql.Date(ms);
				//System.out.println(ms);
				//System.out.println(sdob);
				
				//DOJ
				java.sql.Date sqdoj = java.sql.Date.valueOf(pdoj);
				
				//DOM
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
				java.util.Date udob1 = sdf1.parse(pdob);
				//System.out.println(udob);
				long ms1 = udob1.getTime();
				java.sql.Date sdob1 = new java.sql.Date(ms1);
				
				if(ps != null) {
					ps.setInt(1, pid);
					ps.setString(2, pname);
					ps.setDate(3, sdob);
					ps.setDate(4, sqdoj);
					ps.setDate(5, sdob1);
					
					int count = ps.executeUpdate();
					
					if(count == 0)
						System.out.println("No data is Inserted/Effected.");
					else
						System.out.println(count + "rows is effected.");
					
				}	
			}
			}catch(Exception e) {
				System.out.println(e);
			}finally {			
				try {
					if(ps  != null)
						ps.close();
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
			}
	}

}
