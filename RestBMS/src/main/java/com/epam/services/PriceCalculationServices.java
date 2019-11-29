package com.epam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.util.PriceCalculation;

@Service
public class PriceCalculationServices {

	@Autowired
	private PriceCalculation priceCalculation;

	public double getTotalCost() {
		double totalCost = priceCalculation.calculatePrice();
		return totalCost;
	}

}
