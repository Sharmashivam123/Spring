package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Credentials;

@Controller
public class HomeController {
	@Autowired
	Credentials credentials;

	@GetMapping(value = "/home")
	public ModelAndView Get() {
		ModelAndView model = new ModelAndView();

		model.setViewName("index");

		return model;
	}
}
