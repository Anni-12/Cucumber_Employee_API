package com.Automation.StepsDef;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class Patch_Steps {
	
	String baseURL="https://dummy.restapiexample.com";
	String ep="/api/v1/update/";
	String file;
	String id;
	@Given("The user will provide the id {string}")
	public void the_user_will_provide_the_id(String string) {
		id= string;
		
	}

	@When("User will provide the file {string}")
	public void user_will_provide_the_file(String string) {
	    file=string;
	}

	@Then("Do the partial changes in the particular id")
	public void do_the_partial_changes_in_the_particular_id() throws FileNotFoundException {
		RestAssured.given().baseUri(baseURL)
		.body(getFileContent("C:\\Users\\aniket.1\\eclipse-workspace\\Cucumber_Employee_API\\src\\test\\resources\\Data\\"+file))
		.header("Content-Type","application/json")
		.when().log().all().post(ep+id).then().log().all().statusCode(anyOf(is(200),is(201)));
	}
	public static String getFileContent(String filepath) throws FileNotFoundException
	{
		File file= new File(filepath);
		Scanner sc=new Scanner(file);
		sc.useDelimiter("\\Z");
		return sc.next();
	}
}
