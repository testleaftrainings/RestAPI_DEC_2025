package com.testleaf.matschie.step.definitions;

import java.util.List;
import java.util.Map;

import com.testleaf.servicenow.services.IncidentService;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class IncientServiceSteps {
	
	private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	private IncidentService incidentService = new IncidentService();

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
	public void user_set_the_path_parameter_key_as_and_value_as(String key, String value) {
		requestSpecBuilder.addPathParam(key, value);
	}

	@When("user hits the get request using restassured client library with path variable {string}")
	public void user_hits_the_get_request_using_restassured_client_library_with_path_variable(String endpoint) {
		incidentService.getAllRecords(requestSpecBuilder, endpoint);
	}

	@Then("user should able to see success response with below expected values")
	public void user_should_able_to_see_success_response_with_below_expected_values(DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		for (Map<String, String> map : asMaps) {
			incidentService.validateResponse(Integer.parseInt(map.get("statusCode")), map.get("statusLine"),
					map.get("responseFormat"));
		}
	}

}