package com.epam.bms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.bean.Theatre;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

@WebServlet("/Theatre")
public class TheatreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TheatreServlet() {
		super();
		// TODO Auto-generated constructor stub
	} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieId = request.getParameter("movie"); 
		BookingDetails bookingDetails = BookingDetails.getInstance();
		bookingDetails.setMovieId(Integer.parseInt(movieId));
		Services services = new Services();
		List<Theatre> theatreList = services.getTheatreListByMovie();
		if (bookingDetails.getPincode() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/Error");
			rd.forward(request, response);  
		}
		request.setAttribute("theatres", theatreList);
		RequestDispatcher rd = request.getRequestDispatcher("Theatre.jsp");
		rd.forward(request, response);
		}

}
