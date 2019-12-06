package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.services.RestClientService;

@Controller
public class DateController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	private List<String> dateMap;
	@Autowired
	Credentials credentials;

	@GetMapping("/date")
	public ModelAndView doGet(HttpSession session, @RequestParam int theatre) {
		ModelAndView model = new ModelAndView();
		if (session.getAttribute("user").equals(credentials.getUsername())
				&& session.getAttribute("pwd").equals(credentials.getPassword())) {
			bookingDetails.setTheatreId(theatre);
			dateMap = service.getAllDates();
			model.addObject("dates", dateMap);
			model.setViewName("date");
		} else {
			model.setViewName("index");
		}
		return model;
	}
}