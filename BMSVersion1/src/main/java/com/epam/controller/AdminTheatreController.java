package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Theatre;
import com.epam.services.TheatreServices;

@Controller
public class AdminTheatreController {
	@Autowired
	TheatreServices services;

	@GetMapping("/admintheatre")
	public ModelAndView getAllMovies() {
		ModelAndView model = new ModelAndView();
		List<Theatre> theatreList;
		theatreList = services.getAllTheatre();
		model.addObject("theatreList", theatreList);
		model.setViewName("admintheatre");
		return model;
	}

	@GetMapping("/admintheatreupdt")
	public ModelAndView updateMovie(@RequestParam(required = false) int theatreId, String theatreName) {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(theatreId);
		theatre.setName(theatreName);
		services.update(theatre);
		ModelAndView model = new ModelAndView();
		List<Theatre> theatreList;
		theatreList = services.getAllTheatre();
		model.addObject("theatreList", theatreList);
		model.setViewName("admintheatre");
		return model;
	}

	@GetMapping("/admintheatredlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int theatreId) {
		services.delete(theatreId);
		ModelAndView model = new ModelAndView();
		List<Theatre> theatreList;
		theatreList = services.getAllTheatre();
		model.addObject("theatreList", theatreList);
		model.setViewName("admintheatre");
		return model;
	}

	@GetMapping("/admintheatreadd")
	public ModelAndView addMovie(@RequestParam(required = false) int theatreId, String theatreName) {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(theatreId);
		theatre.setName(theatreName);
		services.add(theatre);
		ModelAndView model = new ModelAndView();
		List<Theatre> theatreList;
		theatreList = services.getAllTheatre();
		model.addObject("theatreList", theatreList);
		model.setViewName("admintheatre");
		return model;
	}
}
