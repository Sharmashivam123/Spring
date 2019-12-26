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
import com.epam.services.UserService;

@Controller
public class AdminLocationController {

	@Autowired
	LocationServices service;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;

	@GetMapping("/adminlocation")
	public ModelAndView adminCity() {

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
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("home");
		}

		return model;
	}

	@GetMapping("/adminlocationupdt")
	public ModelAndView cityManipulation(@RequestParam(required = false) int locationId, String locationName,
			int cityId) {
		Location location = new Location();
		location.setLocationId(locationId);
		location.setCityId(cityId);
		location.setLocationName(locationName);
		;
		service.update(location);
		List<Location> locationList;
		locationList = service.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlocation");
		model.addObject("locationList", locationList);
		return model;
	}

	@GetMapping("/adminlocationdlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int locationId) {
		service.delete(locationId);
		List<Location> locationList;
		locationList = service.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlocation");
		model.addObject("locationList", locationList);
		return model;
	}

	@GetMapping("/adminlocationadd")
	public ModelAndView addCity(@RequestParam(required = false) int locationId, String locationName, int cityId) {
		Location location = new Location();
		location.setCityId(cityId);
		location.setLocationName(locationName);
		service.addLocation(location);
		List<Location> locationList;
		locationList = service.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlocation");
		model.addObject("locationList", locationList);
		return model;
	}

}
