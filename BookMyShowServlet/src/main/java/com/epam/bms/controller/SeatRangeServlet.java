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
		PrintWriter out = response.getWriter();
		BookingDetails bookingDetails = BookingDetails.getInstance();
		out.println("select the priceRange" + "<br>");
		List<SeatRange> silverSeats = services.getPriceRanges("silver");
		List<SeatRange> goldSeats = services.getPriceRanges("gold");
		List<SeatRange> platinumSeats = services.getPriceRanges("platinum");
		silverSeats.stream().forEach(seat -> out.println(seat.getSeatId() + " " + seat.getCost() + " "));
		out.println("<br>");
		goldSeats.stream().forEach(seat -> out.println(seat.getSeatId() + " " + seat.getCost() + " "));
		out.println("<br>");
		platinumSeats.stream().forEach(seat -> out.println(seat.getSeatId() + " " + seat.getCost() + " "));
		out.println("<br>");
		String seatIdList[]= request.getParameterValues("seatId");
		String seatCostList[]=request.getParameterValues("cost");
		int tickets = seatIdList.length;
		String costAndSeatId[] = new String[tickets];
		for(int ticket=0; ticket<tickets; ticket++)
			costAndSeatId[ticket]=seatIdList[ticket]+" "+seatCostList[ticket];
		bookingDetails.setCostAndSeatId(costAndSeatId);		
		bookingDetails.setSeatCount(tickets);
		if(bookingDetails.getSeatCount()!=0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/PriceCalculation?");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Error");
		rd.include(request, response);
	}

}
