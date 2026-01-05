package week3.day2;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

public class RetrieveAllRecordsFromIncidentTable {

	public static void main(String[] args) {
		RestAssured.given()
		           .log().all() // Request Log will print in the console
		           .baseUri("https://dev324941.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "e5!pRsPN%lH5")
		           .when()
		           .get("/incident")
		           .then()
		           //.log().all() // Response Log will print in the console
		           .log().ifValidationFails(LogDetail.ALL) // Response Log will print only at the time of assertion exception
		           .assertThat()
		           .statusCode(201);
		           
	}

}