package com.epam.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Credentials;
import com.epam.services.SeatConfirmationService;

@Controller
@SessionAttributes("credentials")
public class SeatConfirmController {
	@Autowired
	private SeatConfirmationService service;
	@Autowired
	Credentials credentials;

	@GetMapping("/confirmation")
	public ModelAndView doGet(HttpSession session, @RequestParam(required = false) String silverSeatAndCost,
			@RequestParam(required = false) String goldSeatAndCost,
			@RequestParam(required = false) String platinumSeatAndCost) {

		Optional<String> silverOptional = Optional.ofNullable(silverSeatAndCost);
		Optional<String> goldOptional = Optional.ofNullable(goldSeatAndCost);
		Optional<String> platinumOptional = Optional.ofNullable(platinumSeatAndCost);
		ModelAndView model = new ModelAndView();
		if (session.getAttribute("user").equals(credentials.getUsername())
				&& session.getAttribute("pwd").equals(credentials.getPassword())) {

			service.setSeatIdAndCostList(silverOptional, goldOptional, platinumOptional);
			model.setViewName("user");
		} else {
			model.setViewName("index");
		}
		return model;
	}
}
