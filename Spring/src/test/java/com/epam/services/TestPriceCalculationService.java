package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.services.impl.PriceCalculationServicesImpl;
import com.epam.util.PriceCalculation;

class TestPriceCalculationService {
	@InjectMocks
	PriceCalculationServicesImpl mock;

	@Mock
	PriceCalculation priceCalculation;

	@Test
	void test() {
		MockitoAnnotations.initMocks(this);
		when(priceCalculation.calculatePrice()).thenReturn(1037.00);
		assertEquals(1037.00, priceCalculation.calculatePrice());
	}

}
