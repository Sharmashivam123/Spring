package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.bean.Location;
import com.epam.services.RestClientService;

@WithMockUser("Spring")
@SpringBootTest
@AutoConfigureMockMvc
public class TestLocationController {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private RestClientService service;

	@Test
	public void testLocation() throws Exception {
		doNothing().when(bookingDetails).setCityId(1);
		Location area1 = new Location();
		area1.setPin(500081);
		area1.setAreaName("Gachibowli");

		Location area2 = new Location();
		area2.setPin(500082);
		area2.setAreaName("Madhapur");

		Location area3 = new Location();
		area3.setPin(500083);
		area3.setAreaName("Raidurgam");

		Location area4 = new Location();
		area4.setPin(500084);
		area4.setAreaName("Kukatpally");

		Location area5 = new Location();
		area5.setPin(500085);
		area5.setAreaName("Ameerpet");
		List<Location> areaList = new ArrayList<>(Arrays.asList(area1, area2, area3, area4, area5));

		when(service.getAreaPincodeByCity(1)).thenReturn(areaList);
		mockmvc.perform(get("/location?city=1")).andExpect(status().isOk())
				.andExpect(model().attribute("locations", areaList)).andExpect((forwardedUrl("location.jsp")));
	}

}
