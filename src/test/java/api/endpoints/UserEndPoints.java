package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.Customer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class UserEndPoints {
	
	public static Response createUser(Customer payload) {
		Response response=given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().post(Routes.post_url);
		return response;
	}
	
	public static Response getUser(String userName) {
		Response response=given().pathParam("username", userName)
		.when().get(Routes.get_url);
		return response;
	}
	

	public static Response updateUser(String userName,Customer payload) {
		Response response=given().pathParam("username", userName).contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().put(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser(String userName) {
		Response response=given().pathParam("username", userName)
		.when().delete(Routes.delete_url);
		return response;
	
	
	}

}
