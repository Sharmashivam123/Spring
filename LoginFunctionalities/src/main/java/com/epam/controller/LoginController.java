package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "index";
	}

	@GetMapping("/success")
	public String postLogin() {
		return "success";
	}
}
