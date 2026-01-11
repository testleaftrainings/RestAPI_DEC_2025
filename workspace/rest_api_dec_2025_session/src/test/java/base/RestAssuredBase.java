package base;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class RestAssuredBase {
	
	public Response get(RequestSpecBuilder requestSpecBuilder, String endPoint) {
		return given().spec(requestSpecBuilder.build()).get(endPoint);
	}
	
	public Response post(RequestSpecBuilder requestSpecBuilder, String endPoint, Object requestPayload) {
		return given().spec(requestSpecBuilder.build()).body(requestPayload).post(endPoint);
	}
	
	public Response put(RequestSpecBuilder requestSpecBuilder, String endPoint, Object requestPayload) {
		return given().spec(requestSpecBuilder.build()).body(requestPayload).put(endPoint);
	}
	
	public Response patch(RequestSpecBuilder requestSpecBuilder, String endPoint, Object requestPayload) {
		return given().spec(requestSpecBuilder.build()).body(requestPayload).patch(endPoint);
	}
	
	public Response delete(RequestSpecBuilder requestSpecBuilder, String endPoint) {
		return given().spec(requestSpecBuilder.build()).delete(endPoint);
	}

}