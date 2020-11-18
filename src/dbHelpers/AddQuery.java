/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Book;

public class AddQuery {
	
	public Connection connection;
	
	public AddQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://database-1.c3ltvmjszymt.us-east-1.rds.amazonaws.com:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(Book book){
		String query = "insert into books (title, author, pages, rating) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPages());
			ps.setInt(4, book.getRating());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

