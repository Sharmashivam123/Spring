package com.epam.repo.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.bean.BookingDetails;
import com.epam.bean.TicketsDetails;
import com.epam.repo.TicketDetailsDao;

@Repository
public class TicketDetailsDaoImpl implements TicketDetailsDao {

	@Autowired
	private TicketsDetails ticketsDetails;
	@Autowired
	private BookingDetails bookingDetails;

	@Override
	public TicketsDetails getTicketDetails() {
		double totalCost;
		LocalTime showTiming;
		LocalDate showDate;
		String fullName;
		String movieName;
		String phone;
		String []seatIdAndCost ;
		StringBuilder seatId = new StringBuilder();
		int bookingId;
		int ticketBooked;
		bookingId = bookingDetails.getBookingId();
		ticketBooked = bookingDetails.getSeatCount();
		ticketsDetails.setBookingId(bookingId); 
		fullName = bookingDetails.getUserName();
		ticketsDetails.setFullName(fullName);
		movieName = bookingDetails.getMovieName();
		ticketsDetails.setMovieName(movieName);
		phone = bookingDetails.getPhone();
		ticketsDetails.setPhone(phone);
		seatIdAndCost = bookingDetails.getCostAndSeatId();
		for (int seat = 0; seat < ticketBooked; seat++) {
			String []seatIdAndCostArray = seatIdAndCost[seat].split(" ");
			String seatIdString = seatIdAndCostArray[0] + " ";
			seatId.append(seatIdString);
		}
		ticketsDetails.setSeatId(seatId.toString());
		showDate = bookingDetails.getDate();
		ticketsDetails.setShowDate(showDate.toString());
		showTiming = bookingDetails.getTime();
		ticketsDetails.setShowTiming(showTiming.toString());
		ticketsDetails.setTicketBooked(ticketBooked);
		totalCost = bookingDetails.getTotalCost();
		ticketsDetails.setTotalCost(totalCost);
		Optional<TicketsDetails> optionalMap = Optional.of(ticketsDetails);
		ticketsDetails = optionalMap.get();
		return ticketsDetails;
	}

}
