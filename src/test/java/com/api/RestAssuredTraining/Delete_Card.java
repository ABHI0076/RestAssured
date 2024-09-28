package com.api.RestAssuredTraining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Delete_Card extends BaseTest {

	@Test(priority = 4)
	public void delete_Card() {
		System.out.println("Thread : "+Thread.currentThread().getId());
		// Assign Author and test category to the test.
		test.assignAuthor("Abhishek Anand");
		test.assignCategory("Regression");
		
		// Send DELETE request to delete the resource.
		Response res = given().spec(reqSpec).pathParam("id", card_Id).when().delete("1/cards/{id}").then().assertThat()
				.statusCode(200).extract().response();
		
		// validate the response and log the result.
		if (res.getStatusCode() == 200) {
			test.log(Status.PASS, " Status code <b>" + res.getStatusCode() + "</b> is verified.");
		} else {
			test.log(Status.FAIL,
					" Status code expected is <b>200</b> but found <b>" + res.getStatusCode() + "</b>");
		}
		test.log(Status.PASS, "Card ID: <b>" + card_Id + "</b> is deleted Successfully.");
		logger.info("Card ID " + card_Id + " is deleted successfully");

	}
	
	// Negative Scenario.
	@Test(priority = 5)
	public void delete_Same_Card_Again() {
		
		// Assign Author and test category to the test.
		test.assignAuthor("Abhishek Anand");
		test.assignCategory("Smoke");

		// Send DELETE request to delete the same card again.
		Response res = given().spec(reqSpec).pathParam("id", card_Id).when().delete("1/cards/{id}").then().assertThat()
				.statusCode(404).extract().response();
		
		// validate the response and log the result.
		if (res.getStatusCode() == 404) {
			test.log(Status.PASS, " Status code <b>" + res.getStatusCode() + " </b>is verified.");
		} else {
			test.log(Status.FAIL,
					" Status code expected is <b>404</b> but found <b>" + res.getStatusCode() + "</b>");
		}
		
		test.log(Status.PASS, "Card ID " + card_Id + " is is not found at the server.");
		logger.info("Card ID <b>" + card_Id + "</b> is is not found at the server.");

	}

}
