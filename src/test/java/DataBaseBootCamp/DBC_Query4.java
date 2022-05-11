package DataBaseBootCamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBC_Query4 {
	
	@Test
	public void dbConnections() throws ClassNotFoundException, SQLException {
		
		// Setting class
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\n Driver Succesfully Loaded");
		
		//Set Connection to your DataBase
		//jdbc:mysql://localhost:3306/sql-store?severTimezone=UTC	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?severTimezone=UTC", "root", "root1234");
		System.out.println("\n Succesfully Connected to mysql database");
		System.out.println();
		
		// Create statement / Write a query
		Statement stmnt = con.createStatement();
		String query = "SELECT * FROM employee.departments\r\n"
				+ "limit 5;";
		
		// Execute query
		ResultSet rset = stmnt.executeQuery(query);
		System.out.println("department_id" +"\t"+ "department_name"+ "\t"+ "location_id");
		
		//Console output
		while (rset.next()){
		System.out.println(rset.getString("department_id")+"\t\t"+
				rset.getString("department_name")+"\t\t"+
				rset.getString("location_id")+"\t\t"
				
				
				);
		}
	}
		

}
