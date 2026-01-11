Feature: Validating servicenow incident table apis CRUD operations

@smoke
Scenario: Validate user should able to fetch all incident table records in JSON format
Given user should able to set base uri as "https://dev324941.service-now.com" for servicenow api
And user should able to set base path as "/api/now/table" for servicenow api 
And user should set basic authentication username as "admin" and password as "e5!pRsPN%lH5"
And user set the path parameter key as "tableName" and value as "incident"
When user hits the get request using restassured client library with path variable "/{tableName}"
Then user should see status code as 200
And user should see status line as "OK"
And user should see response in the json format

@regression
Scenario: Validate user should able to fetch all incident table records in XML format
Given user should able to set base uri as "https://dev324941.service-now.com" for servicenow api
And user should able to set base path as "/api/now/table" for servicenow api 
And user should set basic authentication username as "admin" and password as "e5!pRsPN%lH5"
And user set the path parameter key as "tableName" and value as "incident"
And user set the header key as "Accept" and value as "application/xml"
When user hits the get request using restassured client library with path variable "/{tableName}"
Then user should see status code as 200
And user should see status line as "OK"
And user should see response in the xml format

@smoke @regression
Scenario: Validate usr should able to create new incident table record
Given user should able to set base uri as "https://dev324941.service-now.com" for servicenow api
And user should able to set base path as "/api/now/table" for servicenow api 
And user should set basic authentication username as "admin" and password as "e5!pRsPN%lH5"
And user set the path parameter key as "tableName" and value as "incident"
And user set the header key as "Content-Type" and value as "application/json"
And user set the short description value as "CucumberCode" in the request payload
When user hits the post request using restassured client library with path variable "/{tableName}"
Then user should see status code as 201
And user should see status line as "Created"
And user should see response in the json format