package com.api.RestAssuredTraining;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.Card_Payload;

public class Create_Card extends BaseTest {

	@Test(priority = 1)
	public void create_Card() {
		System.out.println("Thread : "+Thread.currentThread().getId());
		// Assign Author and test category to the test.
		test.assignAuthor("Abhishek Anand");
		test.assignCategory("Regression");
		
		String idList = getProperties().getProperty("idList");
		String name = getProperties().getProperty("name");
		String desc = getProperties().getProperty("desc");
		// Create payload using serialization.
		Card_Payload payload = new Card_Payload(idList, name, desc);

		// Send post request and store response using De-serialization.
		Card_Payload res = given().spec(reqSpec).body(payload).log().body().when().post("1/cards").then().assertThat()
				.statusCode(200).log().body().extract().response().as(Card_Payload.class);
		// Verify body and log the results in the extent report.
		test.log(Status.PASS, " Card is created and Status code <b>200</b> is verified Successfully");
		logger.info("Card is created Successfully.");
		logger.info("Status Code 200 is verified");
		Assert.assertEquals(res.getName(), name);
		test.log(Status.PASS, "Card Name: <b>" + res.getName() + "</b> is verified Successfully.");
		logger.info("Card name is verified: " + res.getName());
		Assert.assertEquals(res.getDesc(), desc);
		test.log(Status.PASS, "Card Description: <b>" + res.getDesc() + "</b> is verified Successfully.");
		logger.info("Card Description is verified: " + res.getDesc());
		// Store the card ID in a global variable.
		card_Id = res.getId();
		logger.info("Card ID " + card_Id + " is fetched successfully");
		test.log(Status.INFO, "Card ID: <b>" + card_Id + "</b> is fetched Successfully");

	}

}
