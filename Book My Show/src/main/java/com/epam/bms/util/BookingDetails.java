package com.epam.bms.util;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingDetails {
	private static BookingDetails bookingDetails = null;
	private int bookingId;
	private int theatreId;
	private int movieId;
	private LocalTime time;
	private LocalDate date;

	private BookingDetails() {

	}

	public static BookingDetails getInstance() {
		if (bookingDetails == null)
			bookingDetails = new BookingDetails();
		return bookingDetails;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
