package com.epam.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.City;
import com.epam.services.RestClientService;

@Controller
public class CityController {
	@Autowired
	private RestClientService rest;
	private List<City> cityList;

	@GetMapping("/city")
	public ModelAndView doGet() throws Exception {
		cityList = rest.getAllCities();
		ModelAndView model = new ModelAndView();
		model.setViewName("city");
		model.addObject("cityList", cityList);
		return model;
	}
}