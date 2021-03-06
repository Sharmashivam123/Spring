package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestShowTimes {

	@Test
	void test() {
		RestAssured.baseURI = "http://localhost:8080/rest/rsttiming12/1/1/" + LocalDate.now();
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(200, response.getStatusCode());
		assertEquals("application/json", response.getContentType());
		JsonPath jsonPath = response.jsonPath();
		List<String> showTime = new ArrayList<>();
		showTime.add("10:00");
		showTime.add("13:00");
		showTime.add("18:00");
		showTime.add("22:00");
		List<String> jsonTime = jsonPath.get();
		assertEquals(jsonTime.get(jsonTime.size() - 1), showTime.get(3));
	}

}
