package week3.day2;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class RetrieveARecordFromIncidentTable {

	public static void main(String[] args) {
		given()
		.baseUri("https://dev324941.service-now.com")
		.basePath("/api/now/table")
		.auth()
		.basic("admin", "e5!pRsPN%lH5")
		.pathParam("tableName", "incident") // Set the path variable
		.pathParam("sys_id", "a3f86d2c83567210ac835c65eeaad3e1") 
		.log().all()
	    .when()
	    .get("/{tableName}/{sys_id}") // call the path variable
	    .then()
	    .assertThat()
	    .statusCode(200)
	    .statusLine(Matchers.containsString("OK"))
	    .contentType(ContentType.JSON)
        .time(Matchers.lessThanOrEqualTo(3000L))
        .body("result", Matchers.hasKey("short_description"))
        .body("result.short_description", Matchers.isA(String.class))
        .body("result.short_description", Matchers.is(Matchers.emptyString()));
	}

}
