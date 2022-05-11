package DataBaseBootCamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBC_Query5 {
	
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
		String query = "SELECT * FROM employee.employees limit 5;";
		
		// Execute query
		ResultSet rset = stmnt.executeQuery(query);
		System.out.println("employee_id" +"\t"+ "first_name"+ "\t"+ "last_name"+ "\t"+ 
		"email"+ "\t"+ "phone_number"+ "\t"+  "hire_date"+ "\t"+ "job_id"+ "\t"+ "salary" +
				"\t"+ "manager_id"+"\t"+ "department_id");
		
		//Console output
		while (rset.next()){
		System.out.println(rset.getString("employee_id")+"\t\t"+
				rset.getString("first_name")+"\t\t"+
				rset.getString("last_name")+"\t\t"+
				rset.getString("email")+"\t\t"+
				rset.getString("phone_number")+"\t\t"+
				rset.getString("hire_date")+"\t\t"+
				rset.getString("job_id")+"\t\t"+
				rset.getString("salary")+"\t\t"+
				rset.getString("manager_id")+"\t\t"+
				rset.getString("department_id")+"\t\t"
				
				
				);
		}
	}
		

}
