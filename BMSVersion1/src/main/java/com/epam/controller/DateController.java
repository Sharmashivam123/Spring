package com.epam.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;
import com.epam.services.UserService;

@Controller
public class DateController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	UserService user;
	@Autowired
	Credentials credentials;

	@GetMapping("/date")
	public ModelAndView doGet(@RequestParam int theatre, Principal principal) {
		ModelAndView model = new ModelAndView();
		credentials = user.getUserData(principal.getName());
		try {
			if (credentials.getStatus() == 0)
				throw new Exception();
			List<String> dateMap;
			bookingDetails.setTheatreId(theatre);
			dateMap = service.getAllDates();
			model.addObject("dates", dateMap);
			model.setViewName("date");
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("index");
		}
		return model;
	}
}