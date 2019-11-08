package com.epam.bms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.bean.Movie;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/Movie")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pin = request.getParameter("location");
		BookingDetails bookingDetails = BookingDetails.getInstance();
		bookingDetails.setPincode(Integer.parseInt(pin));
		Services services = new Services();
		List<Movie> listMovie = services.getMoviesAtLocation();  
		if (bookingDetails.getPincode() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/Error"); 
			rd.forward(request, response);  
		}
		request.setAttribute("movies", listMovie);
		RequestDispatcher rd = request.getRequestDispatcher("Movie.jsp");
		rd.forward(request, response);
	}
}
