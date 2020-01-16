 package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestSeats {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8080/rest/rstseats/silver";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.request(Method.GET);
		assertEquals(200, response.getStatusCode());
		assertEquals("application/json", response.getContentType());
		String tier = "silver";
		assertEquals("silver", tier);
	}

}
