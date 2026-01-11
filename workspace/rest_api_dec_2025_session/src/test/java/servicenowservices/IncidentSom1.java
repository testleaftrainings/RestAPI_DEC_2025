package servicenowservices;

import org.hamcrest.Matchers;

import base.RestAssuredBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentSom1 {
	
	private Response response;
	private RestAssuredBase base = new RestAssuredBase();
	
	public void getAllRecords(RequestSpecBuilder requestSpecBuilder, String endpoint) {
		response = base.get(requestSpecBuilder, endpoint);
	}
	
	public void getARecord(RequestSpecBuilder requestSpecBuilder, String endpoint, String sysId) {
		response = base.get(requestSpecBuilder, endpoint+"/"+sysId);
	}
	
	public void createIncident(RequestSpecBuilder requestSpecBuilder, String endpoint, Object requestPayload) {
		response = base.post(requestSpecBuilder, endpoint, requestPayload);
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