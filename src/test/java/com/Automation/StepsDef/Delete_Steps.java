package com.Automation.StepsDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class Delete_Steps {
	String baseURL="https://dummy.restapiexample.com";
	String ep;
	
	@Given("User will give the ep {string} which has to be deleted")
	public void user_will_give_the_ep_which_has_to_be_deleted(String string) {
	    ep=string;
	}
	
	@Then("Delete the details")
	public void delete_the_activity() {
		RestAssured.given().baseUri(baseURL).when().log().all()
		.delete(ep).then().log().all().assertThat().statusCode(200);
	}
}
