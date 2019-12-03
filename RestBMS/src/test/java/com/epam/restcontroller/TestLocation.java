package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestLocation {

	@Test
	void test() {
		int i = 0;
		RestAssured.baseURI = "http://localhost:8083/rstlocation?location=2";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<Integer> areaList = new ArrayList<>(Arrays.asList(500081, 500082, 500083, 500084, 500085));
		List<Integer> jsonLocation = jsonPath.getList("pin");
		for (Integer str : jsonLocation) {
			assertEquals(str, areaList.get(i++));
		}
	}

}
