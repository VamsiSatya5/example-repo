package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.Customer;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	Customer userPayLoad;
	
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayLoad=new Customer();
		
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		userPayLoad.setPassword(faker.internet().password(5, 10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
	}
	@Test(priority = 1)
	public void testPostUser() {
		
	  Response	response=UserEndPoints.createUser(userPayLoad);
	  response.then().log().all().statusCode(200);
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		Response response=UserEndPoints.getUser(this.userPayLoad.getUsername());
		response.then().log().all().statusCode(200);
	}
	
	
	@Test(priority = 3)
	public void updateUser() {
		
		
	//updating the details
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		
	Response response=UserEndPoints.updateUser(this.userPayLoad.getUsername(), userPayLoad);
	response.then().log().all().statusCode(200);
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		Response response=UserEndPoints.deleteUser(this.userPayLoad.getUsername());
		response.then().log().all().statusCode(200);
		
	}
	

}
