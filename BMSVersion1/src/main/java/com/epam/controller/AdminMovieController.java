package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Movie;
import com.epam.services.MovieServices;

@Controller
public class AdminMovieController {

	@Autowired
	MovieServices services;

	@GetMapping("/adminmovie")
	public ModelAndView getAllMovies() {
		ModelAndView model = new ModelAndView();
		List<Movie> movieList;
		movieList = services.getAllMovies();
		model.addObject("movieList", movieList);
		model.setViewName("adminmovie");
		return model;
	}

	@GetMapping("/adminmovieupdt")
	public ModelAndView updateMovie(@RequestParam(required = false) int movieId, String movieName) {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		services.update(movie);
		ModelAndView model = new ModelAndView();
		List<Movie> movieList;
		movieList = services.getAllMovies();
		model.addObject("movieList", movieList);
		model.setViewName("adminmovie");
		return model;
	}

	@GetMapping("/adminmoviedlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int movieId) {
		services.delete(movieId);
		ModelAndView model = new ModelAndView();
		List<Movie> movieList = services.getAllMovies();
		model.addObject("movieList", movieList);
		model.setViewName("adminmovie");
		return model;
	}

	@GetMapping("/adminmovieadd")
	public ModelAndView addMovie(@RequestParam(required = false) int movieId, String movieName) {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		services.addMovie(movie);
		List<Movie> movieList;
		movieList = services.getAllMovies();
		ModelAndView model = new ModelAndView();
		model.addObject("movieList", movieList);
		model.setViewName("adminmovie");
		return model;
	}

}
