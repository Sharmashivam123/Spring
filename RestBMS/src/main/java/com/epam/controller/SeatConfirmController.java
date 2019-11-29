package com.epam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.services.SeatConfirmationService;

@Controller
public class SeatConfirmController {
	@Autowired
	private SeatConfirmationService service;

	@GetMapping("/confirmation")
	public ModelAndView doGet(@RequestParam(required = false) String silverSeatAndCost,
			@RequestParam(required = false) String goldSeatAndCost,
			@RequestParam(required = false) String platinumSeatAndCost) {

		Optional<String> silverOptional = Optional.ofNullable(silverSeatAndCost);
		Optional<String> goldOptional = Optional.ofNullable(goldSeatAndCost);
		Optional<String> platinumOptional = Optional.ofNullable(platinumSeatAndCost);

		service.setSeatIdAndCostList(silverOptional, goldOptional, platinumOptional);

		ModelAndView model = new ModelAndView();
		model.setViewName("user");
		return model;
	}
}
