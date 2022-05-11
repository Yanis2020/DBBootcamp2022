package DataBaseBootCamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBC_Customer_Table {
	
	@Test
	public void dbConnections() throws ClassNotFoundException, SQLException {
		
		// Setting class
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\n Driver Succesfully Loaded");
		
		//Set Connection to your DataBase
		//jdbc:mysql://localhost:3306/sql-store?severTimezone=UTC	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?severTimezone=UTC", "root", "root1234");
		System.out.println("\n Succesfully Connected to mysql database");
		
		// Create statement / Write a query
		Statement stmnt = con.createStatement();
		String query = "SELECT * FROM classicmodels.customers;";
		
		// Execute query
		ResultSet rset = stmnt.executeQuery(query);
		System.out.println("customerNumber" +"\t"+ "customerName"+ "\t"+ "contactLastName"+ "\t"+ 
		"contactFirstName"+ "\t"+ "phone"+ "\t"+  "addressLine1"+ "\t"+ "addressLine2"+ "\t"+ "city" +
				"\t"+ "state"+"\t"+ "postalCode"+"\t"+ "country"+"\t"+ "salesRepEmployeeNumber"+ "\t"+ 
		"creditLimit");
		
		//Console output
		while (rset.next()){
		System.out.println(rset.getString("customerNumber")+"\t\t"+
				rset.getString("customerName")+"\t\t"+
				rset.getString("contactLastName")+"\t\t"+
				rset.getString("contactFirstName")+"\t\t"+
				rset.getString("phone")+"\t\t"+
				rset.getString("addressLine1")+"\t\t"+
				rset.getString("addressLine2")+"\t\t"+
				rset.getString("city")+"\t\t"+
				rset.getString("state")+"\t\t"+
				rset.getString("postalCode")+"\t\t"+
				rset.getString("country")+"\t\t"+
				rset.getString("salesRepEmployeeNumber")+"\t\t"+
				rset.getString("creditLimit")+"\t\t"
				
				);
		}
	}
		

}
