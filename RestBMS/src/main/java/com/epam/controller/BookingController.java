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
	
	@PostMapping("/booking")
	public ModelAndView doPost(@RequestParam String userName, String phone) {
		bookingDetails.setUserName(userName);
		bookingDetails.setPhone(phone);
		boolean bookingStatus = service.processBooking().equals("true") ? true : false;
		ModelAndView model = new ModelAndView();
		if(bookingStatus == true)
		model.setViewName("booking");
		else
			model.setViewName("index");
		return model;
	}

}
