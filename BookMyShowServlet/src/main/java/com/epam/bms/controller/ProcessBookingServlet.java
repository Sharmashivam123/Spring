package com.epam.bms.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

@WebServlet("/ProcessBooking")
public class ProcessBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String silverSeatAndCost[] = request.getParameterValues("A");
		String goldSeatAndCost[] = request.getParameterValues("B");
		String platinumSeatAndCost[] = request.getParameterValues("C");
		int lenSilverSeats = silverSeatAndCost.length;
		int lenGoldSeats = goldSeatAndCost.length;
		int lenPlatinumSeats = platinumSeatAndCost.length;
		int totalSeats = lenGoldSeats + lenPlatinumSeats + lenSilverSeats;
		String seatIdAndCostList[] = new String[totalSeats];
		BookingDetails bookingDetails = BookingDetails.getInstance();
		bookingDetails.setSeatCount(totalSeats);
		int count=0;
		for(int seat=0; seat<lenSilverSeats; seat++)
			seatIdAndCostList[count++] = silverSeatAndCost[seat];
		for(int seat=0; seat<lenGoldSeats; seat++)
			seatIdAndCostList[count++] = goldSeatAndCost[seat];
		for(int seat=0; seat<lenPlatinumSeats; seat++) 
			seatIdAndCostList[count++] = platinumSeatAndCost[seat];
		bookingDetails.setCostAndSeatId(seatIdAndCostList);
		
		RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
		rd.forward(request, response); 
	}
}
