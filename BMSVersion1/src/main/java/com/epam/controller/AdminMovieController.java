package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Movie;
import com.epam.services.MovieServices;
import com.epam.services.TheatreServices;

@Controller
public class AdminMovieController {

	@Autowired
	MovieServices services;
	@Autowired
	TheatreServices theatreServices;

	@GetMapping("/admin/movie")
	public ModelAndView getAllMovies() {
		ModelAndView model = new ModelAndView();
		List<Movie> movieList;
		movieList = services.getAllMovies();
		model.addObject("movieList", movieList);
		model.addObject("theatreList", theatreServices.getAllTheatre());
		model.setViewName("adminmovie");
		return model;
	}

	@GetMapping("/admin/movieupdt")
	public ModelAndView updateMovie(@RequestParam(required = false) int movieId, String movieName,
			int[] theatreSelected) {
		services.update(movieId, movieName, theatreSelected);
		ModelAndView model = new ModelAndView();
		List<Movie> movieList;
		movieList = services.getAllMovies();
		model.addObject("movieList", movieList);
		model.addObject("theatreList", theatreServices.getAllTheatre());
		model.setViewName("adminmovie");
		return model;
	}

	@GetMapping("/admin/moviedlt")
	public ModelAndView deleteCity(@RequestParam(required = false) int movieId) {
		services.delete(movieId);
		ModelAndView model = new ModelAndView();
		List<Movie> movieList = services.getAllMovies();
		model.addObject("theatreList", theatreServices.getAllTheatre());
		model.addObject("movieList", movieList);
		model.setViewName("adminmovie");
		return model;
	}

	@GetMapping("/admin/movieadd")
	public ModelAndView addMovie(@RequestParam(required = false) String movieName, int[] theatreSelected) {
		Movie movie = new Movie();
		movie.setMovieName(movieName);
		services.addMovie(movie, theatreSelected);
		List<Movie> movieList;
		movieList = services.getAllMovies();
		ModelAndView model = new ModelAndView();
		model.addObject("theatreList", theatreServices.getAllTheatre());
		model.addObject("movieList", movieList);
		model.setViewName("adminmovie");
		return model;
	}

}
