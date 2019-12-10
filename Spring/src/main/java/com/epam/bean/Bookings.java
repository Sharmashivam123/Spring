package com.epam.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component

@Entity
@Table(name = "bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private int theatreId;
	private int movieId;
	private int ticketBooked;
	private String seatId;
	private LocalTime showtiming;
	private LocalDate showdate;

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

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public LocalTime getShowtiming() {
		return showtiming;
	}

	public void setShowtiming(LocalTime showtiming) {
		this.showtiming = showtiming;
	}

	public LocalDate getShowdate() {
		return showdate;
	}

	public void setShowdate(LocalDate showdate) {
		this.showdate = showdate;
	}

	public int getTicketBooked() {
		return ticketBooked;
	}

	public void setTicketBooked(int ticketBooked) {
		this.ticketBooked = ticketBooked;
	}
}
