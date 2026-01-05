package week3.day2;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.hamcrest.Matchers;

public class RetrieveAllHardwareCategoryRecordsFromIncidentTable {

	public static void main(String[] args) {
		given()
		.baseUri("https://dev324941.service-now.com")
		.basePath("/api/now/table")
		.auth()
		.basic("admin", "e5!pRsPN%lH5")
		.pathParam("tableName", "incident")
		.queryParam("category", "hardware")
		.queryParam("sysparm_fields", "sys_id,number,short_description,description,category")
		.log().all()
		.when()
		.get("/{tableName}")
		.then()
		.assertThat()
		.statusCode(200)
		.body("result", Matchers.isA(ArrayList.class))
		.body("result", Matchers.hasSize(207))		
		.body("result", Matchers.everyItem(Matchers.hasKey("sys_id")))
		.body("result", Matchers.everyItem(Matchers.hasKey("number")))
		.body("result", Matchers.everyItem(Matchers.hasKey("short_description")))
		.body("result", Matchers.everyItem(Matchers.hasKey("description")))
		.body("result", Matchers.everyItem(Matchers.hasKey("category")))
		.body("result.category", Matchers.everyItem(Matchers.equalToIgnoringCase("hardware")));
	}

}