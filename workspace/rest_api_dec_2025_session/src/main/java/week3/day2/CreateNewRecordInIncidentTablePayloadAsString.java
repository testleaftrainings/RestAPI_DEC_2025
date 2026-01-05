package week3.day2;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class CreateNewRecordInIncidentTablePayloadAsString {

	public static void main(String[] args) {
		
		String request_payload = """
				{
                  "short_description": "RESTAPISESSIONNOV2025"
                }
				""";
		
		given()
		 .baseUri("https://dev324941.service-now.com")
		 .basePath("/api/now/table")
		 .auth()
		 .basic("admin", "e5!pRsPN%lH5")
		 .pathParam("tableName", "incident")
		 .contentType(ContentType.JSON)
		 .log().all()
		 .when()
		 .body(request_payload) // Request Payload
		 .post("/{tableName}")
		 .then()
		 .assertThat()
		 .statusCode(201);
	}

}