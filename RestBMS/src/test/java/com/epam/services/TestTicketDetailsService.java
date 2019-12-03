package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.TicketsDetails;
import com.epam.dao.TicketDetailsDao;
import com.epam.services.servicesImpl.TicketServicesImpl;

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
		ticketDetails.setBookingId(115);
		ticketDetails.setFullName("shivam");
		ticketDetails.setMovieName("war");
		ticketDetails.setPhone("969101996");
		ticketDetails.setSeatId("A1 C2 B1");
		ticketDetails.setShowDate(LocalDate.now().toString());
		ticketDetails.setShowTiming("22:15");
		ticketDetails.setTicketBooked(3);
		ticketDetails.setTotalCost(1087.33);
		when(ticketDetailsDao.getTicketDetails()).thenReturn(ticketDetails);
		assertEquals(ticketDetails, ticketDetailsDao.getTicketDetails());
	}

}
