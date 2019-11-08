package com.epam.bms.controller;

import java.io.IOException;
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Services services = new Services(); 
		BookingDetails bookingDetails = BookingDetails.getInstance();
		String cityId = request.getParameter("city");
		bookingDetails.setCityId(Integer.parseInt(cityId));
		List<Area> listLocation = services.getAreaPinInCity(); 
		request.setAttribute("locations", listLocation);
		RequestDispatcher rd = request.getRequestDispatcher("Location.jsp");
		rd.forward(request, response);

	}


}
