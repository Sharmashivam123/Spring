package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;

@Controller
public class DateController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;

	@Autowired
	Credentials credentials;

	@GetMapping("/date")
	public ModelAndView doGet(@RequestParam int theatre) {
		ModelAndView model = new ModelAndView();
		List<String> dateMap;
		bookingDetails.setTheatreId(theatre);
		dateMap = service.getAllDates();
		model.addObject("dates", dateMap);
		model.setViewName("date");

		return model;
	}
}