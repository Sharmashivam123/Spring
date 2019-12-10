package com.epam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;

@Controller
public class LocationController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	Credentials credentials;

	@GetMapping(value = "/location")
	public ModelAndView doGet(HttpSession session, @RequestParam int city) {
		ModelAndView model = new ModelAndView();

		bookingDetails.setCityId(city);
		model.addObject("locations", service.getAreaPincodeByCity(city));

		return model;
	}

}
