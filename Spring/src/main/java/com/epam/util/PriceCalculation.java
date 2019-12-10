package com.epam.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;

@Service
public class PriceCalculation {

	@Autowired
	BookingDetails bookingDetails;

	public double calculatePrice() {
		double totalCost = 0.0;
		String seatIdAndCost[] = bookingDetails.getCostAndSeatId();
		int ticketsCount = bookingDetails.getSeatCount();
		for (int seat = 0; seat < ticketsCount; seat++) {
			String seatIdAndCostArray[] = seatIdAndCost[seat].split(" ");
			double cost = Double.parseDouble(seatIdAndCostArray[1]);
			totalCost += cost;
			totalCost = 1.18 * totalCost;
			totalCost = BigDecimal.valueOf(totalCost).setScale(2, RoundingMode.HALF_UP).doubleValue();
		}
		bookingDetails.setTotalCost(totalCost);
		return totalCost;
	}
}
