package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		System.out.println("sef");
		return "index";
	}

	@PostMapping("/success")
	public String postLogin() {
		return "index";
	}
}
