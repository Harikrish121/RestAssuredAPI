package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import methods.MethodsDef;
import pojo.NewUserResponce;
import reusableMethods.Utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

public class CreateNewUserFunct extends Utils {

	RequestSpecification request;
	ResponseSpecification response;
	Response sendRequest;
	MethodsDef user;
	NewUserResponce res;
	Utils method;

	@Given("add user payload with {string} {string} {string}  {string} {string} {string}")
	public void add_user_payload_with(String fname, String lname, String useremail, String userPassword,
			String confirmUserPass, String mobNum) throws IOException {
		user = new MethodsDef();
		request = given().spec(requestSpecificationWithoutAuth())
				.body(MethodsDef.newUser(fname, lname, useremail, userPassword, confirmUserPass, mobNum));
	}

	@When("user calls {string} with {string} httprequest")
	public void user_calls_with_httprequest(String apiResource, String httpMethod) {

		response = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		method = new Utils();
		sendRequest = method.sendRequest(request, apiResource, httpMethod);
		res = sendRequest.then().log().all().extract().as(NewUserResponce.class);
	}

	@Then("the api call is success with the statuscode {int}")
	public void the_api_call_is_success_with_the_statuscode(Integer expectedStatusCode) {
		int actualStatusCode = sendRequest.getStatusCode();
		Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
	}

	@Then("the response should be message and should equals to {string}")
	public void the_response_should_be_message_and_should_equals_to(String string) {
		String message = res.getMessage();
		System.out.println(message);
	}

}
