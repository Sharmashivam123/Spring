package com.epam.bms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.epam.bms.dao.DbOperationImpl;
import com.epam.bms.models.City;
import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.models.Theatre;

public class TraverseDataImpl implements TraverseData {

	private DbOperationImpl dboperation = new DbOperationImpl();
	private Map<Location, List<Movie>> movieListByPin;
	private Map<Movie, List<Theatre>> theatreListByMovie;
	private Map<String, Integer> rangeOfSeat;
	private List<City> cityList;
	private Map<City, List<Location>> locationByCity;

	public TraverseDataImpl() {
		setCity();
		setLocationByCity();
		setTheatreListByMovie();
		setRangeOfSeat();
	}

	public void setLocationByCity() {
		locationByCity = new HashMap<>();
		locationByCity = dboperation.addLocationByCity(locationByCity);
		movieListByPin = new HashMap<Location, List<Movie>>();
		movieListByPin = dboperation.addMoviesAtPin(movieListByPin);
	}

	public List<Location> getLocationByCity(int cityId) {
		List<Location> list = new ArrayList<Location>();
		for(Map.Entry<City, List<Location>> elements : locationByCity.entrySet())
		{
			if(elements.getKey().getCityId() == cityId)list = elements.getValue();
		}
		return list;
	}

	public void setTheatreListByMovie() {
		theatreListByMovie = new HashMap<Movie, List<Theatre>>();
		theatreListByMovie = dboperation.addTheatreListByMovie(theatreListByMovie);
	}

	public List<Theatre> getTheatreListByMovie(Movie movie) {
		List<Theatre> theatreList = new ArrayList<>();
		for (Map.Entry<Movie, List<Theatre>> element : theatreListByMovie.entrySet()) {
			System.out.println(element.getKey().getMovieName());
			element.getValue().stream().forEach(theatre->System.out.println(theatre.getTheatreId()+" "+theatre.getTheatreName()));
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

	@Override
	public void setCity() {
		cityList = new ArrayList<>();
		cityList = dboperation.addCity(cityList);
	}

	@Override
	public List<City> getCity() {
		return cityList;
	}

}
