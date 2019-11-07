package com.epam.bms.dao;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatRange;
import com.epam.bms.bean.Theatre;

public interface DBOperation {

	List<City> getCityList() throws Exception;

	List<Area> getAreaListByCity(String cityId);

	List<Movie> getMovieListByAreaPin(String pin);

	List<Theatre> getTheatreListByMovie(int movieId);

	List<SeatRange> getPriceRange();

	Map<Integer, LocalTime> getShowtimings(int dateId);

	double getCost(int rangeId);

}
