package com.epam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/forgot")
public class ForgotPasswordController {

	@GetMapping
	public String forgotPassword()
	{
		return "forgot-password";
	}
	
	@PostMapping
	public ModelAndView forgotPasswordValidate()
	{
		ModelAndView model = new ModelAndView();
		return model;
	}
}
