package com.epam.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.ShowTimings;
import com.epam.services.ShowTimingServices;

@Controller
public class AdminTimingController {

	@Autowired
	ShowTimingServices services;

	@GetMapping("/admintimings")
	public ModelAndView getAllTimings() {

		List<ShowTimings> availableShows;
		availableShows = services.getAllTimings();
		ModelAndView model = new ModelAndView();
		model.addObject("showsList", availableShows);
		model.setViewName("admintimings");
		return model;
	}

	@GetMapping("/admintimingupdt")
	public ModelAndView updateMovie(@RequestParam(required = false) int timingId, String show1, String show2,
			String show3, String show4) {
		ShowTimings timing = new ShowTimings();
		timing.setTimingId(timingId);
		timing.setShow1(LocalTime.parse(show1));
		timing.setShow2(LocalTime.parse(show2));
		timing.setShow3(LocalTime.parse(show3));
		timing.setShow4(LocalTime.parse(show4));
		services.update(timing);
		List<ShowTimings> availableShows;
		availableShows = services.getAllTimings();
		ModelAndView model = new ModelAndView();
		model.addObject("showsList", availableShows);
		model.setViewName("admintimings");
		return model;
	}

	@GetMapping("/admintimingdlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int timingId) {
		services.delete(timingId);
		List<ShowTimings> availableShows;
		availableShows = services.getAllTimings();
		ModelAndView model = new ModelAndView();
		model.addObject("showsList", availableShows);
		model.setViewName("admintimings");
		return model;
	}

	@GetMapping("/admintimingadd")
	public ModelAndView addMovie(@RequestParam(required = false) int timingId, String show1, String show2, String show3,
			String show4) {
		ShowTimings timing = new ShowTimings();
		timing.setTimingId(timingId);
		timing.setShow1(LocalTime.parse(show1));
		timing.setShow2(LocalTime.parse(show2));
		timing.setShow3(LocalTime.parse(show3));
		timing.setShow4(LocalTime.parse(show4));
		services.add(timing);
		List<ShowTimings> availableShows;
		availableShows = services.getAllTimings();
		ModelAndView model = new ModelAndView();
		model.addObject("showsList", availableShows);
		model.setViewName("admintimings");
		return model;
	}
}
