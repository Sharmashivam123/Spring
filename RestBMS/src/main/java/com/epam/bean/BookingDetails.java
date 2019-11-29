package com.epam.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class BookingDetails {
	private static BookingDetails bookingDetails = null;

	private int bookingId;
	private int theatreId;
	private int movieId;
	private int seatCount;
	private String[] costAndSeatId;
	private int cityId;
	private int pincode;
	private LocalTime time;
	private LocalDate date;
	private double totalCost;
	private String phone;
	private String userName;
	private String movieName;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCityId() {
		return cityId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String[] getCostAndSeatId() {
		return costAndSeatId;
	}

	public void setCostAndSeatId(String[] costAndId) {
		this.costAndSeatId = costAndId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}
