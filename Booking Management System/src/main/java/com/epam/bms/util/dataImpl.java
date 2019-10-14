package com.epam.bms.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.bms.dao.InitializingDataValues;
import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.models.Theatre;


public class dataImpl implements Data{

	private InitializingDataValues data = new InitializingDataValues(); 
	private List<Location> listLocation ;
	private Map<Movie, List<Theatre>> theatreListByMovie;
	private Map<String, Integer> rangeOfSeat;

	public dataImpl(){
		setLocation();
		setTheatreListByMovie();
		setRangeOfSeat();
	}
	
	public void setLocation() {
		listLocation = new ArrayList<Location>();
		listLocation = data.addMoviesAtPin(listLocation);
	}

	public List<Location> getLocation() {
		return listLocation;
	}


	public void setTheatreListByMovie() {
		theatreListByMovie = new HashMap<Movie, List<Theatre>>();
		theatreListByMovie = data.addTheatreListByMovie(theatreListByMovie);
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
		return data.getListOfMovies(listLocation, pin);
	}

	public void setRangeOfSeat() {
		rangeOfSeat = new HashMap<String, Integer>();
		rangeOfSeat = data.addSeatRanges(rangeOfSeat);
	}

	public Map<String, Integer> getRangeOfSeat() {
		
		return rangeOfSeat;
	}
	
}
