package com.epam.bms.services;

import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatTypes;
import com.epam.bms.bean.ShowTimes;
import com.epam.bms.bean.Theatre;
import com.epam.bms.bean.Area;
import com.epam.bms.dao.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class PrintServices {

	private final Logger log = Logger.getLogger(PrintServices.class);
	DbOperation dbOperation = new DbOperationImpl();
	private List<Theatre> listTheatre = new ArrayList<>();
	Map<Integer, Time> availableShowTime = new HashMap<>();

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
		listTheatre = dbOperation.getTheatreListByMovie(movieId);
		listTheatre.stream().forEach(theatre -> log.info(theatre.getTheatreId() + " " + theatre.getTheatreName()));
	}

	public void printShowTiming(String theatreId, int dateId) {
		for (Theatre theatre : listTheatre) {
			BookingDates dates = new BookingDates();
			LocalDate currentDate = LocalDate.now();
			Map<Integer, LocalDate> map = dates.getDates();
			LocalDate selectedDate = map.get(dateId);
			
			int expectedTheatreId = theatre.getTheatreId();
			int actualTheatreId = Integer.parseInt(theatreId);
			if (expectedTheatreId == actualTheatreId) {
				List<Time> shows = theatre.getShowtimings();
				int showIndex = 0;
				for (Time time : shows) {
					if (currentDate.compareTo(selectedDate) == 0)
						if (LocalTime.parse(time.toString()).compareTo(LocalTime.now().plusMinutes(15)) > 0) {
							log.info(++showIndex + " " + time);
							
						}else
							;
					else {
						log.info(++showIndex + " " + time);
					}
				}
			}
		}
		
	}

	public void printAvailableDates() {
		BookingDates dates = new BookingDates();
		Map<Integer, LocalDate> dateMap = dates.getDates();
		for (Map.Entry<Integer, LocalDate> element : dateMap.entrySet())
			log.info(element.getKey() + "  :  " + element.getValue());
	}

	public void printPriceRanges() {
		List<SeatTypes> rangeList = dbOperation.getPriceRange();
		rangeList.stream().forEach(range -> log.info(range.getRangeId()+" "+range.getTier()+" "+range.getCost()));
	}

}
