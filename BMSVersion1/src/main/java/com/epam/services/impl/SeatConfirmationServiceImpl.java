package com.epam.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.services.SeatConfirmationService;

@Service
public class SeatConfirmationServiceImpl implements SeatConfirmationService {

	@Autowired
	private BookingDetails bookingDetails;

	public void setSeatIdAndCostList(Optional<String> seatsOptional) {
		int lenSeats;
		int count;
		String[] seatIdAndCostList;
		String[] seatArray;
		String seats = seatsOptional.orElse("");

		seatArray = seats.split(","); 

		lenSeats = (seatArray[0].equals("") ? 0 : seatArray.length);
		seatIdAndCostList = new String[lenSeats];
		bookingDetails.setSeatCount(lenSeats);
		count = 0;
		for (int seat = 0; seat < lenSeats; seat++)
			seatIdAndCostList[count++] = seatArray[seat];

		bookingDetails.setCostAndSeatId(seatIdAndCostList);
		
	}

}
