package com.epam.bms.main;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class TheatreServlet
 */
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Services services = new Services();
		PrintWriter out = response.getWriter();
		BookingDetails bookingDetails = BookingDetails.getInstance();
		out.println("Select the theatreId.");
		List<Theatre> listTheatre = services.getTheatreListByMovie();
		listTheatre.stream().forEach(theatre->out.println(theatre.getTheatreId()+" "+theatre.getTheatreName()+" "));
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		bookingDetails.setTheatreId(theatreId);
		if (bookingDetails.getTheatreId() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/Date?dateId=1");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Date");
		rd.include(request, response);
	}

}
