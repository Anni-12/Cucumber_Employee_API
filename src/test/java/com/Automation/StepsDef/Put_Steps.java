package com.Automation.StepsDef;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class Put_Steps {
	
	String baseURL="https://dummy.restapiexample.com";
	String endpoint="/api/v1/update/";
	String id;
	String file;
	
	@Given("User will provide the id {string} and the updated file {string}")
	public void user_will_provide_the_id_and_the_updated_file(String string, String string2) {
	    id=string;
	    file= string2;
	}
	
	@Then("Update the employee details according to the id")
	public void update_the_employee_details_according_to_the_id() throws FileNotFoundException {
	    
		RestAssured.given().baseUri(baseURL)
		.body(getFileContent("C:\\Users\\aniket.1\\eclipse-workspace\\Cucumber_Employee_API\\src\\test\\resources\\Data\\"+file))
		.header("Content-Type","application/json")
		.when().log().all().put(endpoint+id).then().log().all().statusCode(anyOf(is(200),is(201)));
	}
	
	public static String getFileContent(String filepath) throws FileNotFoundException
	{
		File file= new File(filepath);
		Scanner sc=new Scanner(file);
		sc.useDelimiter("\\Z");
		return sc.next();
	}
	
}
