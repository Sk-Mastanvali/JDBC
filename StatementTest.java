//StatementTest.java
//In these programe we just seen how to use statement and result set object.
//it's an example code.

import java.sql.*;
import java.util.*;

class StatementTest {
	public static void main(String[] args) throws Exception {
		//loading class object
				//Class.forName("oracle.jdbc.driver.OracleDriver");  {Automatic loading ffrom 4x	

		//connection object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");

		//statement object
		Statement st = con.createStatement();

		//execute statement query and datatype is result-type
		ResultSet rs = st.executeQuery("select * from student");  //Example one

		//processing of execute statement
		rs.next();
		while (rs.next() != false )
		{
			//System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getDouble(4));
			System.out.println(rs.getString(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4));
		}
		
		//closing of jdbc objects
		rs.close();
		st.close();
		con.close();
	}
}
