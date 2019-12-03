package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.BookingDetails;
import com.epam.bean.SeatArrangements;
import com.epam.dao.BookingsDao;
import com.epam.dao.SeatArrangementsDao;
import com.epam.services.servicesImpl.SeatsServicesImpl;

class TestSeatsServices {
	@InjectMocks
	SeatsServicesImpl mock;

	@Mock
	private BookingDetails bookingDetails;

	@Mock
	private SeatArrangementsDao seatArrangementsDao;

	@Mock
	private BookingsDao bookingDao;

	@Test
	void test() {
		MockitoAnnotations.initMocks(this);
		when(bookingDetails.getMovieId()).thenReturn(1);
		when(bookingDetails.getTheatreId()).thenReturn(1);
		when(bookingDetails.getTime()).thenReturn(LocalTime.parse("22:15"));
		when(bookingDetails.getDate()).thenReturn(LocalDate.now());
		List<String> listBookedSeats = new ArrayList<>();
		listBookedSeats.add("A1");
		listBookedSeats.add("B1 C1 C2");
		when(bookingDao.findBookedSeats(1, 1, LocalTime.parse("22:15"), LocalDate.now())).thenReturn(listBookedSeats);
		List<SeatArrangements> seatList = new ArrayList<SeatArrangements>();
		when(seatArrangementsDao.findAllByTier("silver")).thenReturn(seatList);
		assertEquals(seatList, seatArrangementsDao.findAllByTier("silver"));
	}

}
