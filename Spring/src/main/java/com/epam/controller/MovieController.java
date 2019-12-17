package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.bean.Movie;
import com.epam.services.RestClientService;

@Controller
public class MovieController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService services;

	@Autowired
	Credentials credentials;

	@GetMapping("/movie")
	public ModelAndView doGet(HttpSession session, @RequestParam int location) {
		ModelAndView model = new ModelAndView();
		List<Movie> listMovie;
		bookingDetails.setPincode(location);
		listMovie = services.getAllMoviesAtLocation(location);
		model.addObject("movies", listMovie);

		model.setViewName("movie");
		return model;
	}
}
