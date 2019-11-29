package com.epam.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.SeatArrangements;
import com.epam.services.SeatsServices;

@Controller
public class SeatRangeController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private SeatsServices rest;
	private List<SeatArrangements> silverSeats, goldSeats, platinumSeats;

	@GetMapping("/seats")
	public ModelAndView doGet(@RequestParam String showTime) {
		bookingDetails.setTime(LocalTime.parse(showTime));
		silverSeats = rest.getSeatRanges("silver");
		goldSeats = rest.getSeatRanges("gold");
		platinumSeats = rest.getSeatRanges("platinum");
		ModelAndView model = new ModelAndView();
		model.addObject("silverSeats", silverSeats);
		model.addObject("goldSeats", goldSeats);
		model.addObject("platinumSeats", platinumSeats);
		model.setViewName("seats");
		return model;
	}

}
