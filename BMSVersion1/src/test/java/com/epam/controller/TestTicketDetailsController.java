package com.epam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.TicketsDetails;
import com.epam.services.RestClientService;

@WithMockUser("shivamsharma.js@gmail.com")
@SpringBootTest
@AutoConfigureMockMvc
class TestTicketDetailsController {

	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private TicketsDetails ticketDetails;
	@MockBean
	private RestClientService service;

	@Test
	public void testTicketController() throws Exception {
		Principal principal = new Principal() {

			@Override
			public String getName() {
				return "shivamsharma.js@gmail.com";
			}
		};
		ticketDetails.setBookingId(100);
		ticketDetails.setFullName("shivam");
		ticketDetails.setMovieName("war");
		ticketDetails.setPhone("9691061996");
		ticketDetails.setSeatId("A1 B1 C2");
		ticketDetails.setShowDate(LocalDate.now().toString());
		ticketDetails.setShowTiming("10:22");
		ticketDetails.setTicketBooked(3);
		ticketDetails.setTotalCost(1087);

		when(service.getTicketDetails()).thenReturn(ticketDetails);
		mockmvc.perform(get("/tickets?bookingStatus=true").principal(principal)).andExpect(status().isOk())
				.andExpect(model().attribute("tickets", ticketDetails)).andExpect((forwardedUrl("ticket.jsp")));
	}

}
