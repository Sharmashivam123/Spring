package com.epam.bms.services;

import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.Theatre;
import com.epam.bms.bean.Area;
import com.epam.bms.dao.*;

import java.sql.Time;
import java.util.List;
import org.apache.log4j.Logger;

public class PrintServices {
	
	
	private final Logger log = Logger.getLogger(PrintServices.class);
	DbOperation dbOperation = new DbOperationImpl();

	public void printMsg(String message) {
		log.info(message);
	}

	public void showAvailableCities() throws Exception {
		List<City> cityList = dbOperation.getCityList();
		cityList.stream().forEach(city -> printMsg(city.getCityId() + " " + city.getCityName()));
	}

	public void printAreaPinInCity(String cityId) {
		List<Area> listLocation = dbOperation.getAreaListByCity(cityId);
		listLocation.stream().forEach(area -> printMsg(area.getPin() + " " + area.getAreaName()));
	}

	public void printMoviesAtLocation(String pin) {
		List<Movie> listMovie = dbOperation.getMovieListByAreaPin(pin);
		listMovie.stream().forEach(movie -> log.info(movie.getMovieId() + " " + movie.getMovieName()));
	}

	public void printTheatreListByMovie(String movieId) {
		List<Theatre> listTheatre = dbOperation.getTheatreListByMovie(movieId);
		listTheatre.stream().forEach(theatre -> log.info(theatre.getTheatreId() + " " + theatre.getTheatreName()));
	}

	public void printShowTiming(String theatreId, String movieId) {
		List<Theatre> listTheatre = dbOperation.getTheatreListByMovie(movieId);
		for (Theatre theatre : listTheatre) {
			int expectedTheatreId = theatre.getTheatreId();
			int actualTheatreId = Integer.parseInt(theatreId);
			if (expectedTheatreId == actualTheatreId) {
				List<Time> shows = theatre.getShowtimings();
				int showIndex = 0;
				for(Time time : shows)
				{
					log.info(++showIndex + " " + time);
				}
			}
		}
	}

}
