package com.epam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.RestClientService;
import com.epam.services.UserService;

@Controller
public class ShowTimesController {

	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;

	@GetMapping("/timings")
	public ModelAndView doGet(@RequestParam String date) {
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
			List<String> availableShows;
			int movieId = bookingDetails.getMovieId();
			int theatreId = bookingDetails.getTheatreId();
			LocalDate selectedDate = LocalDate.parse(date);
			bookingDetails.setDate(selectedDate);
			availableShows = service.getAllTimings(movieId, theatreId, selectedDate);
			model.addObject("shows", availableShows);
			model.setViewName("shows");
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("index");
		}

		return model;
	}
}
