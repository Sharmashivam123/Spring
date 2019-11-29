package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Theatre;
import com.epam.services.TheatreServices;

@Controller
public class TheatreController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private TheatreServices services;
	private String[] movieIdandName;
	private List<Theatre> theatreList;

	@GetMapping("/theatre")
	public ModelAndView doGet(@RequestParam String movie) {
		movieIdandName = movie.split(",");
		bookingDetails.setMovieId(Integer.parseInt(movieIdandName[0]));
		bookingDetails.setMovieName(movieIdandName[1]);
		theatreList = services.getTheatreListByMovie();
		ModelAndView model = new ModelAndView();
		model.addObject("theatres", theatreList);
		model.setViewName("theatre");
		return model;
	}

}
