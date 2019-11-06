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

import com.epam.bms.bean.City;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

/**
 * Servlet implementation class ApplicationBooking
 */
@WebServlet("/City")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Services services = new Services();
		PrintWriter out = response.getWriter();
		try {
			out.println("Select your choice of city.");
			List<City> cityList = services.getShowAvailableCities();
			cityList.stream().forEach(city -> out.println(city.getCityId() + " " + city.getCityName()));
			String cityId = request.getParameter("id");
			BookingDetails bookingDetails = BookingDetails.getInstance();
			bookingDetails.setCityId(Integer.parseInt(cityId));
			if (bookingDetails.getCityId() != 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/Location?pin=500081");
				rd.forward(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/Error");
			rd.include(request, response);
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}

}
