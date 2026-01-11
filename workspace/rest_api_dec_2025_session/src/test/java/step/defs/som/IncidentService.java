package step.defs.som;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import servicenowservices.IncidentSom1;
import week4.day1.CreateIncidentPojo;

public class IncidentService {

	RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	CreateIncidentPojo incidentPojo = new CreateIncidentPojo();
	IncidentSom1 incidentSom = new IncidentSom1();

	@Given("user should able to set base uri as {string} for servicenow api")
	public void user_should_able_to_set_base_uri_as_for_servicenow_api(String baseUri) {
		requestSpecBuilder.setBaseUri(baseUri);
	}

	@Given("user should able to set base path as {string} for servicenow api")
	public void user_should_able_to_set_base_path_as_for_servicenow_api(String basePath) {
		requestSpecBuilder.setBasePath(basePath);
	}

	@Given("user should set basic authentication username as {string} and password as {string}")
	public void user_should_set_basic_authentication_username_as_and_password_as(String username, String password) {
		requestSpecBuilder.setAuth(RestAssured.basic(username, password));
	}

	@Given("user set the path parameter key as {string} and value as {string}")
	public void user_set_the_path_parameter_key_as_and_value_as(String variableName, String variableValue) {
		requestSpecBuilder.addPathParam(variableName, variableValue);
	}

	@When("user hits the get request using restassured client library with path variable {string}")
	public void user_hits_the_get_request_using_restassured_client_library_with_path_variable(String endpoint) {
		incidentSom.getAllRecords(requestSpecBuilder, endpoint);
	}	

	@Given("user set the header key as {string} and value as {string}")
	public void user_set_the_header_key_as_and_value_as(String key, String value) {
		requestSpecBuilder.addHeader(key, value);
	}

	@Given("user set the short description value as {string} in the request payload")
	public void user_set_the_short_description_value_as_in_the_request_payload(String shortDescription) {
	    incidentPojo.setShortDescription(shortDescription);
	}

	@When("user hits the post request using restassured client library with path variable {string}")
	public void user_hits_the_post_request_using_restassured_client_library_with_path_variable(String endpoint) {
		incidentSom.createIncident(requestSpecBuilder, endpoint, incidentPojo);
	}	
	
	@Then("user should able to see success response with below expected values")
	public void user_should_able_to_see_success_response_with_below_expected_values(DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		for (Map<String, String> map : asMaps) {
			incidentSom.validateSuccessResponse(Integer.parseInt(map.get("statusCode")), map.get("statusLine"),
					map.get("responseFormat"));
		}
	}


}