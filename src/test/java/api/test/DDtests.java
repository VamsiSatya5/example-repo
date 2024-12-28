package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.Customer;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtests {
	
	Customer userPayLoad;
	
	
	@Test(priority=1,dataProvider = "Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID,String UserName,String FirstName,String LastName,String Email,String Password,String phone)
	{
		userPayLoad=new Customer();
		
		userPayLoad.setId(Integer.parseInt(UserID));
		userPayLoad.setUsername(UserName);
		userPayLoad.setFirstName(FirstName);
		userPayLoad.setLastName(LastName);
		userPayLoad.setEmail(Email);
		userPayLoad.setPassword(Password);
		userPayLoad.setPhone(phone);
		
		Response response=UserEndPoints.createUser(userPayLoad);
		response.then().log().all().statusCode(200);
		
	}
	
	@Test(priority=2,dataProvider = "UserNameData",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String Username) {
		Response response=UserEndPoints.deleteUser(Username);
		response.then().log().all().statusCode(200);
		
	}

}
