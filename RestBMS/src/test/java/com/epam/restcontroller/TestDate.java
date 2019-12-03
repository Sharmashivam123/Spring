package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestDate {

	@Test
	void test() {
		int i = 0;
		RestAssured.baseURI = "http://localhost:8083/rstdate";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		String[] date = new String[3];
		date[0] = (LocalDate.now()).toString();
		date[1] = (LocalDate.now().plusDays(1)).toString();
		date[2] = (LocalDate.now().plusDays(2)).toString();
		List<String> jsonDate = jsonPath.get();
		for (String str : jsonDate) {
			assertEquals(str, date[i++]);
		}
	}

}
