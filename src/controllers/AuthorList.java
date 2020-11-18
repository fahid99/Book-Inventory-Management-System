package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ListSameAuthorQuery;

/**
 * Servlet implementation class AuthorList
 */
@WebServlet("/AuthorList")
public class AuthorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorList() {
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
		// Create a ListSameAuthorQuery helper object
		ListSameAuthorQuery lsaq = new ListSameAuthorQuery("scifi_library", "root", "H72?!29jsoam.");
		
		// Get the html from the ListSameAuthorQuery object
		lsaq.doBooksFromSameAuthor();
		String table = lsaq.getHTMLTable();
		
		// pass execution to authorsList.jsp along with the table
		request.setAttribute("table", table);
		String url = "/authorsList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
