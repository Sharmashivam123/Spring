package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestSeats {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8080/rest/rstseats/silver";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.request(Method.GET);
		assertEquals(200, response.getStatusCode());
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> seats = new ArrayList<>();
		seats.add("A01");
		seats.add("A02");
		List<String> jsonSeats = jsonPath.get("seatId");
		assertEquals(jsonSeats.get(0),seats.get(0));
	}

}
