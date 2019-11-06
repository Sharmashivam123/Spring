package com.epam.bms.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatRange;
import com.epam.bms.bean.Theatre;
import com.epam.bms.dao.*;
import com.epam.bms.util.BookingDetails;

public class Services {
	private DBOperation dBOperation = new DBOperationImpl();
	private BookingDetails bookingDetails = BookingDetails.getInstance();
	
	public List<City> getShowAvailableCities() throws Exception {
		List<City> cityList = dBOperation.getCityList();
		return cityList;
	}

	public List<Area> getAreaPinInCity() {
		int cityId = bookingDetails.getCityId();
		System.out.println(cityId);
		List<Area> listLocation = dBOperation.getAreaListByCity(cityId);
		return listLocation;
	}

	public List<Movie> getMoviesAtLocation() {
		int pin = bookingDetails.getPincode();
		System.out.println(pin);
		List<Movie> listMovie = dBOperation.getMovieListByAreaPin(pin);
		return listMovie;
	}

	public List<Theatre> getTheatreListByMovie() {
		int movieId = bookingDetails.getMovieId();
		System.out.println(movieId);
		List<Theatre> listTheatre = dBOperation.getTheatreListByMovie(movieId);
		return listTheatre;
	}

	public Map<Integer, LocalDate> getAvailableDates() {
		BookingDates dates = new BookingDates();
		Map<Integer, LocalDate> dateMap = dates.getDates();
		return dateMap;
	}

	public Map<Integer, LocalTime> getShowTiming(int dateId) {
		Map<Integer, LocalTime> availableShows = dBOperation.getShowtimings(dateId);
		return availableShows;
	}

	public List<SeatRange> getPriceRanges(String tier) {
		List<SeatRange> rangeList = dBOperation.getPriceRange(tier);
		return rangeList;
	}

	

	

}
