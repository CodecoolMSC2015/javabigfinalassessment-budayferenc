package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void checkInSessionDate() {

	}

	private void storeDataInSession() {
	}

	private void createOrderedList() {
	}

	private void createResponse() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("index.html").include(request, response);

		String SearchType = request.getParameter("SearchType");
		String SearchTypeKeywords = request.getParameter("SearchTypeKeywords");

	}
}
