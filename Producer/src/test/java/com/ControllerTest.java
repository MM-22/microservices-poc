package com;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Address;
import com.model.Customer;
import com.model.CustomerStatus;
import com.model.FailureResponse;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
public class ControllerTest {

	private final Logger LOG = LoggerFactory.getLogger(ControllerTest.class);

	private String token;

	@Test
	public void saveCustomerTest() {
		LOG.info("saveCustomerTest() - started");
		String payload2 = asJsonString(new Customer("C000000199", "MAHESHKUMAR", "MANCHALA", "05-07-1992", "INDIA",
				"IN", "9493971459", "maheshmanchala92@gmail.com", CustomerStatus.Open,
				new Address("1-25/1 SHEKALLA", "GOLLAPELLI", "TELANGANA", "50553")));
		
		Response resp = given()
				.header("Authorization", "Bearer " + token)
				.body(payload2)
				.when()
				.contentType(ContentType.JSON)
				.post("http://localhost:9001/api/customer");
		
		assertEquals(200, resp.getStatusCode());

		LOG.info("saveCustomerTest() - response type = " + resp.getStatusCode());
		LOG.info("saveCustomerTest() - completed");
	}

	@Test
	public void invalidTokenTest() {
		LOG.info("invalidTokenTest() - started");

		String payload2 = asJsonString(new Customer("C000000199", "MAHESHKUMAR", "MANCHALA", "05-07-1992", "INDIA",
				"IN", "9493971459", "maheshmanchala92@gmail.com", CustomerStatus.Open,
				new Address("1-25/1 SHEKALLA", "GOLLAPELLI", "TELANGANA", "50553")));
		
		Response resp = given()
				.header("Authorization", "Bearer " + token + "1")
				.body(payload2)
				.when()
				.contentType(ContentType.JSON)
				.post("http://localhost:9001/api/customer");

		assertEquals(401, resp.getStatusCode());

		LOG.info("invalidTokenTest() - response type = " + resp.getStatusCode());
		LOG.info("invalidTokenTest() - completed");
	}

	@Test
	public void invalidRequestBody() {

		LOG.info("invalidRequestBody() - started");
		String payload2 = asJsonString(new Customer("C00000011111199", "MAHESHKUMAR", "MANCHALA", "05-07-1992", "INDIA",
				"IN", "9493971459", "maheshmanchala92@gmail.com", CustomerStatus.Open,
				new Address("1-25/1 SHEKALLA", "GOLLAPELLI", "TELANGANA", "50553")));
		
		Response resp = given()
				.header("Authorization", "Bearer " + token)
				.body(payload2)
				.when()
				.contentType(ContentType.JSON)
				.post("http://localhost:9001/api/customer");
		
		assertEquals(400, resp.getStatusCode());
		LOG.info("invalidRequestBody() - response type = " + resp.getStatusCode());

		FailureResponse failureResponse = resp.getBody().as(FailureResponse.class);
		LOG.info("invalidRequestBody() - completed  resp = " + failureResponse);
	}

	@BeforeEach
	public void testOAuthWithPassword() throws JSONException {

		Response response = given()
				.auth()
				.preemptive()
				.basic("clientapp", "123456")
				.contentType("application/x-www-form-urlencoded")
				.log()
				.all()
				.formParam("grant_type", "password")
				.formParam("username", "test")
				.formParam("password", "password")
				.when()
				.post("http://localhost:9001/oauth/token");

		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		
		String accessToken = jsonObject.get("access_token").toString();
		String tokenType = jsonObject.get("token_type").toString();
		
		LOG.info("Oauth Token with type " + tokenType + "   " + accessToken);
		token = accessToken;
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
}
