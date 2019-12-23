package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	@GetMapping("/error")
	public ModelAndView errorPage() {
		ModelAndView mode = new ModelAndView();
		mode.setViewName("index");
		return mode;
	}
}
