package com.epam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.services.RestClientService;

@Controller
public class ShowTimesController {

	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	private List<String> availableShows;

	@GetMapping("/timings")
	public ModelAndView doGet(@RequestParam String date) {
		bookingDetails.setDate(LocalDate.parse(date));
		availableShows = service.getAllTimings();
		ModelAndView model = new ModelAndView();
		model.addObject("shows", availableShows);
		model.setViewName("shows");
		return model;
	}
}
