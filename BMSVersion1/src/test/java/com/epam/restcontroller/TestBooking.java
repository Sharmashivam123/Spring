package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestBooking {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8080/rest/rstbooking";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.post();
		assertEquals(415, response.getStatusCode());
		assertEquals("", response.getContentType());
	}

}
