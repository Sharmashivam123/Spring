package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.TicketsDetails;
import com.epam.repo.TicketDetailsDao;
import com.epam.services.impl.TicketServicesImpl;

class TestTicketDetailsService {

	@InjectMocks
	private TicketServicesImpl mock;

	@Mock
	private TicketsDetails ticketDetails;

	@Mock
	private TicketDetailsDao ticketDetailsDao;

	@Test
	void test() {
		MockitoAnnotations.initMocks(this);
		doNothing().when(ticketDetails).setBookingId(115);
		doNothing().when(ticketDetails).setFullName("shivam");
		doNothing().when(ticketDetails).setMovieName("war");
		doNothing().when(ticketDetails).setPhone("969101996");
		doNothing().when(ticketDetails).setSeatId("A1 C2 B1");
		doNothing().when(ticketDetails).setShowDate(LocalDate.now().toString());
		doNothing().when(ticketDetails).setShowTiming("22:15");
		doNothing().when(ticketDetails).setTicketBooked(3);
		doNothing().when(ticketDetails).setTotalCost(1087.33);
		when(ticketDetailsDao.getTicketDetails()).thenReturn(ticketDetails);
		assertEquals(ticketDetails, ticketDetailsDao.getTicketDetails());
	}

}
