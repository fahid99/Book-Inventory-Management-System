package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateBook" })
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the form data and set up a Book object
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int pages = Integer.parseInt(request.getParameter("pages"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		Book book = new Book();
		book.setBookID(bookID);
		book.setAuthor(author);
		book.setTitle(title);
		book.setPages(pages);
		book.setRating(rating);
		
		// create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("scifi_library", "root", "H72?!29jsoam.");
		uq.doUpdate(book);
		
		// pass control on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
