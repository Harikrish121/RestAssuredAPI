package reusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resource.API_Resource;

public class Utils {

	public static RequestSpecification request;
	public static PrintStream log;

	// Method to initialize logging and return a PrintStream in append mode
	public static void initializeLogger() throws FileNotFoundException {
		if (log == null) {
			log = new PrintStream(new FileOutputStream("log.properties", true)); // Open in append mode
		}
	}

	// Method for requests without authorization (for login)
	public static RequestSpecification requestSpecificationWithoutAuth() throws IOException {
		initializeLogger();

		if (request == null) {
			// Build request spec without the authorization header
			request = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseuri"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		}
		return request;
	}

	// Method for requests with authorization (for adding product)
	public static RequestSpecification requestSpecificationWithAuth(String userToken) throws IOException {
		initializeLogger();

		if (request == null) {
			// Build request spec with the authorization header
			request = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseuri"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).addHeader("authorization", userToken)
					.setContentType(ContentType.JSON).build();
		} else {
			// Add authorization header to existing request if needed
			request = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseuri"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).addHeader("authorization", userToken)
					.setContentType(ContentType.JSON).build();
		}
		return request;
	}

	public static String getJsonResponse(Response response, String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();
	}
	
	public static String getGlobalProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("./src//test//java//properties//global.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
	
	public static  Response sendRequest(RequestSpecification request, String apiResource, String apiRequest) {
		Response response = null;
		API_Resource valueOf = API_Resource.valueOf(apiResource);
		if (apiRequest.equalsIgnoreCase("post")) {
			response = request.when().post(valueOf.getResource());
		} else if (apiRequest.equalsIgnoreCase("get")) {
			response = request.when().get(valueOf.getResource());
		} else if (apiRequest.equalsIgnoreCase("delete")) {
			response = request.when().delete(valueOf.getResource());
		} else {
			throw new IllegalArgumentException("Invalid API request type :" + apiRequest);
		}

		return response;

	}
}
