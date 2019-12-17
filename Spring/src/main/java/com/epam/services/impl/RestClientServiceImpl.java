package com.epam.services.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.bean.Bookings;
import com.epam.bean.City;
import com.epam.bean.Location;
import com.epam.bean.Movie;
import com.epam.bean.SeatArrangements;
import com.epam.bean.Theatre;
import com.epam.bean.TicketsDetails;
import com.epam.services.RestClientService;
import com.epam.util.Constants;

@Service
public class RestClientServiceImpl implements RestClientService {

	private static final Logger log = Logger.getLogger(RestClientServiceImpl.class);
	RestTemplate rest = new RestTemplate();

	public List<City> getAllCities() {
		ResponseEntity<List<City>> responseList = rest.exchange(Constants.CITY_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<City>>() {
				});
		log.info(responseList.getBody());
		return responseList.getBody();
	}

	public List<Location> getAreaPincodeByCity(int cityId) {
		StringBuilder str = new StringBuilder();
		str.append(Constants.LOCATION_URL);
		str.append(cityId);

		ResponseEntity<List<Location>> responseList = rest.exchange(str.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		return responseList.getBody();
	}

	public List<Movie> getAllMoviesAtLocation(int location) {
		StringBuilder str = new StringBuilder();
		str.append(Constants.MOVIE_URL);
		str.append(location);

		ResponseEntity<List<Movie>> responseList = rest.exchange(str.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Movie>>() {
				});
		return responseList.getBody();
	}

	public List<Theatre> getAllTheatresForMovieSelected(int movieId) {
		StringBuilder str = new StringBuilder();
		str.append(Constants.THEATRE_URL);
		str.append(movieId);

		ResponseEntity<List<Theatre>> responseList = rest.exchange(str.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Theatre>>() {
				});
		return responseList.getBody();
	}

	public List<String> getAllDates() {
		String[] responseList = rest.getForObject(Constants.DATE_URL, String[].class);
		return Arrays.asList(responseList);
	}

	public List<String> getAllTimings(int movieId, int theatreId, LocalDate date) {
		StringBuilder str = new StringBuilder();
		str.append(Constants.SHOW_TIME_URL);
		str.append(movieId);
		str.append("/" + theatreId);
		str.append("/" + date);
		String[] responseList = rest.getForObject(str.toString(), String[].class);
		return Arrays.asList(responseList);
	}

	public Map<SeatArrangements, Boolean> getSeatRanges(String tier) {
		StringBuilder str = new StringBuilder();
		str.append(Constants.SEATRANGE_URL);
		str.append(tier);
		ResponseEntity<Map<SeatArrangements, Boolean>> responseList = null;
		responseList = rest.exchange(str.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<Map<SeatArrangements, Boolean>>() {
				});
		return responseList.getBody();
	}

	public String processBooking(Bookings bookings) {
		return rest.postForObject(Constants.BOOKING_URL, bookings, String.class);
	}

	public TicketsDetails getTicketDetails() {
		return rest.getForObject(Constants.TICKET_URL, TicketsDetails.class);
	}

}
