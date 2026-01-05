package week3.day2;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class CreateNewRecordInIncidentTablePayloadAsFile {

	public static void main(String[] args) {
		
		File request_payload = new File("src/main/resources/request_payload/create_incident.json");
		
		String sys_id = given()
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
		 .statusCode(201)
		 .contentType(ContentType.JSON)
		 .body("result.short_description", Matchers.equalTo("RESTAPISESSIONDEC2025"))
		 .extract()
		 .jsonPath()
		 .getString("result.sys_id");
		
		System.out.println(sys_id);
	}

}