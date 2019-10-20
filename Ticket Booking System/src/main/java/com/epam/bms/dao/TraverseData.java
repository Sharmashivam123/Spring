package com.epam.bms.dao;

import java.util.List;
import java.util.Map;

import com.epam.bms.models.City;
import com.epam.bms.models.Location;
import com.epam.bms.models.Theatre;
import com.epam.bms.models.Movie;

public interface TraverseData {

	public void setCity();

	public List<City> getCity();

	public void setLocationByCity();

	public List<Location> getLocationByCity(int cityId);

	public void setRangeOfSeat();

	public Map<String, Integer> getRangeOfSeat();

	public void setTheatreListByMovie();

	public List<Theatre> getTheatreListByMovie(Movie movie);

	public List<Movie> getMovieListByPin(Integer pin);
	
}
