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
	private int lenSilverSeats, lenGoldSeats, lenPlatinumSeats, totalSeats, count;
	private String[] seatIdAndCostList, silverSeatAndCostList, goldSeatAndCostList, platinumSeatAndCostList;

	public void setSeatIdAndCostList(Optional<String> silverOptional, Optional<String> goldOptional,
			Optional<String> platinumOptional) {
		String silverSeatAndCost = silverOptional.orElse("");
		String goldSeatAndCost = goldOptional.orElse("");
		String platinumSeatAndCost = platinumOptional.orElse("");

		silverSeatAndCostList = silverSeatAndCost.split(",");
		goldSeatAndCostList = goldSeatAndCost.split(",");
		platinumSeatAndCostList = platinumSeatAndCost.split(",");

		lenSilverSeats = (silverSeatAndCostList[0] == "") ? 0 : silverSeatAndCostList.length;
		lenGoldSeats = (goldSeatAndCostList[0] == "") ? 0 : goldSeatAndCostList.length;
		lenPlatinumSeats = (platinumSeatAndCostList[0] == "") ? 0 : platinumSeatAndCostList.length;
		totalSeats = lenGoldSeats + lenPlatinumSeats + lenSilverSeats;
		seatIdAndCostList = new String[totalSeats];
		bookingDetails.setSeatCount(totalSeats);
		count = 0;
		for (int seat = 0; seat < lenSilverSeats; seat++)
			seatIdAndCostList[count++] = silverSeatAndCostList[seat];
		for (int seat = 0; seat < lenGoldSeats; seat++)
			seatIdAndCostList[count++] = goldSeatAndCostList[seat];
		for (int seat = 0; seat < lenPlatinumSeats; seat++)
			seatIdAndCostList[count++] = platinumSeatAndCostList[seat];
		bookingDetails.setCostAndSeatId(seatIdAndCostList);
	}

}
