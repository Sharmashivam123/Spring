package com.epam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.epam.bean.City;
import com.epam.services.RestClientService;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCityController {
	@Autowired
	private MockMvc mockmvc;

	@MockBean
	RestClientService service;

	@Test
	public void testCity() throws Exception {
		List<City> expectedCity = new ArrayList<>();
		City hyderabadCity = new City();
		hyderabadCity.setCityId(1);
		hyderabadCity.setCityName("Hyderabad");
		expectedCity.add(hyderabadCity);
		when(service.getAllCities()).thenReturn(expectedCity);
		mockmvc.perform(get("/city")).andExpect(status().isOk())
				.andExpect(model().attribute("cityList", expectedCity)).andExpect((forwardedUrl("city.jsp")));
	}
}
