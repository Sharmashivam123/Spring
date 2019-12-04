package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.services.RestClientService;

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

	@Test
	public void testBooking() throws Exception {

		doNothing().when(bookingDetails).setUserName("shivam");
		doNothing().when(bookingDetails).setPhone("9691061996");
		when(service.processBooking()).thenReturn("true");
		mockmvc.perform(post("/booking?userName=Shivam")).andExpect(status().isOk())
				.andExpect((forwardedUrl("booking.jsp")));
	}

}
