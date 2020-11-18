package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import dbHelpers.ReadRecord;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get a book and use the data to fill in a table for updating the record", urlPatterns = { "/update" })
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		// create ReadRecord class
		ReadRecord rr = new ReadRecord("scifi_library", "root", "H72?!29jsoam.", bookID);
		
		// Use ReadRecord to get the book data
		rr.doRead();
		
		Book book = rr.getBook();
		
		// pass Book and control to the updateForm.jsp
		request.setAttribute("book", book);
		
		String url = "/updateForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
