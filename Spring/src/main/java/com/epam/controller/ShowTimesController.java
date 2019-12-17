package com.epam.controller;

import java.time.LocalDate;
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
public class ShowTimesController {

	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	Credentials credentials;

	@GetMapping("/timings")
	public ModelAndView doGet(@RequestParam String date) {
		ModelAndView model = new ModelAndView();
		List<String> availableShows;

		int movieId = bookingDetails.getMovieId();
		int theatreId = bookingDetails.getTheatreId();
		LocalDate selectedDate = LocalDate.parse(date);
		bookingDetails.setDate(selectedDate);
		availableShows = service.getAllTimings(movieId, theatreId, selectedDate);
		model.addObject("shows", availableShows);

		model.setViewName("shows");
		return model;
	}
}
