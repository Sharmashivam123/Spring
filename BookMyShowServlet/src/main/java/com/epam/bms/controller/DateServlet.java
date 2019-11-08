 package com.epam.bms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

/**
 * Servlet implementation class DateServlet
 */
@WebServlet("/Date")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theatreId = request.getParameter("theatre");
		BookingDetails bookingDetails = BookingDetails.getInstance();
		bookingDetails.setTheatreId(Integer.parseInt(theatreId));
		Services services = new Services();
		Map<Integer, LocalDate> dateMap = services.getAvailableDates();
		request.setAttribute("dates", dateMap);
		RequestDispatcher rd = request.getRequestDispatcher("Date.jsp");
		rd.forward(request, response);
		

	}

}
