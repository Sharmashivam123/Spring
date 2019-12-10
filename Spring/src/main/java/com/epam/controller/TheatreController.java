package com.epam.controller;

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
import com.epam.bean.Theatre;
import com.epam.services.RestClientService;

@Controller
@SessionAttributes("credentials")
public class TheatreController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	private String[] movieIdandName;
	private List<Theatre> theatreList;
	@Autowired
	Credentials credentials;

	@GetMapping("/theatre")
	public ModelAndView doGet(HttpSession session, @RequestParam String movie) {
		ModelAndView model = new ModelAndView();

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
