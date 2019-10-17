package com.epam.bms.dao;

import java.util.List;
import java.util.Map;

import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.models.Theatre;

public interface InitialiseData {
	
	public void createMovieList();
	public Map<Location, List<Movie>> addMoviesAtPin(Map<Location, List<Movie>> map);
	public Map<Movie, List<Theatre>> addTheatreListByMovie(Map<Movie, List<Theatre>> map);
	public List<Movie> getListOfMovies(Map<Location, List<Movie>> map, int pin);
	public Map<String, Integer> addSeatRanges(Map<String, Integer> rangeOfSeat);
	
}
