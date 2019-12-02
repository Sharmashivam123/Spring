package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.services.RestClientService;

@Controller
public class BookingController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	private TicketsDetailController ticket;

	@PostMapping("/booking")
	public ModelAndView doPost(@RequestParam String userName, String phone) {
		bookingDetails.setUserName(userName);
		bookingDetails.setPhone(phone);
		boolean bookingStatus = service.processBooking().equals("true") ? true : false;
		ModelAndView model = new ModelAndView();
		model.addObject("bookingStatus", bookingStatus);
		return ticket.doGet(bookingStatus);
	}

}
