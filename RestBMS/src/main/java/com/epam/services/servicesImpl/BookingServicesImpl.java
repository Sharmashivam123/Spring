package com.epam.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.Bookings;
import com.epam.bean.UserDetails;
import com.epam.dao.BookingsDao;
import com.epam.dao.UserDetailsDao;
import com.epam.services.BookingServices;
import com.epam.services.PriceCalculationServices;

@Service
public class BookingServicesImpl implements BookingServices{
	@Autowired
	private BookingsDao bookingsDao;
	@Autowired
	private Bookings bookings;
	@Autowired
	private BookingDetails bookingDetails;
	private boolean check;
	@Autowired
	private UserDetails userDetails;
	@Autowired
	private UserDetailsDao userRepo;
	@Autowired 
	private PriceCalculationServices service;

	public Boolean processBooking() {
		bookings.setMovieId(bookingDetails.getMovieId());
		bookings.setTheatreId(bookingDetails.getTheatreId());
		bookings.setShowtiming(bookingDetails.getTime());
		bookings.setShowdate(bookingDetails.getDate());
		bookings.setTicketBooked(bookingDetails.getSeatCount());
		String seatIds = "";
		int ticketBooked = bookingDetails.getSeatCount();
		String seatIdAndCost[] = bookingDetails.getCostAndSeatId();
		for (int seat = 0; seat < ticketBooked; seat++) {
			String seatIdAndCostArray[] = seatIdAndCost[seat].split(" ");
			String seatId = seatIdAndCostArray[0] + " ";
			seatIds += seatId;
		}
		bookings.setSeatId(seatIds);
		Bookings booking = bookingsDao.save(bookings);
		int bookingId = booking.getBookingId();
		bookingDetails.setBookingId(bookingId);
		if(bookingId != 0)
		{
			userDetails.setBookingId(bookingId);
			userDetails.setPhone(bookingDetails.getPhone());
			double totalCost = service.getTotalCost();
			userDetails.setTotalCost(totalCost);
			userDetails.setFullName(bookingDetails.getUserName());
			userDetails = userRepo.save(userDetails);
		}
		if(userDetails.getUserId()!=0)check=true;
		return check;
	}
}
