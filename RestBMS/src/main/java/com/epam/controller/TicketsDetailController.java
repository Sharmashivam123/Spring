package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.TicketsDetails;
import com.epam.services.TicketServices;

@Controller
public class TicketsDetailController {
	@Autowired
	private TicketsDetails ticketDetails;
	@Autowired
	private TicketServices rest;

	@GetMapping("/tickets")
	public ModelAndView doGet(@RequestParam boolean bookingStatus) {
		ModelAndView model = new ModelAndView();
		if (bookingStatus) {
			ticketDetails = rest.getTicketDetails();
			model.addObject("tickets", ticketDetails);
		} else {
			model.setViewName("index");
		}
		model.setViewName("ticket");
		return model;
	}
}
