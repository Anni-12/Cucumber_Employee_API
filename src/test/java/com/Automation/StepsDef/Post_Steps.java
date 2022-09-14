package com.Automation.StepsDef;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class Post_Steps {
	String baseURL;
	String endpoint;
	String name;
	
	@Given("User will give the base uri {string} and endpoint {string}")
	public void user_will_give_the_base_uri_and_endpoint(String uri, String ep) {
	    baseURL=uri;
	    endpoint=ep;
	}
	
	@When("User will give the file {string}")
	public void user_will_give_the_file(String string) {
	   name=string;
	}
	
	@Then("Post the employee data")
	public void post_the_employee_data() throws FileNotFoundException {
		RestAssured.given().baseUri(baseURL)
		.body(getFileContent("C:\\Users\\aniket.1\\eclipse-workspace\\Cucumber_Employee_API\\src\\test\\resources\\Data\\"+name))
		.header("Content-Type","application/json")
		.when().log().all().post(endpoint).then().log().all().statusCode(anyOf(is(200),is(201)));
	}
	
	public static String getFileContent(String filepath) throws FileNotFoundException
	{
		File file= new File(filepath);
		Scanner sc=new Scanner(file);
		sc.useDelimiter("\\Z");
		return sc.next();
	}
}
