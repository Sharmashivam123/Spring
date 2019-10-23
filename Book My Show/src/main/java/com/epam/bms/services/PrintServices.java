package com.epam.bms.services;

import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatTypes;
import com.epam.bms.bean.Theatre;
import com.epam.bms.bean.Area;
import com.epam.bms.dao.*;
import com.epam.bms.util.BookingDetails;
import com.epam.bms.util.Timings;

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
	private DbOperation dbOperation = new DbOperationImpl();
	private List<Theatre> listTheatre = new ArrayList<>();
	private Map<Integer, Time> availableShowTime = new HashMap<>();
	private BookingDetails bookingDetails = BookingDetails.getInstance();
	private int movieId = bookingDetails.getMovieId();
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

	public void printTheatreListByMovie() {
		listTheatre = dbOperation.getTheatreListByMovie(movieId);
		listTheatre.stream().forEach(theatre -> log.info(theatre.getTheatreId() + " " + theatre.getTheatreName()));
	}
	
	public void printAvailableDates() {
		BookingDates dates = new BookingDates();
		Map<Integer, LocalDate> dateMap = dates.getDates();
		for (Map.Entry<Integer, LocalDate> element : dateMap.entrySet())
			log.info(element.getKey() + "  :  " + element.getValue());
	}

	public void printShowTiming(int dateId) {
		int theatreId = bookingDetails.getTheatreId();
		List<Timings> shows = dbOperation.getShowtimings(movieId, theatreId);
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


	public void printPriceRanges() {
		List<SeatTypes> rangeList = dbOperation.getPriceRange();
		rangeList.stream().forEach(range -> log.info(range.getRangeId()+" "+range.getTier()+" "+range.getCost()));
	}

}
