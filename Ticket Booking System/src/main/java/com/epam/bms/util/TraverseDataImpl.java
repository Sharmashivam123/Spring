package com.epam.bms.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.epam.bms.dao.DbOperationImpl;
import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.models.Theatre;


public class TraverseDataImpl implements TraverseData{

	private DbOperationImpl dboperation = new DbOperationImpl(); 
	private Map<Location, List<Movie>> movieListByPin ;
	private Map<Movie, List<Theatre>> theatreListByMovie;
	private Map<String, Integer> rangeOfSeat;

	public TraverseDataImpl(){
		setLocation();
		setTheatreListByMovie();
		setRangeOfSeat();
	}
	
	public void setLocation() {
		movieListByPin = new HashMap<Location, List<Movie>>();
		movieListByPin = dboperation.addMoviesAtPin(movieListByPin);
	}

	public List<Location> getLocation() {
	Set<Location> set = movieListByPin.keySet();
	List<Location> list = new ArrayList<Location>();
	list.addAll(set);
	return list;
	}


	public void setTheatreListByMovie() {
		theatreListByMovie = new HashMap<Movie, List<Theatre>>();
		theatreListByMovie = dboperation.addTheatreListByMovie(theatreListByMovie);
	}

	public List<Theatre> getTheatreListByMovie(Movie movie) {
		List<Theatre> theatreList = null;
		for (Map.Entry<Movie, List<Theatre>> element : theatreListByMovie.entrySet()) {
			if (element.getKey().getMovieName().equals(movie.getMovieName()))
				theatreList = element.getValue();
		}

		return theatreList;
	}

	
	public List<Movie> getMovieListByPin(Integer pin) {
		return dboperation.getListOfMovies(movieListByPin, pin);
	}

	public void setRangeOfSeat() {
		rangeOfSeat = new HashMap<String, Integer>();
		rangeOfSeat = dboperation.addSeatRanges(rangeOfSeat);
	}

	public Map<String, Integer> getRangeOfSeat() {
		
		return rangeOfSeat;
	}
	
}
