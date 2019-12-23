package com.epam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.Bookings;
import com.epam.bean.UserDetails;
import com.epam.repo.BookingsDao;
import com.epam.repo.UserDetailsDao;
import com.epam.services.BookingServices;
import com.epam.services.PriceCalculationServices;

@Service
public class BookingServicesImpl implements BookingServices {
	@Autowired
	private BookingsDao bookingsDao;
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private UserDetails userDetails;
	@Autowired
	private UserDetailsDao userRepo;
	@Autowired
	private PriceCalculationServices service;

	public Boolean processBooking(Bookings bookings) {
		boolean check = false;
		Bookings booking = bookingsDao.save(bookings);
		int bookingId = booking.getBookingId();
		bookingDetails.setBookingId(bookingId);
		if (bookingId != 0) {
			userDetails.setBookingId(bookingId);
			userDetails.setPhone(bookingDetails.getPhone());
			double totalCost = service.getTotalCost();
			userDetails.setTotalCost(totalCost);
			userDetails.setFullName(bookingDetails.getUserName());
			userDetails = userRepo.save(userDetails);
		}
		if (userDetails.getUserId() != 0)
			check = true;
		return check;
	}
}
