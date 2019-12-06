package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/city")
	public ModelAndView doGet(@RequestParam String user, String pwd, HttpSession session) throws Exception {
		ModelAndView model = new ModelAndView();

		session.setAttribute("user", user);
		session.setAttribute("pwd", pwd);

		if (session.getAttribute("user").equals(credentials.getUsername())
				&& session.getAttribute("pwd").equals(credentials.getPassword())) {

			List<City> cityList;
			cityList = rest.getAllCities();
			model.setViewName("city");
			model.addObject("cityList", cityList);
		} else
			model.setViewName("index");
		return model;
	}

}