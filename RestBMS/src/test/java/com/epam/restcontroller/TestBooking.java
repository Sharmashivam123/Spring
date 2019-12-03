package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestBooking {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8083/rstbooking";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "text");
		JsonPath jsonPath = response.jsonPath();
		assertEquals(true, jsonPath.get());
	}

}
