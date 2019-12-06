package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestMovie {

	@Test
	void test() {
		int i = 0;
		RestAssured.baseURI = "http://localhost:8080/rstmovie";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> movieList = new ArrayList<>();
		movieList.add("war");
		movieList.add("joker");
		movieList.add("housefull4");
		movieList.add("terminator");
		List<String> jsonList = jsonPath.getList("movieName");
		for (String str : jsonList) {
			assertEquals(str, movieList.get(i++));
		}
	}

}
