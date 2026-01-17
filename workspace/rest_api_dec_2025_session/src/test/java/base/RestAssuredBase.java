package base;

import static io.restassured.RestAssured.given;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class RestAssuredBase {
	
	public Response get(RequestSpecBuilder requestSpecBuilder, String endPoint) {
		return given().spec(requestSpecBuilder.build()).filter(new AllureRestAssured()).get(endPoint);
	}
	
	public Response post(RequestSpecBuilder requestSpecBuilder, String endPoint, Object requestPayload) {
		return given().spec(requestSpecBuilder.build()).filter(new AllureRestAssured()).body(requestPayload).post(endPoint);
	}
	
	public Response put(RequestSpecBuilder requestSpecBuilder, String endPoint, Object requestPayload) {
		return given().spec(requestSpecBuilder.build()).filter(new AllureRestAssured()).body(requestPayload).put(endPoint);
	}
	
	public Response patch(RequestSpecBuilder requestSpecBuilder, String endPoint, Object requestPayload) {
		return given().spec(requestSpecBuilder.build()).filter(new AllureRestAssured()).body(requestPayload).patch(endPoint);
	}
	
	public Response delete(RequestSpecBuilder requestSpecBuilder, String endPoint) {
		return given().spec(requestSpecBuilder.build()).filter(new AllureRestAssured()).delete(endPoint);
	}

}