package week3.day2;

import static io.restassured.RestAssured.*;

public class SetThePathVariableInRestAssured {

	public static void main(String[] args) {
		given()
		.baseUri("https://dev324941.service-now.com")
		.basePath("/api/now/table")
		.auth()
		.basic("admin", "e5!pRsPN%lH5")
		.pathParam("tableName", "incident") // Set the path variable
		.log().all()
	    .when()
	    .get("/{tableName}") // call the path variable
	    .then()
	    .assertThat()
	    .statusCode(200);
	}

}