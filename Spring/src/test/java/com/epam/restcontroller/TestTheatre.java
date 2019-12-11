package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TestTheatre {

	@Test
	void test() {
		int i = 0;
		RestAssured.baseURI = "http://localhost:8080/rest/rsttheatre/1";
		RequestSpecification reqspecs = RestAssured.given();
		Response response = reqspecs.get();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		JsonPath jsonPath = response.jsonPath();
		List<String> theatreList = new ArrayList<>();
		theatreList.add("pvr cyberabad");
		theatreList.add("PVR Galleria Mall");
		theatreList.add("BR Hitech Theatre");
		theatreList.add("PVR Inorbit Mall");
		List<String> jsonList = jsonPath.getList("theatreName");
		for (String str : jsonList) {
			assertEquals(str, theatreList.get(i++));
		}
	}

}
