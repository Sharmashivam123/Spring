package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Credentials;
import com.epam.bean.TicketsDetails;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.RestClientService;
import com.epam.services.UserService;

@Controller
public class TicketsDetailController {
	@Autowired
	private TicketsDetails ticketDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	Credentials credentials;
	@Autowired
	UserService user;

	@GetMapping("/tickets")
	public ModelAndView doGet() {
		String username = "";
		ModelAndView model = new ModelAndView();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof MyUserDetails)
			username = ((MyUserDetails) principal).getUsername();
		else {
			username = principal.toString();
		}
		credentials = user.getUserData(username);
		try {
			if (credentials.getStatus() == 0)
				throw new Exception();
			ticketDetails = service.getTicketDetails();
			model.addObject("tickets", ticketDetails);
			model.setViewName("ticket");
		} catch (Exception e) {
			model.addObject("status", credentials.getStatus());
			model.setViewName("index");
		}
		return model;
	}
}
