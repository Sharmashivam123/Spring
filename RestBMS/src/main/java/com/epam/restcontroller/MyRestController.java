package com.epam.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.bean.City;
import com.epam.bean.Location;
import com.epam.bean.Movie;
import com.epam.bean.SeatArrangements;
import com.epam.bean.Theatre;
import com.epam.bean.TicketsDetails;
import com.epam.services.BookingServices;
import com.epam.services.CityServices;
import com.epam.services.DateServices;
import com.epam.services.LocationServices;
import com.epam.services.MovieServices;
import com.epam.services.SeatsServices;
import com.epam.services.ShowTimingServices;
import com.epam.services.TheatreServices;
import com.epam.services.TicketServices;

@RestController
public class MyRestController {

	@Autowired
	private CityServices cityServices;
	@Autowired
	private LocationServices locationServices;
	@Autowired
	private MovieServices movieServices;
	@Autowired
	private TheatreServices theatreServices;
	@Autowired
	private DateServices dateServices;
	@Autowired
	private ShowTimingServices showTimingServices;
	@Autowired
	private SeatsServices seatServices;
	@Autowired
	private TicketServices ticketServices;
	@Autowired
	private BookingServices bookingServices;

	@GetMapping(value = "/rstcity", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<City>> getAllCities() throws RuntimeException {
		return new ResponseEntity<List<City>>(cityServices.getAvailableCities(), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstlocation", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Location>> getAllLocationPinByCity() {
		List<Location> listLocation = locationServices.getAreaPinInCity();
		try {
			return ResponseEntity.ok(listLocation);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<List<Location>>) ResponseEntity.badRequest();
		}

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstmovie", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Movie>> getAllMoviesAtLocation() throws RuntimeException {
		List<Movie> movieList = movieServices.getMoviesAtLocation();
		try {
			return ResponseEntity.ok(movieList);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<List<Movie>>) ResponseEntity.badRequest();
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rsttheatre", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Theatre>> getAllTheatresForMovie() throws RuntimeException {
		List<Theatre> theatreList = theatreServices.getTheatreListByMovie();
		try {
			return ResponseEntity.ok(theatreList);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<List<Theatre>>) ResponseEntity.badRequest();
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstdate", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String[]> getAllDatesForMovie() throws RuntimeException {
		String[] dateArray = (String[]) dateServices.getAvailableDates()
				.toArray(new String[dateServices.getAvailableDates().size()]);
		try {
			return ResponseEntity.ok(dateArray);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<String[]>) ResponseEntity.badRequest();
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rsttiming12")
	public ResponseEntity<String[]> getAllTimingsForShows() throws RuntimeException {
		String[] timeList = (String[]) showTimingServices.getShowTiming()
				.toArray(new String[showTimingServices.getShowTiming().size()]);
		try {
			return ResponseEntity.ok(timeList);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<String[]>) ResponseEntity.badRequest();
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstseats/{tier}")
	public ResponseEntity<List<SeatArrangements>> getSeats(@PathVariable String tier) throws RuntimeException {
		List<SeatArrangements> seatList = seatServices.getSeatRanges(tier);
		try {
			return ResponseEntity.ok(seatList);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<List<SeatArrangements>>) ResponseEntity.badRequest();
		}
	}

	@PostMapping(value = "/rstbooking")
	public ResponseEntity<String> getBookingStatus() throws RuntimeException {
		boolean status = bookingServices.processBooking();
		String bookingStatus = "false";
		if (status)
			bookingStatus = "true";
		return new ResponseEntity<String>(bookingStatus, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rsttickets", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<TicketsDetails> getTicketDetails() throws RuntimeException {
		TicketsDetails ticketsDetails = ticketServices.getTicketDetails();
		try {
			return ResponseEntity.ok(ticketsDetails);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<TicketsDetails>) ResponseEntity.badRequest();
		}
	}

}
