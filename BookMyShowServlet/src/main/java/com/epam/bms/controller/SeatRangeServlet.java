package com.epam.bms.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.bean.SeatRange;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

@WebServlet("/SeatRange")
public class SeatRangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SeatRangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Services services = new Services();
		BookingDetails bookingDetails = BookingDetails.getInstance();
		int showId = Integer.parseInt(request.getParameter("showTime"));
		bookingDetails.setShowId(showId);
		int dateId = bookingDetails.getDateId();
		Map<Integer, LocalTime> availableShows = services.getShowTiming(dateId);
		bookingDetails.setTime(availableShows.get(showId));
		List<SeatRange> silverSeats = services.getPriceRanges("silver");
		List<SeatRange> goldSeats = services.getPriceRanges("gold");
		List<SeatRange> platinumSeats = services.getPriceRanges("platinum");
		request.setAttribute("silverSeats", silverSeats);
		request.setAttribute("goldSeats", goldSeats);
		request.setAttribute("platinumSeats", platinumSeats);
		RequestDispatcher rd = request.getRequestDispatcher("SeatRange.jsp");
		rd.forward(request, response);
//		
//		String seatIdList[]= request.getParameterValues("seatId");
//		String seatCostList[]=request.getParameterValues("cost");
//		String name = request.getParameter("fullname");
//		String phone = request.getParameter("phone");
//		int tickets = seatIdList.length;
//		String costAndSeatId[] = new String[tickets];
//		for(int ticket=0; ticket<tickets; ticket++)
//			costAndSeatId[ticket]=seatIdList[ticket]+" "+seatCostList[ticket];
//		bookingDetails.setCostAndSeatId(costAndSeatId);		
//		bookingDetails.setSeatCount(tickets);
//		bookingDetails.setUserName(name);
//		bookingDetails.setPhone(phone);
//		if(bookingDetails.getSeatCount()!=0)
//		{
//			RequestDispatcher rd = request.getRequestDispatcher("/ProcessBooking");
//			rd.forward(request, response);
//		}
//		RequestDispatcher rd = request.getRequestDispatcher("/Error?error=processBoking");
//		rd.include(request, response);
	}

}
