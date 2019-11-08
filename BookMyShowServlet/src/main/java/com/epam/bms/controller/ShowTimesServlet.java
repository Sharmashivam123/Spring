package com.epam.bms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.dao.BookingDates;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
		BookingDetails bookingDetails = BookingDetails.getInstance();
		int dateId = Integer.parseInt(date);
		bookingDetails.setDateId(dateId); 
		BookingDates bookingDates = new BookingDates();
		Map<Integer, LocalDate> dates = bookingDates.getDates();
		LocalDate selectedDate = dates.get(dateId);
		bookingDetails.setDate(selectedDate);
		Services services = new Services();
		Map<Integer, LocalTime> availableShows = services.getShowTiming(dateId);
		request.setAttribute("shows", availableShows);
		RequestDispatcher rd = request.getRequestDispatcher("Shows.jsp");
		rd.forward(request, response);

	}	
}
