package model;

public class Book {
	
	private int bookID;
	private String title;
	private String author;
	private int pages;
	private int rating;
	
	/**
	 * default constructor
	 */
	public Book() {
		this.bookID = 1;
		this.title = "No Title";
		this.author = "No Author";
		this.pages = 0;
		this.rating = 0;
	}
	
	/**
	 * @param bookID
	 * @param title
	 * @param author
	 * @param pages
	 * @param rating
	 */
	public Book(int bookID, String title, String author, int pages, int rating) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.rating = rating;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", author=" + author + ", pages=" + pages + ", rating=" + rating + "]";
	}
	
	

}
