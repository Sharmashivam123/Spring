package com.epam.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.bean.Theatre;
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
	public void testTheatre() throws Exception {
		
		doNothing().when(bookingDetails).setUserName("shivam");
		doNothing().when(bookingDetails).setPhone("9691061996");
			when(service.processBooking()).thenReturn("true");
		mockmvc.perform(post("/booking")).andExpect(status().isOk())
				.andExpect(model().attribute("bookingStatus", true)).andExpect((forwardedUrl("ticket.doGet(true)")));
	}

}
