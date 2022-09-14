package com.Automation.StepsDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class Get_Steps {
	String baseURL;
	String endpoint;
	
	@Given("User give the base uri {string}")
	public void user_give_the_base_uri(String uri) {
	    baseURL= uri;
	}
	
	@When("user give the endpoint {string}")
	public void user_give_the_endpoint(String ep) {
	    endpoint=ep;
	}
	
	@Then("Get the information according to the endpoint")
	public void get_the_information_according_to_the_endpoint() {
	    
		RestAssured.given().baseUri(baseURL).when().log().all()
		.get(endpoint).then().log().all().assertThat().statusCode(200);
	}
	
	
}
