package com.epam.services.servicesImpl;

import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	public List<Location> getAreaPincodeByCity() {
		ResponseEntity<List<Location>> responseList = rest.exchange(Constants.LOCATION_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		return responseList.getBody();
	}

	public List<Movie> getAllMoviesAtLocation() {
		ResponseEntity<List<Movie>> responseList = rest.exchange(Constants.MOVIE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Movie>>() {
				});
		return responseList.getBody();
	}

	public List<Theatre> getAllTheatresForMovieSelected() {
		ResponseEntity<List<Theatre>> responseList = rest.exchange(Constants.THEATRE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Theatre>>() {
				});
		return responseList.getBody();
	}

	public List<String> getAllDates() {
		String[] responseList = rest.getForObject(Constants.DATE_URL, String[].class);
		return Arrays.asList(responseList);
	}

	public List<String> getAllTimings() {
		String[] responseList = rest.getForObject(Constants.SHOW_TIME_URL, String[].class);
		return Arrays.asList(responseList);
	}

	public List<SeatArrangements> getSeatRanges(String tier) {
		StringBuilder str = new StringBuilder();
		str.append(Constants.SEATRANGE_URL);
		str.append(tier);
		log.info(str.toString());
		ResponseEntity<List<SeatArrangements>> responseList = rest.exchange(str.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SeatArrangements>>() {
				});
		responseList.getBody().stream().forEach(s->log.info(s.getSeatId()));
		return responseList.getBody();
	}

	public String processBooking() {
		String responseList = rest.postForObject(Constants.BOOKING_URL, null, String.class);
		return responseList;
	}

	public TicketsDetails getTicketDetails() {
		return rest.getForObject(Constants.TICKET_URL, TicketsDetails.class);
	}

}
