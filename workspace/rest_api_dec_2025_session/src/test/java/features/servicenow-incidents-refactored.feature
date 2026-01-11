Feature: Validating servicenow incident table apis CRUD operations

Background:
Given user should able to set base uri as "https://dev324941.service-now.com" for servicenow api
And user should able to set base path as "/api/now/table" for servicenow api 
And user should set basic authentication username as "admin" and password as "e5!pRsPN%lH5"
And user set the path parameter key as "tableName" and value as "incident"

@smoke
Scenario: Validate user should able to fetch all incident table records in JSON format
When user hits the get request using restassured client library with path variable "/{tableName}"
Then user should able to see success response with below expected values
| statusCode | statusLine | responseFormat |
| 200        | OK         | JSON           |

@regression
Scenario: Validate user should able to fetch all incident table records in XML format
Given user set the header key as "Accept" and value as "application/xml"
When user hits the get request using restassured client library with path variable "/{tableName}"
Then user should able to see success response with below expected values
| statusCode | statusLine | responseFormat |
| 200        | OK         | XML            |

@smoke @regression
Scenario Outline: Validate user should able to create new incident table record
Given user set the header key as "Content-Type" and value as "application/json"
And user set the short description value as "<shortDescription>" in the request payload
When user hits the post request using restassured client library with path variable "/{tableName}"
Then user should able to see success response with below expected values
| statusCode | statusLine | responseFormat |
| 201        | Created    | JSON           |

Examples:
| shortDescription |
| RESTAPIDEC2025   |
| CucumberSession  |
| Postman          |