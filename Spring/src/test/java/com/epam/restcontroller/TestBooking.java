package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestBooking {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8080/rstbooking";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.post();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "text");
		JsonPath jsonPath = response.jsonPath();
		assertEquals(true, jsonPath.get());
	}

}
