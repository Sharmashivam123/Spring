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

import com.epam.ExceptionHandler.Exception.BookingFailException;
import com.epam.ExceptionHandler.Exception.CityNotfoundException;
import com.epam.ExceptionHandler.Exception.DateNotfoundException;
import com.epam.ExceptionHandler.Exception.LocationNotfoundException;
import com.epam.ExceptionHandler.Exception.MovieNotfoundException;
import com.epam.ExceptionHandler.Exception.ShowTimeNotfoundException;
import com.epam.ExceptionHandler.Exception.TheatreNotfoundException;
import com.epam.ExceptionHandler.Exception.TicketDetailsException;
import com.epam.bean.City;
import com.epam.bean.Location;
import com.epam.bean.Movie;
import com.epam.bean.SeatArrangements;
import com.epam.bean.Theatre;
import com.epam.bean.TicketsDetails;
import com.epam.services.servicesImpl.BookingServicesImpl;
import com.epam.services.servicesImpl.CityServicesImpl;
import com.epam.services.servicesImpl.DateServicesImpl;
import com.epam.services.servicesImpl.LocationServicesImpl;
import com.epam.services.servicesImpl.MovieServicesImpl;
import com.epam.services.servicesImpl.SeatsServicesImpl;
import com.epam.services.servicesImpl.ShowTimingServicesImpl;
import com.epam.services.servicesImpl.TheatreServicesImpl;
import com.epam.services.servicesImpl.TicketServicesImpl;

@RestController
public class MyRestController {

	@Autowired
	private CityServicesImpl cityServices;
	@Autowired
	private LocationServicesImpl locationServices;
	@Autowired
	private MovieServicesImpl movieServices;
	@Autowired
	private TheatreServicesImpl theatreServices;
	@Autowired
	private DateServicesImpl dateServices;
	@Autowired
	private ShowTimingServicesImpl showTimingServices;
	@Autowired
	private SeatsServicesImpl seatServices;
	@Autowired
	private TicketServicesImpl ticketServices;
	@Autowired
	private BookingServicesImpl bookingServices;

	@GetMapping(value = "/rstcity", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<City>> getAllCities() throws RuntimeException {
		return new ResponseEntity<List<City>>(cityServices.getAvailableCities(), HttpStatus.OK);
	}

	@GetMapping(value = "/rstlocation", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Location>> getAllLocationPinByCity() {
		List<Location> listLocation = locationServices.getAreaPinInCity();
		if (listLocation == null)
			throw new CityNotfoundException();
		return new ResponseEntity<List<Location>>(listLocation, HttpStatus.OK);
	}

	@GetMapping(value = "/rstmovie", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Movie>> getAllMoviesAtLocation() throws RuntimeException {
		List<Movie> movieList = movieServices.getMoviesAtLocation();
		if (movieList == null)
			throw new LocationNotfoundException();
		return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
	}

	@GetMapping(value = "/rsttheatre", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Theatre>> getAllTheatresForMovie() throws RuntimeException {
		List<Theatre> theatreList = theatreServices.getTheatreListByMovie();
		if (theatreList == null)
			throw new MovieNotfoundException();
		return new ResponseEntity<List<Theatre>>(theatreList, HttpStatus.OK);
	}

	@GetMapping(value = "/rstdate", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String[]> getAllDatesForMovie() throws RuntimeException {
		String[] dateArray = (String[]) dateServices.getAvailableDates()
				.toArray(new String[dateServices.getAvailableDates().size()]);
		if (dateArray == null)
			throw new TheatreNotfoundException();
		return new ResponseEntity<String[]>(dateArray, HttpStatus.OK);
	}

	@GetMapping(value = "/rsttiming12")
	public ResponseEntity<String[]> getAllTimingsForShows() throws RuntimeException {
		String[] timeList = (String[]) showTimingServices.getShowTiming()
				.toArray(new String[showTimingServices.getShowTiming().size()]);
		if (timeList == null)
			throw new DateNotfoundException();
		return new ResponseEntity<String[]>(timeList, HttpStatus.OK);
	}

	@GetMapping(value = "/rstseats/{tier}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<SeatArrangements>> getSeats(@PathVariable String tier) throws RuntimeException {
		List<SeatArrangements> seatList = seatServices.getSeatRanges(tier);
		if (seatList == null)
			throw new ShowTimeNotfoundException();
		return new ResponseEntity<List<SeatArrangements>>(seatList, HttpStatus.OK);
	}

	@PostMapping(value = "/rstbooking")
	public ResponseEntity<String> getBookingStatus() throws RuntimeException {
		boolean status = bookingServices.processBooking();
		String bookingStatus = "false";
		if (status)
			bookingStatus = "true";
		else
			throw new BookingFailException();
		return new ResponseEntity<String>(bookingStatus, HttpStatus.OK);
	}

	@GetMapping(value = "/rsttickets", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<TicketsDetails> getTicketDetails() throws RuntimeException {
		TicketsDetails ticketsDetails = ticketServices.getTicketDetails();
		if (ticketsDetails == null)
			throw new TicketDetailsException();
		return new ResponseEntity<TicketsDetails>(ticketsDetails, HttpStatus.OK);
	}

}
