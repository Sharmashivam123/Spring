package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Bookings;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;

@Controller
public class BookingController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	Credentials credentials;
	@Autowired
	Bookings bookings;

	@GetMapping(value = "/booking")
	public ModelAndView doPost(@RequestParam String userName, String phone) {
		ModelAndView model = new ModelAndView();

		bookingDetails.setUserName(userName);
		bookingDetails.setPhone(phone);
		bookings.setMovieId(bookingDetails.getMovieId());
		bookings.setTheatreId(bookingDetails.getTheatreId());
		bookings.setShowtiming(bookingDetails.getTime());
		bookings.setShowdate(bookingDetails.getDate());
		bookings.setTicketBooked(bookingDetails.getSeatCount());
		String seatIds = "";
		int ticketBooked = bookingDetails.getSeatCount();
		String seatIdAndCost[] = bookingDetails.getCostAndSeatId();
		for (int seat = 0; seat < ticketBooked; seat++) {
			String seatIdAndCostArray[] = seatIdAndCost[seat].split(" ");
			String seatId = seatIdAndCostArray[0] + " ";
			seatIds += seatId;
		}
		bookings.setSeatId(seatIds);

		boolean bookingStatus = service.processBooking(bookings).equals("true") ? true : false;

		if (bookingStatus == true) {
			model.setViewName("booking");
		}

		return model;

	}

}
