package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Credentials;
import com.epam.bean.Location;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.LocationServices;
import com.epam.services.MovieServices;
import com.epam.services.UserService;

@Controller
public class AdminLocationController {

	@Autowired
	LocationServices service;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;
	@Autowired
	MovieServices movieServices;

	@GetMapping("/admin/location")
	public ModelAndView adminLocation() {

		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView();
		if (principal instanceof MyUserDetails)
			username = ((MyUserDetails) principal).getUsername();
		else {
			username = principal.toString();
		}
		credentials = user.getUserData(username);
		try {
			if (credentials.getStatus() == 0)
				throw new Exception();
			List<Location> locationList;
			locationList = service.getAll();
			model.setViewName("adminlocation");
			model.addObject("locationList", locationList);
			model.addObject("movieList", movieServices.getAllMovies());
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("home");
		}

		return model;
	}

	@GetMapping("/admin/locationupdt")
	public ModelAndView locationManipulation(@RequestParam(required = false) int locationId, String locationName,
			int[] movies) {
		service.update(locationId, locationName, movies);
		List<Location> locationList;
		locationList = service.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlocation");
		model.addObject("movieList", movieServices.getAllMovies());
		model.addObject("locationList", locationList);
		return model;
	}

	@GetMapping("/admin/locationdlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int locationId) {
		service.delete(locationId);
		List<Location> locationList;
		locationList = service.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlocation");
		model.addObject("movieList", movieServices.getAllMovies());
		model.addObject("locationList", locationList);
		return model;
	}

	@GetMapping("/admin/locationadd")
	public ModelAndView addCity(@RequestParam(required = false) String locationName, int[] movies) {
		Location location = new Location();
		location.setLocationName(locationName);
		service.addLocation(location, movies);
		List<Location> locationList;
		locationList = service.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlocation");
		model.addObject("movieList", movieServices.getAllMovies());
		model.addObject("locationList", locationList);
		return model;
	}

}
