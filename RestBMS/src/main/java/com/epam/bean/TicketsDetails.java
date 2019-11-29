package com.epam.bean;

import org.springframework.stereotype.Component;

@Component
public class TicketsDetails {
	private String fullName;
	private String phone;
	private int bookingId;
	private String movieName;
	private String showTiming;
	private String showDate;
	private int ticketBooked;
	private String seatId;
	private double totalCost;

	public String getFullName() {
		return fullName;
	} 

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public int getTicketBooked() {
		return ticketBooked;
	}

	public void setTicketBooked(int ticketBooked) {
		this.ticketBooked = ticketBooked;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
