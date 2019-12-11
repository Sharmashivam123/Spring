package com.epam.restcontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.bean.Bookings;
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
@RequestMapping("rest")
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
		System.out.println(cityServices.getAvailableCities());
		return new ResponseEntity<List<City>>(cityServices.getAvailableCities(), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstlocation/{cityId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Location>> getAllLocationPinByCity(@PathVariable int cityId) {
		List<Location> listLocation = locationServices.getAreaPinInCity(cityId);
		try {
			return ResponseEntity.ok(listLocation);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<List<Location>>) ResponseEntity.badRequest();
		}

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstmovie/{location}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Movie>> getAllMoviesAtLocation(@PathVariable int location) throws RuntimeException {
		List<Movie> movieList = movieServices.getMoviesAtLocation(location);
		try {
			return ResponseEntity.ok(movieList);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<List<Movie>>) ResponseEntity.badRequest();
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rsttheatre/{movieId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Theatre>> getAllTheatresForMovie(@PathVariable int movieId) throws RuntimeException {
		List<Theatre> theatreList = theatreServices.getTheatreListByMovie(movieId);
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
	@GetMapping(value = "/rsttiming12/{movieId}/{theatreId}/{date}")
	public ResponseEntity<String[]> getAllTimingsForShows(@PathVariable String movieId, @PathVariable String theatreId,
			@PathVariable String date) throws RuntimeException {
		List<String> list = showTimingServices.getShowTiming(Integer.parseInt(movieId), Integer.parseInt(theatreId),
				LocalDate.parse(date));
		String[] timeList = (String[]) list.toArray(new String[list.size()]);
		try {
			return ResponseEntity.ok(timeList);
		} catch (ServiceLayerException e) {
			return (ResponseEntity<String[]>) ResponseEntity.badRequest();
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rstseats/{tier}")
	public ResponseEntity<Map<SeatArrangements, Boolean>> getSeats(@PathVariable String tier) throws RuntimeException {
		try {
			ResponseEntity<Map<SeatArrangements, Boolean>> response = new ResponseEntity<Map<SeatArrangements, Boolean>>(
					seatServices.getSeatRanges(tier), HttpStatus.OK);
			return response;
		} catch (ServiceLayerException e) {
			return (ResponseEntity<Map<SeatArrangements, Boolean>>) ResponseEntity.badRequest();
		}
	}

	@PostMapping(value = "/rstbooking")
	public ResponseEntity<String> getBookingStatus(@RequestBody Bookings booking) throws RuntimeException {
		boolean status = bookingServices.processBooking(booking);
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
