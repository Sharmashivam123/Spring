package com.epam.bms.dao;

import java.util.List;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.Theatre;

public interface DbOperation {

	List<City> getCityList() throws Exception;

	List<Area> getAreaListByCity(String cityId);

	List<Movie> getMovieListByAreaPin(String pin);

	List<Theatre> getTheatreListByMovie(String movieId);
	
}
