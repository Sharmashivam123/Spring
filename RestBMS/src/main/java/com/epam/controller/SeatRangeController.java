package com.epam.controller;

import java.time.LocalTime;
import java.util.List;

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
import com.epam.services.RestClientService;

@Controller
@SessionAttributes("credentials")
public class SeatRangeController {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private RestClientService service;
	private List<SeatArrangements> silverSeats, goldSeats, platinumSeats;
	@Autowired
	Credentials credentials;

	@GetMapping("/seats")
	public ModelAndView doGet(HttpSession session, @RequestParam String showTime) {
		ModelAndView model = new ModelAndView();
		if (session.getAttribute("user").equals(credentials.getUsername())
				&& session.getAttribute("pwd").equals(credentials.getPassword())) {

			bookingDetails.setTime(LocalTime.parse(showTime));
			silverSeats = service.getSeatRanges("silver");
			goldSeats = service.getSeatRanges("gold");
			platinumSeats = service.getSeatRanges("platinum");
			model.addObject("silverSeats", silverSeats);
			model.addObject("goldSeats", goldSeats);
			model.addObject("platinumSeats", platinumSeats);
			model.setViewName("seats");

		} else {
			model.setViewName("index");
		}
		return model;
	}

}
