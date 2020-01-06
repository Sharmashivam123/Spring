package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.SeatArrangements;
import com.epam.services.SeatsServices;

@Controller
public class AdminScreenController {
	@Autowired
	private SeatsServices service;

	@GetMapping("/adminscreen")
	public ModelAndView getScreenDetails() {
		ModelAndView model = new ModelAndView();
		model.addObject("seats", service.getSeatData());
		model.setViewName("adminscreen");
		return model;
	}

	@GetMapping("/adminupdtscreen")
	public ModelAndView updateScreenDetails(@RequestParam(required = false) String seatId, String tier, double cost) {
		SeatArrangements seatarrangements = new SeatArrangements();
		seatarrangements.setSeatId(seatId);
		seatarrangements.setTier(tier);
		seatarrangements.setCost(cost);
		service.update(seatarrangements);
		ModelAndView model = new ModelAndView();
		model.addObject("seats", service.getSeatData());
		model.setViewName("adminscreen");
		return model;
	}

	@GetMapping("/admindltscreen")
	public ModelAndView deleteScreenDetails(@RequestParam(required = false) String seatId) {
		service.delete(seatId);
		ModelAndView model = new ModelAndView();
		model.addObject("seats", service.getSeatData());
		model.setViewName("adminscreen");
		return model;
	}

	@GetMapping("/adminaddscreen")
	public ModelAndView addScreenDetails(@RequestParam(required = false) String seatId, String tier, double cost) {
		SeatArrangements seatarrangements = new SeatArrangements();
		seatarrangements.setSeatId(seatId);
		seatarrangements.setTier(tier);
		seatarrangements.setCost(cost);
		service.insert(seatarrangements);
		ModelAndView model = new ModelAndView();
		model.addObject("seats", service.getSeatData());
		model.setViewName("adminscreen");
		return model;
	}

}
