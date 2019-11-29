package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Movie;
import com.epam.services.MovieServices;

@Controller
public class MovieController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private MovieServices services;
	private List<Movie> listMovie;

	@GetMapping("/movie")
	public ModelAndView doGet(@RequestParam int location) {
		bookingDetails.setPincode(location);
		listMovie = services.getMoviesAtLocation();
		ModelAndView model = new ModelAndView();
		model.addObject("movies", listMovie);
		model.setViewName("movie");
		return model;
	}
}
