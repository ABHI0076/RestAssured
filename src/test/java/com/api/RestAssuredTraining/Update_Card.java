package com.api.RestAssuredTraining;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import payloads.Card_Payload;

public class Update_Card extends BaseTest {
	
	@Test(priority = 3)
	public void update_Card() {
		
		System.out.println("Thread : "+Thread.currentThread().getId());
		// Assign Author and test category to the test.
		test.assignAuthor("Abhishek Anand");
		test.assignCategory("Regression");

		String nameUpdate = getProperties().getProperty("nameUpdate");
		String descUpdate = getProperties().getProperty("descUpdate");
		
		// Send PUT request to update the resource.
		Card_Payload payload = new Card_Payload(nameUpdate, descUpdate);
		Card_Payload res = given().spec(reqSpec).pathParam("id", card_Id).body(payload).when().put("1/cards/{id}")
				.then().assertThat().statusCode(200).extract().response().as(Card_Payload.class);
		
		// Verify response body and log results in the extent report.
		test.log(Status.PASS," Card is updated and Status code <b>200</b> is verified.");
		logger.info("Card is updated and Status Code 200 is verified");
		Assert.assertEquals(res.getName(), nameUpdate);
		test.log(Status.PASS, "Updated card Name: <b>" + res.getName() + "</b> is verified Successfully.");
		logger.info("Updated Card name is verified: " + res.getName());
		Assert.assertEquals(res.getDesc(), descUpdate);
		test.log(Status.PASS, "Updated Card Description: <b>" + res.getDesc() + "</b> is verified Successfully.");
		logger.info("Updated Card Description is verified: " + res.getDesc());
		Assert.assertEquals(res.getId(), card_Id);
		test.log(Status.PASS, "Card ID: <b>" + res.getId() + "</b> is verified Successfully.");


	}

}
