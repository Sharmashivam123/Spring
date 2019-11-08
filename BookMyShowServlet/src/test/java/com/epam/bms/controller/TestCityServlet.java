package com.epam.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bms.bean.City;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.Services;

class TestCityServlet {

	@InjectMocks
	CityServlet mock;
	
	@Mock
	DBOperation dBOperation;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testDoGet() throws Exception
	{
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response=Mockito.mock(HttpServletResponse.class);
		Services services = Mockito.mock(Services.class);
		 RequestDispatcher rd=Mockito.mock(RequestDispatcher.class);
			List<City> expectedCityList = new ArrayList<City>();
			City city = new City();
			city.setCityId(1);
			city.setCityName("Hyderabad");
			expectedCityList.add(city);
		Mockito.when(services.getAvailableCities()).thenReturn(expectedCityList);
		List<City> actualCityList = services.getAvailableCities();
		 Mockito.when(request.getRequestDispatcher("City.jsp")).thenReturn(rd);
		 mock.doGet(request, response);
		 assertEquals(expectedCityList,actualCityList);
		 request.setAttribute("cityList", expectedCityList);
		 Mockito.verify(request).setAttribute("cityList", expectedCityList);
		 Mockito.verify(rd).forward(request, response);
		 
	}

}
