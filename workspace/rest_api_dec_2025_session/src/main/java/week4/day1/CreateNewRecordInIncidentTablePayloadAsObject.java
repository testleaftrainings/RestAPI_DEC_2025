package week4.day1;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class CreateNewRecordInIncidentTablePayloadAsObject {

	public static void main(String[] args) {
		
		CreateIncidentPojo incident = new CreateIncidentPojo();
		incident.setShortDescription("Post request via Postman");
		//incident.setDesc("Create new record for the software catgory");
		//incident.setFirstName("Karthi");
		
		given()
		  .baseUri("https://dev324941.service-now.com")
		  .basePath("/api/now/table")
		  .auth()
		  .basic("admin", "e5!pRsPN%lH5")
		  .pathParam("tableName", "incident")
		  .contentType(ContentType.JSON)
		  .log().all()
	   .when()
	      .body(incident)
	      .post("/{tableName}")
	   .then()
	      .assertThat()
	      .statusCode(201);
	}

}