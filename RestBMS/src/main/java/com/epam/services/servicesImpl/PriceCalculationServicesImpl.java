package com.epam.services.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.services.PriceCalculationServices;
import com.epam.util.ApplicationConstants;
import com.epam.util.PriceCalculation;

@Service
public class PriceCalculationServicesImpl implements PriceCalculationServices {

	@Autowired
	private PriceCalculation priceCalculation;

	public double getTotalCost() {
		double totalCost = priceCalculation.calculatePrice();
		Optional.ofNullable(totalCost).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
		return totalCost;
	}

}
