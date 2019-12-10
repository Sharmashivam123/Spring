package com.epam.services.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.services.SeatConfirmationService;

@Service
public class SeatConfirmationServiceImpl implements SeatConfirmationService {

	@Autowired
	private BookingDetails bookingDetails;
	private int lenSeats, count;
	private String[] seatIdAndCostList, seatArray;

	public void setSeatIdAndCostList(Optional<String> seatsOptional) {
		String seats = seatsOptional.orElse("");

		seatArray = seats.split(",");

		lenSeats = (seatArray[0] == "") ? 0 : seatArray.length;
		seatIdAndCostList = new String[lenSeats];
		bookingDetails.setSeatCount(lenSeats);
		count = 0;
		for (int seat = 0; seat < lenSeats; seat++)
			seatIdAndCostList[count++] = seatArray[seat];

		bookingDetails.setCostAndSeatId(seatIdAndCostList);
	}

}
