package stepDefinitions;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import methods.AddProduct_Details;
import methods.DataRead_Properties;
import pojo.AddProductResponse;
import pojo.CreateOrder_Response;
import pojo.DeleteOrderResponse;
import pojo.ExistingUserLogin;
import pojo.ExistingUserLoginResponse;
import reusableMethods.Utils;

public class Cart_Functionality extends Utils {

	RequestSpecification request;
	Response response;

	ExistingUserLoginResponse userResponse;
	AddProductResponse addProductResponse;
	AddProduct_Details details;
	CreateOrder_Response createOrderResponse;
	DeleteOrderResponse deleteResponse;

	@Given("user logwith {string} and {string}")
	public void user_logwith_and(String username, String password) throws IOException {
		ExistingUserLogin userCred = new ExistingUserLogin();
		userCred.setUserEmail(username);
		userCred.setUserPassword(password);
		request = given().spec(requestSpecificationWithoutAuth()).body(userCred);
	}

	@And("user request {string} along with {string} httprequest")
	public void user_request_along_with_httprequest(String apiResource, String httpRequest) {
		response = sendRequest(request, apiResource, httpRequest);
		userResponse = response.then().log().all().extract().as(ExistingUserLoginResponse.class);

	}

	@Given("user adds a product by providing authorization with {string} with {string} httprequest")
	public void user_adds_a_product_by_providing_authorization_with_with_httprequest(String apiResource,
			String httpRequest) throws IOException {

		details = new AddProduct_Details();
		request = given().spec(requestSpecificationWithAuth(userResponse.getToken()))
				.body(details.prod_Details(userResponse.getUserId()));
		response = sendRequest(request, apiResource, httpRequest);
		addProductResponse = response.then().log().all().extract().as(AddProductResponse.class);

	}

	@Then("user should get a message as {string} with the status code {int}")
	public void user_should_get_a_message_as_with_the_status_code(String expectedMessage, Integer statuscode) {
		int actualStatus = response.getStatusCode();
		String actualMessage = addProductResponse.getMessage();
		Assert.assertEquals(statuscode.intValue(), actualStatus);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Then("user checkout the product from cart by providing country as {string} with {string} with {string} httprequest")
	public void user_checkout_the_product_from_cart_by_providing_country_as_with_with_httprequest(String country,
			String apiResource, String httpRequest) throws IOException {
		DataRead_Properties prop = new DataRead_Properties();
		request = given().spec(requestSpecificationWithAuth(userResponse.getToken()))
				.body(details.orders(country, prop.get_id()));
		response = sendRequest(request, apiResource, httpRequest);
		createOrderResponse = response.then().log().all().extract().as(CreateOrder_Response.class);
		List<String> orders = createOrderResponse.getOrders();
		String string = orders.get(0);
		

	}

	@Then("after creating user should get a message as {string}")
	public void after_creating_user_should_get_a_message_as(String expectedMessage) {
		Assert.assertEquals(createOrderResponse.getMessage(), expectedMessage);
	}

	@When("user calls this {string} resource with {string} request")
	public void user_calls_this_resource_with_request(String apiResource, String httpRequest) throws IOException {

		request = given().spec(requestSpecificationWithAuth(userResponse.getToken())).pathParam("productId",
				createOrderResponse.getOrders().get(0));
		response = sendRequest(request, apiResource, httpRequest);
	 deleteResponse = response.then().log().all().extract().as(DeleteOrderResponse.class);
	}

	@Then("user should get a message as {string}")
	public void user_should_get_a_message_as(String expectedMessage) {
    Assert.assertEquals(deleteResponse.getMessage(), expectedMessage);
	}
}
