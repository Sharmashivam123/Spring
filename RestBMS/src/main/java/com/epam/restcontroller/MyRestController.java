package com.epam.restcontroller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.epam.services.RestClientService;
import com.epam.services.SeatsServices;
import com.epam.services.ShowTimingServices;
import com.epam.services.TheatreServices;
import com.epam.services.TicketServices;

@RestController
public class MyRestController {
	private static final Logger log = Logger.getLogger(RestClientService.class);

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
		log.info(new ResponseEntity<List<City>>(cityServices.getAvailableCities(), HttpStatus.OK).getBody());
		log.info(cityServices.getAvailableCities());
		return new ResponseEntity<List<City>>(cityServices.getAvailableCities(), HttpStatus.OK);
	}

	@GetMapping(value = "/rstlocation", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Location>> getAllLocationPinByCity() {
		return new ResponseEntity<List<Location>>(locationServices.getAreaPinInCity(), HttpStatus.OK);
	}

	@GetMapping(value = "/rstmovie", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Movie>> getAllMoviesAtLocation() {
		return new ResponseEntity<List<Movie>>(movieServices.getMoviesAtLocation(), HttpStatus.OK);
	}

	@GetMapping(value = "/rsttheatre", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Theatre>> getAllTheatresForMovie() {
		return new ResponseEntity<List<Theatre>>(theatreServices.getTheatreListByMovie(), HttpStatus.OK);
	}

	@GetMapping(value = "/rstdate", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String[]> getAllDatesForMovie() {
		return new ResponseEntity<String[]>((String[]) dateServices.getAvailableDates()
				.toArray(new String[dateServices.getAvailableDates().size()]), HttpStatus.OK);
	}

	@GetMapping(value = "/rsttiming12")
	public ResponseEntity<String[]> getAllTimingsForShows() {
		return new ResponseEntity<String[]>((String[]) showTimingServices.getShowTiming()
				.toArray(new String[showTimingServices.getShowTiming().size()]), HttpStatus.OK);
	}

	@GetMapping(value = "/rstseats/{tier}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<SeatArrangements>> getSeats(@PathVariable String tier) {
		return new ResponseEntity<List<SeatArrangements>>(seatServices.getSeatRanges(tier), HttpStatus.OK);
	}

	@PostMapping(value = "/rstbooking")
	public ResponseEntity<String> getBookingStatus() {
		boolean status = bookingServices.processBooking();
		String bookingStatus = "false";
		if (status)
			bookingStatus = "true";
		return new ResponseEntity<String>(bookingStatus, HttpStatus.OK);
	}

	@GetMapping(value = "/rsttickets", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<TicketsDetails> getTicketDetails() {
		return new ResponseEntity<TicketsDetails>(ticketServices.getTicketDetails(), HttpStatus.OK);
	}

}
