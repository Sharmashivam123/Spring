package com.epam.services;

import java.util.List;

import com.epam.bean.City;
import com.epam.bean.Location;
import com.epam.bean.Movie;
import com.epam.bean.SeatArrangements;
import com.epam.bean.Theatre;
import com.epam.bean.TicketsDetails;

public interface RestClientService {
	public List<City> getAllCities();

	public List<Location> getAreaPincodeByCity();

	public List<Movie> getAllMoviesAtLocation();

	public List<Theatre> getAllTheatresForMovieSelected();

	public List<String> getAllDates();

	public List<String> getAllTimings();

	public List<SeatArrangements> getSeatRanges(String tier);

	public String processBooking();

	public TicketsDetails getTicketDetails();
}
