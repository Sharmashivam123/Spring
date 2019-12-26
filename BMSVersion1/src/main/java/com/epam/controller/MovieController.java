package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.bean.Movie;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.RestClientService;
import com.epam.services.UserService;

@Controller
public class MovieController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService services;
	@Autowired
	UserService user;
	@Autowired
	Credentials credentials;

	@GetMapping("/movie")
	public ModelAndView doGet(HttpSession session, @RequestParam int location) {
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
			List<Movie> listMovie;
			bookingDetails.setPincode(location);
			listMovie = services.getAllMoviesAtLocation(location);
			model.addObject("movies", listMovie);
			model.setViewName("movie");
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("index");
		}

		return model;
	}
}
