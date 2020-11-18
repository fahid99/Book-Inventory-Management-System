/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

/**
 * @author craigpiercy
 *
 */
public class ReadRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Book book = new Book();
	private int bookID;
	
	public ReadRecord(String dbName, String uname, String pwd, int bookID){
		
		String url = "jdbc:mysql://database-1.c3ltvmjszymt.us-east-1.rds.amazonaws.com:3306/" + dbName;
		this.bookID = bookID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doRead(){
		String query = "select * from books where bookID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.bookID);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			book.setBookID(this.results.getInt(1));
			book.setAuthor(this.results.getString("author"));
			book.setTitle(this.results.getString("title"));
			book.setPages(this.results.getInt("pages"));
			book.setRating(this.results.getInt("rating"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Book getBook(){
		return this.book;
	}
	
	

}
