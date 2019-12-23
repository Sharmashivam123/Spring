package com.epam.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.services.PriceCalculationServices;
import com.epam.util.ApplicationConstants;
import com.epam.util.PriceCalculation;

@Service
public class PriceCalculationServicesImpl implements PriceCalculationServices {

	@Autowired
	private PriceCalculation priceCalculation;

	public double getTotalCost() {
		return Optional.ofNullable(priceCalculation.calculatePrice()).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
	}

}
