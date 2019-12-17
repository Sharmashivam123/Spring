package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.bean.Theatre;
import com.epam.services.RestClientService;

@Controller
public class TheatreController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	RestClientService service;

	@Autowired
	Credentials credentials;

	@GetMapping("/theatre")
	public ModelAndView doGet(@RequestParam String movie) {
		ModelAndView model = new ModelAndView();
		String[] movieIdandName;
		List<Theatre> theatreList;
		movieIdandName = movie.split(",");
		int id = Integer.parseInt(movieIdandName[0]);
		bookingDetails.setMovieId(id);
		bookingDetails.setMovieName(movieIdandName[1]);
		theatreList = service.getAllTheatresForMovieSelected(id);
		model.addObject("theatres", theatreList);

		model.setViewName("theatre");

		return model;
	}

}
