package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Credentials;
import com.epam.bean.TicketsDetails;
import com.epam.services.RestClientService;

@Controller
public class TicketsDetailController {
	@Autowired
	private TicketsDetails ticketDetails;
	@Autowired
	private RestClientService service;
	@Autowired
	Credentials credentials;

	@GetMapping("/tickets")
	public ModelAndView doGet() {
		ModelAndView model = new ModelAndView();
		ticketDetails = service.getTicketDetails();
		model.addObject("tickets", ticketDetails);
		model.setViewName("ticket");
		return model;
	}
}
