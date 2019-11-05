package com.epam.bms.main;

import java.io.IOException;
import java.io.PrintWriter;
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
		Services services = new Services();
		PrintWriter out = response.getWriter();
		BookingDetails bookingDetails = BookingDetails.getInstance();
		out.println("select the date");
		Map<Integer, LocalDate> dateMap = services.getAvailableDates();
		for (Map.Entry<Integer, LocalDate> element : dateMap.entrySet())
			out.println(element.getKey() + "  :  " + element.getValue());
		int dateId = Integer.parseInt(request.getParameter("dateId"));
		bookingDetails.setDate(dateMap.get(dateId));
		bookingDetails.setDateId(dateId);
		if (bookingDetails.getDate() == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Timings?showId=1");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Timings");
		rd.include(request, response);
	}

}
