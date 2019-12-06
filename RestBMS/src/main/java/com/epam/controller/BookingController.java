package com.epam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
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

	@PostMapping("/booking")
	public ModelAndView doPost(HttpSession session, @RequestParam String userName, String phone) {
		ModelAndView model = new ModelAndView();
		if (session.getAttribute("user").equals(credentials.getUsername())
				&& session.getAttribute("pwd").equals(credentials.getPassword())) {
			bookingDetails.setUserName(userName);
			bookingDetails.setPhone(phone);
			boolean bookingStatus = service.processBooking().equals("true") ? true : false;

			if (bookingStatus == true)
				model.setViewName("booking");
		} else
			model.setViewName("index");
		return model;

	}

}
