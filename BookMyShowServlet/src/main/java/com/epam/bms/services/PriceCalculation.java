package com.epam.bms.services;

import com.epam.bms.util.BookingDetails;

public class PriceCalculation {

	public double calculatePrice() {
		BookingDetails bookingDetails = BookingDetails.getInstance();
		double totalCost = 0.0;
		String seatIdAndCost[] = bookingDetails.getCostAndSeatId();
		int ticketsCount = bookingDetails.getSeatCount();
		for (int seat = 0; seat < ticketsCount; seat++) {
			String seatIdAndCostArray[] = seatIdAndCost[seat].split(" ");
			double cost = Double.parseDouble(seatIdAndCostArray[1]);
			totalCost+=cost;
			totalCost = 1.18*totalCost;
		}
		bookingDetails.setTotalCost(totalCost);
		return totalCost;
	}
}
