package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.bean.TicketsDetails;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestTicket {

	@Autowired
	TicketsDetails ticketDetails;

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8080/rest/rsttickets";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(200,response.getStatusCode());
		assertEquals("application/json", response.getContentType());
		JsonPath jsonPath = response.jsonPath();
		String jsonName = jsonPath.getString("phone");
		String phone = "8446274825";
		assertEquals(phone.getClass(), jsonName.getClass());
	}

}
