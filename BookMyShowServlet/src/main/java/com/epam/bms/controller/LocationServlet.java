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

import com.epam.bms.bean.Area;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/Location")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServlet() {
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
		String pin = request.getParameter("pin");
		out.println("Select your areacode in city ");
		List<Area> listLocation = services.getAreaPinInCity();
		listLocation.stream().forEach(p->out.println(p.getPin()+" "+p.getAreaName()));
		bookingDetails.setPincode(Integer.parseInt(pin));
		if (bookingDetails.getCityId() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/Movie?movieId=1");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Error");
		rd.include(request, response);
	}


}
