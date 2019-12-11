package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.services.RestClientService;

@WithMockUser("Spring")
@SpringBootTest
@AutoConfigureMockMvc
class TestDateController {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private RestClientService service;

	@Test
	public void testDate() throws Exception {
		doNothing().when(bookingDetails).setTheatreId(1);
		List<String> datesMap = new ArrayList<>();
		datesMap.add(0, LocalDate.now().toString());
		datesMap.add(1, LocalDate.now().plusDays(1).toString());
		datesMap.add(2, LocalDate.now().plusDays(2).toString());
		when(service.getAllDates()).thenReturn(datesMap);
		mockmvc.perform(get("/date?theatre=1")).andExpect(status().isOk())
				.andExpect(model().attribute("dates", datesMap)).andExpect((forwardedUrl("date.jsp")));
	}
}
