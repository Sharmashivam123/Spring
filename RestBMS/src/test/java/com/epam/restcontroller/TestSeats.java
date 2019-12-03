package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestSeats {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8083//rstseats/silver";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> seats = new ArrayList<>();
		seats.add("A1");
		seats.add("A2");
		List<String> jsonSeats = jsonPath.get("seatId");
		assertEquals(jsonSeats.get(0),seats.get(0));
	}

}
