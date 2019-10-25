package com.epam.bms.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatTypes;
import com.epam.bms.util.ShowTimes;
import com.epam.bms.bean.Theatre;
import com.epam.bms.dao.*;
import com.epam.bms.util.BookingDetails;

public class PrintServices {

	private final Logger log = Logger.getLogger(PrintServices.class);
	private DbOperation dbOperation = new DbOperationImpl();
	private List<Theatre> listTheatre = new ArrayList<>();
	private BookingDetails bookingDetails = BookingDetails.getInstance();
	
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
		int movieId = bookingDetails.getMovieId();
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
		Map<Integer, LocalTime> availableShows = dbOperation.getShowtimings(dateId);
		for (Map.Entry<Integer, LocalTime> showsElement : availableShows.entrySet()) 
					log.info(showsElement.getKey()+" "+ showsElement.getValue());
		ShowTimes showTimes =ShowTimes.getInstatnce();
		showTimes.setAvailableShow(availableShows);
	}

	public void printPriceRanges() {
		List<SeatTypes> rangeList = dbOperation.getPriceRange();
		rangeList.stream()
				.forEach(range -> log.info(range.getRangeId() + " " + range.getTier() + " " + range.getCost()));
	}

	public void priceCalculation() {
		int seatCount = bookingDetails.getSeatCount();
		int rangeId = bookingDetails.getPriceRangeId();
		double cost = dbOperation.getCost(rangeId);
		PriceCalculation calculation = new PriceCalculation();
		double total = calculation.calculatePrice(cost, seatCount);
		log.info("Total cost for the "+seatCount+" is "+ total);
	}

}