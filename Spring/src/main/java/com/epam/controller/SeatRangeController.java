package com.epam.controller;

import java.time.LocalTime;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.BookingDetails;
import com.epam.bean.Credentials;
import com.epam.bean.SeatArrangements;
import com.epam.services.servicesImpl.SeatsServicesImpl;

@Controller
@SessionAttributes("credentials")
public class SeatRangeController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private SeatsServicesImpl service;
	private Map<SeatArrangements, Boolean> silverSeats, goldSeats, platinumSeats;
	@Autowired
	Credentials credentials;

	@GetMapping("/seats")
	public ModelAndView doGet(HttpSession session, @RequestParam String showTime) throws Exception {
		ModelAndView model = new ModelAndView();

		bookingDetails.setTime(LocalTime.parse(showTime));
		try {

			silverSeats = service.getSeatRanges("silver");
			goldSeats = service.getSeatRanges("gold");
			platinumSeats = service.getSeatRanges("platinum");

		} catch (Exception e) {
			System.out.println("error in this" + e.getMessage());
		}
		model.addObject("silverSeats", silverSeats);
		model.addObject("goldSeats", goldSeats);
		model.addObject("platinumSeats", platinumSeats);

		model.setViewName("seats");

		return model;
	}

}
