package com.epam.bms.services;

public class PriceCalculation {

	public double calculatePrice(double cost, int seats) {
		double totalCost = cost * seats;
		double tax = (18 * totalCost) / 100;
		totalCost += tax;
		return totalCost;
	}
}
