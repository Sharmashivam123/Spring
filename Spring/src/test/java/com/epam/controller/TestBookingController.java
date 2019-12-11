package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.bean.Bookings;
import com.epam.services.RestClientService;

@WithMockUser("Spring")
@SpringBootTest
@AutoConfigureMockMvc
class TestBookingController {

	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private RestClientService service;
	@MockBean
	private TicketsDetailController ticket;
	@MockBean
	Bookings booking;

	@Test
	public void testBooking() throws Exception {
		booking.setMovieId(1);
		booking.setSeatId("A1");
		booking.setShowdate(LocalDate.now());
		booking.setShowtiming(LocalTime.parse("22:00"));
		booking.setTheatreId(1);
		booking.setTicketBooked(1);
		doNothing().when(bookingDetails).setUserName("shivam");
		doNothing().when(bookingDetails).setPhone("9691061996");
		when(service.processBooking(booking)).thenReturn("true");
		mockmvc.perform(post("/booking")).andExpect(status().isOk()).andExpect((forwardedUrl("booking.jsp")));
	}

}
