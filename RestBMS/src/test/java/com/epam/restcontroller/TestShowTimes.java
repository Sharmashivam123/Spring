package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

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
		int i = 0;
		RestAssured.baseURI = "http://localhost:8083/rsttiming12";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> showTime = new ArrayList<>();
		showTime.add("10:00");
		showTime.add("13:00");
		showTime.add("18:00");
		showTime.add("22:00");
		List<String> jsonTime = jsonPath.get();
		for (String str : showTime)
			assertEquals(str, jsonTime.get(i++));
	}

}
