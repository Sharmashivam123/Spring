package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.services.SeatConfirmationService;

@SpringBootTest
@AutoConfigureMockMvc
class TestSeatConfirmation {

	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private SeatConfirmationService service;

	@Test
	public void testSeatConfirmation() throws Exception {
		String silverSeatAndCost = "A1 150";
		String goldSeatAndCost = "B1 200";
		String platinumSeatAndCost = "C2 250";
		Optional<String> silverOptional = Optional.ofNullable(silverSeatAndCost);
		Optional<String> goldOptional = Optional.ofNullable(goldSeatAndCost);
		Optional<String> platinumOptional = Optional.ofNullable(platinumSeatAndCost);

		doNothing().when(service).setSeatIdAndCostList(silverOptional, goldOptional, platinumOptional);
		mockmvc.perform(get("/confirmation")).andExpect(status().isOk()).andExpect((forwardedUrl("user.jsp")));
	}
}
