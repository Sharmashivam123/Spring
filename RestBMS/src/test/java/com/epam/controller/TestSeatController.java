package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.bean.SeatArrangements;
import com.epam.services.RestClientService;
import com.epam.services.SeatsServices;

@SpringBootTest
@AutoConfigureMockMvc
class TestSeatController {

	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private SeatsServices service;

	@Test
	public void testSeatController() throws Exception {
		doNothing().when(bookingDetails).setTime(LocalTime.parse("22:15"));
		List<SeatArrangements> silverList = new ArrayList<SeatArrangements>();

		List<SeatArrangements> goldList = new ArrayList<SeatArrangements>();

		List<SeatArrangements> platinumList = new ArrayList<SeatArrangements>();

		when(service.getSeatRanges("silver")).thenReturn(silverList);
		when(service.getSeatRanges("gold")).thenReturn(goldList);
		when(service.getSeatRanges("platinum")).thenReturn(platinumList);
		mockmvc.perform(get("/seats?showTime=22:15")).andExpect(status().isOk())
				.andExpect(model().attribute("silverSeats", silverList))
				.andExpect(model().attribute("goldSeats", goldList))
				.andExpect(model().attribute("platinumSeats", platinumList)).andExpect((forwardedUrl("seats.jsp")));
	}
}
