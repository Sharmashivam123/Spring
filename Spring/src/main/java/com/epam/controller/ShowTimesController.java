package com.epam.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;

@Controller
@SessionAttributes("credentials")
public class ShowTimesController {

	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	private List<String> availableShows;
	@Autowired
	Credentials credentials;

	@GetMapping("/timings")
	public ModelAndView doGet(HttpSession session, @RequestParam String date) {
		ModelAndView model = new ModelAndView();

		int movieId = bookingDetails.getMovieId();
		int theatreId = bookingDetails.getTheatreId();
		LocalDate selectedDate = LocalDate.parse(date);
		System.out.println(1 + " " + movieId + " " + theatreId + " " + selectedDate);
		bookingDetails.setDate(selectedDate);
		availableShows = service.getAllTimings(movieId, theatreId, selectedDate);
		model.addObject("shows", availableShows);

		model.setViewName("shows");

		return model;
	}
}
