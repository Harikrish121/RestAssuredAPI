package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import methods.MethodsDef;
import pojo.ExistingUserLoginResponse;
import reusableMethods.Utils;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

public class UserLogin extends Utils {

	RequestSpecification request;
	ResponseSpecification response;
	Response sendRequest;
	MethodsDef mDef;
	Utils method;
	ExistingUserLoginResponse res;

	@Given("user logsIn with username as {string} and userpassword as {string}")
	public void user_logs_in_with_username_as_and_userpassword_as(String userEmail, String userPassword)
			throws IOException {
		mDef = new MethodsDef();
		request = given().spec(requestSpecificationWithoutAuth()).body(MethodsDef.updateUser(userEmail, userPassword));
	}

	@Given("user hits the request as {string} with {string} httprequest")
	public void user_hits_the_request_as_with_httprequest(String apiResource, String httpRequest) {
		response = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		sendRequest = sendRequest(request, apiResource, httpRequest);
		res = sendRequest.then().log().all().extract().as(ExistingUserLoginResponse.class);
	}

	@Then("after that user should get the status code of {int}")
	public void after_that_user_should_get_the_status_code_of(Integer expected) {
		int statusCode = sendRequest.getStatusCode();
		Assert.assertEquals(statusCode, expected.intValue());
		String userId = res.getUserId();
		String userToken = res.getToken();
		System.out.println(userId);
		System.out.println(userToken);

	}
}
