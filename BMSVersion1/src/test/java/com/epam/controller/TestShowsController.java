package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.services.RestClientService;

@WithMockUser("shivamsharma.js@gmail.com")
@SpringBootTest
@AutoConfigureMockMvc
class TestShowsController {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private RestClientService service;

	@Test
	public void testTime() throws Exception {
		Principal principal = new Principal() {

			@Override
			public String getName() {
				return "shivamsharma.js@gmail.com";
			}
		};
		doNothing().when(bookingDetails).setDate(LocalDate.now());
		String time1 = ("12:00");
		String time2 = ("15:00");
		String time3 = ("18:00");
		String time4 = ("22:15");
		List<String> timeList = new ArrayList<>();
		timeList.add(0, time1);
		timeList.add(1, time2);
		timeList.add(2, time3);
		timeList.add(3, time4);
		when(service.getAllTimings(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(LocalDate.class)))
				.thenReturn(timeList);
		mockmvc.perform(get("/timings?date=2019-12-13").principal(principal)).andExpect(status().isOk())
				.andExpect(model().attribute("shows", timeList)).andExpect((forwardedUrl("shows.jsp")));
	}

}
