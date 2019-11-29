package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.services.LocationServices;

@Controller
public class LocationController {
	@Autowired
	private BookingDetails bookingDetails ;
	@Autowired
	private LocationServices services;

	@GetMapping(value="/location")
	public ModelAndView doGet(@RequestParam int city) {
		bookingDetails.setCityId(city);
		ModelAndView model = new ModelAndView();
		model.addObject("locations",services.getAreaPinInCity());
		model.setViewName("location");
		return model;
	}

}
