package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.City;
import com.epam.bean.Credentials;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.RestClientService;
import com.epam.services.UserService;

@Controller
public class CityController {
	@Autowired
	private RestClientService rest;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;

	@GetMapping(value = "city")
	public ModelAndView doGet() {
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView();
		if (principal instanceof MyUserDetails)
			username = ((MyUserDetails) principal).getUsername();
		else {
			username = principal.toString();
		}
		credentials = user.getUserData(username);
		try {
			if(credentials.getStatus()==0)throw new Exception();
			List<City> cityList;
			cityList = rest.getAllCities();
			model.setViewName("city");
			model.addObject("cityList", cityList);
		}
		catch(Exception e)
		{
			model.addObject("status",credentials.getStatus());
			model.setViewName("index");
		}
		return model;

	}

}