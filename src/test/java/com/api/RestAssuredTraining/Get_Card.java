package com.api.RestAssuredTraining;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import payloads.Card_Payload;

public class Get_Card extends BaseTest{
	
	@Test(priority = 2)
	public void get_Card() {
		
		System.out.println("Thread : "+Thread.currentThread().getId());
		// Assign Author and test category to the test.
		test.assignAuthor("Abhishek Anand");
		test.assignCategory("Regression");
		
		String name = getProperties().getProperty("name");
		String desc = getProperties().getProperty("desc");
		
		System.out.println("Card ID is :" + card_Id);
		
		// Send Get Request.
		Card_Payload res = given().spec(reqSpec).pathParam("id", card_Id).when().get("1/cards/{id}").then().assertThat()
				.statusCode(200).extract().response().as(Card_Payload.class);
		
		// Verify response body and log results in the extent report.
		test.log(Status.PASS," Card is fetched and Status code <b>200</b> is verified Successfully");
		logger.info("Status Code 200 is verified");
		Assert.assertEquals(res.getName(), name);
		test.log(Status.PASS, "Card Name: <b>" + res.getName() + "</b> is verified Successfully.");
		logger.info("Card name is verified: " + res.getName());
		Assert.assertEquals(res.getDesc(), desc);
		test.log(Status.PASS, "Card Description: <b>" + res.getDesc() + "</b> is verified Successfully.");
		logger.info("Card Description is verified: " + res.getDesc());
		Assert.assertEquals(res.getId(), card_Id);
		test.log(Status.PASS, "Card ID: <b>" + res.getId() + "</b> is verified Successfully.");


	}

}
