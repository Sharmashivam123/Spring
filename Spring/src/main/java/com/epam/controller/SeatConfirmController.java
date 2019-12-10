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
	public ModelAndView doGet(HttpSession session, @RequestParam String seats) {

		Optional<String> seatsOptional = Optional.ofNullable(seats);

		ModelAndView model = new ModelAndView();

		service.setSeatIdAndCostList(seatsOptional);

		model.setViewName("user");

		return model;
	}
}
