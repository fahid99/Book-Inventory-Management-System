package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
	
	private Connection connection;
	
	public DeleteQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://database-1.c3ltvmjszymt.us-east-1.rds.amazonaws.com:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doDelete(int bookID) {
		// set up a String to hold our query
		String query = "delete from books where bookID = ?";
		
		//create a prepared statement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
		
		// fill in the prepared statement
		ps.setInt(1, bookID);
		
		// execute the query
		ps.executeUpdate();
		
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
