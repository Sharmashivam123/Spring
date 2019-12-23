package com.epam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.SeatConfirmationService;
import com.epam.services.UserService;

@Controller
public class SeatConfirmController {
	@Autowired
	private SeatConfirmationService service;
	@Autowired
	UserService user;
	@Autowired
	Credentials credentials;
	@Autowired
	BookingDetails bookingDetails;

	@GetMapping("/confirmation")
	public ModelAndView doGet(@RequestParam String seats) {
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
			Optional<String> seatsOptional = Optional.ofNullable(seats);
			service.setSeatIdAndCostList(seatsOptional);
			model.addObject("user", credentials.getUser());
			model.addObject("phone", credentials.getPhone());
			model.addObject("bookings", bookingDetails);
			model.setViewName("user");
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("index");
		}
		return model;
	}
}
