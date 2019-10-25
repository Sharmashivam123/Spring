package com.epam.bms.dao;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.Theatre;
import com.epam.bms.util.Timings;
import com.epam.bms.bean.SeatTypes;

public interface DbOperation {

	List<City> getCityList() throws Exception;

	List<Area> getAreaListByCity(String cityId);

	List<Movie> getMovieListByAreaPin(String pin);

	List<Theatre> getTheatreListByMovie(int movieId);

	List<SeatTypes> getPriceRange();

	Map<Integer, LocalTime> getShowtimings(int movieId, int theatreId);

}
