package com.epam.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.epam.bean.Bookings;
import com.epam.bean.City;
import com.epam.bean.Credentials;
import com.epam.bean.Location;
import com.epam.bean.Movie;
import com.epam.bean.SeatArrangements;
import com.epam.bean.Theatre;
import com.epam.bean.TicketsDetails;

public interface RestClientService {
	public List<City> getAllCities();

	public List<Location> getAreaPincodeByCity(int city);

	public List<Movie> getAllMoviesAtLocation(int location);

	public List<Theatre> getAllTheatresForMovieSelected(int id);

	public List<String> getAllDates();

	public List<String> getAllTimings(int movieId, int theatreId, LocalDate selectedDate);

	public Map<SeatArrangements, Boolean> getSeatRanges(String tier);

	public String processBooking(Bookings bookings);

	public TicketsDetails getTicketDetails();

	public Credentials getUserData(String user);

	public Credentials update(Credentials credentials);

	public Credentials registerUser(Credentials credential);
}
