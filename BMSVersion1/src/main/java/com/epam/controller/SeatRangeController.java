package com.epam.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.UserService;
import com.epam.services.impl.SeatsServicesImpl;

@Controller
public class SeatRangeController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private SeatsServicesImpl service;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;

	@GetMapping("/seats")
	public ModelAndView doGet(@RequestParam String showTime) {
		String username = "";
		ModelAndView model = new ModelAndView();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof MyUserDetails)
			username = ((MyUserDetails) principal).getUsername();
		else {
			username = principal.toString();
		}
		credentials = user.getUserData(username);
		try {
			if (credentials.getStatus() == 0)
				throw new Exception();
			bookingDetails.setTime(LocalTime.parse(showTime));
			model.addObject("silverSeats", service.getSeatRanges("silver"));
			model.addObject("goldSeats", service.getSeatRanges("gold"));
			model.addObject("platinumSeats", service.getSeatRanges("platinum"));
			model.setViewName("seats");
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("index");
		}

		return model;
	}

}
