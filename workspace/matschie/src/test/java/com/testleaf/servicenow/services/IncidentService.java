package com.testleaf.servicenow.services;

import org.hamcrest.Matchers;

import com.testleaf.matchie.rest.assured.api.client.RestAssuredApiClient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentService {
	
	private RestAssuredApiClient apiClient = new RestAssuredApiClient();
	private Response response;
	
	public void getAllRecords(RequestSpecBuilder requestSpecBuilder, String endpoint) {
		response = apiClient.get(requestSpecBuilder, endpoint);
	}
	
	public void validateResponse(int statusCode, String statusLine, String responseFormat) {
		response.then().assertThat().statusCode(statusCode);
		response.then().statusLine(Matchers.containsString(statusLine));
		if (responseFormat.equalsIgnoreCase("JSON")) {
			response.then().contentType(ContentType.JSON);
		} else if (responseFormat.equalsIgnoreCase("XML")) {
			response.then().contentType(ContentType.XML);
		}
	}

}