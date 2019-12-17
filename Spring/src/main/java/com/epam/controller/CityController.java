package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.City;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;

@Controller
public class CityController {
	@Autowired
	private RestClientService rest;
	@Autowired
	Credentials credentials;

	@GetMapping(value = "city")
	public ModelAndView doGet() {
		ModelAndView model = new ModelAndView();
		
			List<City> cityList;
			cityList = rest.getAllCities();
			model.setViewName("city");
			model.addObject("cityList", cityList);
	
		return model;

	}

}