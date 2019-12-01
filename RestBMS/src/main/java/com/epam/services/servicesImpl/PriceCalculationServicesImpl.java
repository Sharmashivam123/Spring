package com.epam.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.services.PriceCalculationServices;
import com.epam.util.PriceCalculation;

@Service
public class PriceCalculationServicesImpl implements PriceCalculationServices{

	@Autowired
	private PriceCalculation priceCalculation;

	public double getTotalCost() {
		double totalCost = priceCalculation.calculatePrice();
		return totalCost;
	}

}
