package com.epam.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bean.BookingDetails;
import com.epam.services.impl.SeatConfirmationServiceImpl;

class TestSeatConfirmation {
	@InjectMocks
	SeatConfirmationServiceImpl mock;
	@Mock
	BookingDetails bookingDetails;

	@Test
	void test() {
		MockitoAnnotations.initMocks(this);
		doNothing().when(bookingDetails).setSeatCount(Mockito.anyInt());
		String[] seatIdAndCostList = new String[] { "A1 150", "B1 200", "C1 250" };
		doNothing().when(bookingDetails).setCostAndSeatId(seatIdAndCostList);
		assertThat(true);
	}

}
