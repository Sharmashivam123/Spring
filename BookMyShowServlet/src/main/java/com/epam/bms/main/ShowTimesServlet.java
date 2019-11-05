package com.epam.bms.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

/**
 * Servlet implementation class ShowTimesServlet
 */
@WebServlet("/Timings")
public class ShowTimesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTimesServlet() {
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
		out.println("Select show timing.");
		int dateId = bookingDetails.getDateId();
		Map<Integer, LocalTime> availableShows = services.getShowTiming(dateId);
		for (Map.Entry<Integer, LocalTime> element : availableShows.entrySet())
			out.println(element.getKey() + "  :  " + element.getValue());
	}

	
}
