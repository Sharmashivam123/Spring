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

	List<City> getCityList() ;

	List<Area> getAreaListByCity(int cityId);

	List<Movie> getMovieListByAreaPin(int pin);

	List<Theatre> getTheatreListByMovie(int movieId);

	List<SeatRange> getPriceRange(String tier);

	Map<Integer, LocalTime> getShowtimings(int dateId);

	double getCost(int rangeId);

	boolean processBooking();

}
