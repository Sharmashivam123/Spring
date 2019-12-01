package com.epam.dao.daoImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.bean.BookingDetails;
import com.epam.bean.TicketsDetails;
import com.epam.dao.TicketDetailsDao;

@Repository
public class TicketDetailsDaoImpl implements TicketDetailsDao {
	private double totalCost;
	private LocalTime showTiming;
	private LocalDate showDate;
	private String fullName, movieName, phone, seatIdAndCost[], seatId;
	private int bookingId, ticketBooked;
	@Autowired
	private TicketsDetails ticketsDetails;
	@Autowired
	private BookingDetails bookingDetails;

	@Override
	public TicketsDetails getTicketDetails() {
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
		seatId = "";
		for (int seat = 0; seat < ticketBooked; seat++) {
			String seatIdAndCostArray[] = seatIdAndCost[seat].split(" ");
			String seatIdString = seatIdAndCostArray[0] + " ";
			seatId += seatIdString;
		}
		ticketsDetails.setSeatId(seatId);
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
