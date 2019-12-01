package com.epam.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.ExceptionHandler.Exception.BookingFailException;
import com.epam.ExceptionHandler.Exception.CityNotfoundException;
import com.epam.ExceptionHandler.Exception.DateNotfoundException;
import com.epam.ExceptionHandler.Exception.LocationNotfoundException;
import com.epam.ExceptionHandler.Exception.MovieNotfoundException;
import com.epam.ExceptionHandler.Exception.ShowTimeNotfoundException;
import com.epam.ExceptionHandler.Exception.TheatreNotfoundException;
import com.epam.ExceptionHandler.Exception.TicketDetailsException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = CityNotfoundException.class)
	public ResponseEntity<Object> exception(CityNotfoundException exception) {
		return new ResponseEntity<>("City not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = LocationNotfoundException.class)
	public ResponseEntity<Object> exception(LocationNotfoundException exception) {
		return new ResponseEntity<>("Location not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MovieNotfoundException.class)
	public ResponseEntity<Object> exception(MovieNotfoundException exception) {
		return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TheatreNotfoundException.class)
	public ResponseEntity<Object> exception(TheatreNotfoundException exception) {
		return new ResponseEntity<>("Theatre not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DateNotfoundException.class)
	public ResponseEntity<Object> exception(DateNotfoundException exception) {
		return new ResponseEntity<>("Date not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ShowTimeNotfoundException.class)
	public ResponseEntity<Object> exception(ShowTimeNotfoundException exception) {
		return new ResponseEntity<>("ShowTime not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BookingFailException.class)
	public ResponseEntity<Object> exception(BookingFailException exception) {
		return new ResponseEntity<>("Bookings not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TicketDetailsException.class)
	public ResponseEntity<Object> exception(TicketDetailsException exception) {
		return new ResponseEntity<>("TicketDetails not found", HttpStatus.NOT_FOUND);
	}

}
