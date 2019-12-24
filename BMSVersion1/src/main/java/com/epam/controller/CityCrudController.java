package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.City;
import com.epam.bean.Credentials;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.CityServices;
import com.epam.services.RestClientService;
import com.epam.services.UserService;

@Controller
public class CityCrudController {

	@Autowired
	private RestClientService rest;
	@Autowired
	CityServices service;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;

	@GetMapping("/admincity")
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
			List<City> cityList;
			cityList = rest.getAllCities();
			model.setViewName("admincity");
			model.addObject("cityList", cityList);
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("home");
		}

		return model;
	}

	@GetMapping("/admincityupdt")
	public ModelAndView cityManipulation(@RequestParam(required = false) int cityId, String cityName) {
		City city = new City();
		city.setCityId(cityId);
		city.setCityName(cityName);
		service.update(city);
		List<City> cityList = service.getAvailableCities();
		ModelAndView model = new ModelAndView();
		model.setViewName("admincity");
		model.addObject("cityList", cityList);
		return model;
	}

	@GetMapping("/admincitydlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int cityId) {
		service.delete(cityId);
		List<City> cityList = service.getAvailableCities();
		ModelAndView model = new ModelAndView();
		model.setViewName("admincity");
		model.addObject("cityList", cityList);
		return model;
	}

	@GetMapping("/admincityadd")
	public ModelAndView addCity(@RequestParam(required = false) int cityId, String cityName) {
		City city = new City();
		city.setCityId(cityId);
		city.setCityName(cityName);
		service.addCity(city);
		List<City> cityList = service.getAvailableCities();
		ModelAndView model = new ModelAndView();
		model.setViewName("admincity");
		model.addObject("cityList", cityList);
		return model;
	}

}
