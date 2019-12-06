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
		RestAssured.baseURI = "http://localhost:8080/rsttickets";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		String phone = ticketDetails.getPhone();
		String jsonName = jsonPath.getString("phone");
		assertEquals(phone, jsonName);
	}

}
