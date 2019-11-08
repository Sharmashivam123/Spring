package com.epam.bms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;
import com.epam.bms.util.TicketsDetails;


@WebServlet("/PriceCalculation")
public class PriceCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PriceCalculationServlet() {
        super();
        
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("userName");
	String phone = request.getParameter("phone");
	BookingDetails bookingDetails = BookingDetails.getInstance();
	bookingDetails.setUserName(name);
	bookingDetails.setPhone(phone);
	 
	Services services = new Services();
	double totalCost = services.getTotalCost();
	response.getWriter().println(totalCost);
	boolean bookingStatus = services.processBooking();
	if(bookingStatus)
	{
		TicketsDetails ticketDetails = services.getTicketDetails(); 
		request.setAttribute("tickets", ticketDetails);
	}
	else
	{
		RequestDispatcher rd = request.getRequestDispatcher("/Error?error=Bookingfailedduetowrongseatinput");
		rd.forward(request, response);
	}
	RequestDispatcher rd = request.getRequestDispatcher("Ticket.jsp");
	rd.forward(request, response);
	}


}
