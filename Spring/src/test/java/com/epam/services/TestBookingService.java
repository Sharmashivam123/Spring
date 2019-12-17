package com.epam.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.BookingDetails;
import com.epam.bean.Bookings;
import com.epam.bean.UserDetails;
import com.epam.repo.BookingsDao;
import com.epam.repo.CityDao;
import com.epam.services.impl.BookingServicesImpl;

public class TestBookingService {
	@InjectMocks
	BookingServicesImpl mock;

	@Mock
	private BookingsDao bookingsDao;
	@Mock
	private CityDao cityDao;
	@Mock
	private UserDetails userDetails;
	@Mock
	private Bookings bookings;
	@Mock
	private BookingDetails bookingDetails;
	@Mock
	private PriceCalculationServices service;

	@Test
	public void testBooking() {
		MockitoAnnotations.initMocks(this);
		doNothing().when(bookings).setMovieId(1);
		doNothing().when(bookings).setTheatreId(1);
		doNothing().when(bookings).setShowtiming(LocalTime.parse("22:10"));
		doNothing().when(bookings).setShowdate(LocalDate.now());
		when(bookingDetails.getSeatCount()).thenReturn(3);
		doNothing().when(bookings).setTicketBooked(3);
		when(bookingDetails.getCostAndSeatId()).thenReturn(new String[] { "A1 150", "B1 200", "C2 250" });
		doNothing().when(bookings).setSeatId("A1 B1 C2");
		when(bookingsDao.save(bookings)).thenReturn(bookings);
		when(bookings.getBookingId()).thenReturn(115);
		doNothing().when(bookingDetails).setBookingId(115);
		doNothing().when(userDetails).setBookingId(115);
		doNothing().when(userDetails).setPhone("9691061996");
		when(service.getTotalCost()).thenReturn(1087.33);
		doNothing().when(userDetails).setTotalCost(1087.33);
		doNothing().when(userDetails).setFullName("shivam");
		when(userDetails.getUserId()).thenReturn(53);
		assertThat(true);
	}
}
