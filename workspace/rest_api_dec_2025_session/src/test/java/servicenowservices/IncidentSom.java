package servicenowservices;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentSom {
	
	private Response response;
	
	public void getAllRecords(RequestSpecBuilder requestSpecBuilder, String endpoint) {
		response = given().spec(requestSpecBuilder.build()).get(endpoint); 
	}
	
	public void getARecord(RequestSpecBuilder requestSpecBuilder, String endpoint, String sysId) {
		response = given().spec(requestSpecBuilder.build()).get(endpoint+"/"+sysId);
	}
	
	public void createIncident(RequestSpecBuilder requestSpecBuilder, String endpoint, Object requestPayload) {
		response = given().spec(requestSpecBuilder.build()).body(requestPayload).post(endpoint);
	}
	
	public void validateSuccessResponse(int statusCode, String statusLine, String responseFormat) {
		response.then().assertThat().statusCode(statusCode);
		response.then().statusLine(Matchers.containsString(statusLine));
		if (responseFormat.equalsIgnoreCase("JSON")) {
			response.then().contentType(ContentType.JSON);
		} else if (responseFormat.equalsIgnoreCase("XML")) {
			response.then().contentType(ContentType.XML);
		}
	}

}