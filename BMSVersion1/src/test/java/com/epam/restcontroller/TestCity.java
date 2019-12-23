package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestCity {

	@Test
	void test() {

		int i = 0;
		RestAssured.baseURI = "http://localhost:8080/rest/rstcity";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(200,response.getStatusCode());
		assertEquals("application/json",response.getContentType());
		JsonPath jsonPath = response.jsonPath();
		List<String> city = new ArrayList<>();
		city.add("Hyderabad");
		List<String> jsonCity = jsonPath.getList("cityName");
		for (String str : jsonCity) {
			assertEquals(str, city.get(i++));
		}
	}

}
