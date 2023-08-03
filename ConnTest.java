// ConnTest.java

import java.sql.*;
import java.util.*;

class ConnTest {
	public static void main(String[] args) throws Exception {

		//Create jdbc driver class object
		//oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();

		//Register  jdbc driver class object
		//DriverManager.registerDriver(obj);

		//instead of 2 lines we can use classfor 
		//Class.forName("oracle.jdbc.driver.OracleDriver");

		//from 4.x version no need of  creating class object and registering 

		//Establish Connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");

		//statement object
		Statement st = con.createStatement();
		System.out.println("Class name of statement object is :: " + st.getClass());

		//execute query on statement object  {to send and execute sql   (select-statements) {resultset is return type
		///ResultSet rs =st.executeQuery("");

		//execute update on statement object  {Non-select Statements  {returntype is int
		///int count = st.executeUpdate("");


		if (con == null)
			System.out.println("Connection not Established");
		else
			System.out.println("Connection Established");
	}
}
//C:\db_home\jdbc\lib\ojdbc8.jar