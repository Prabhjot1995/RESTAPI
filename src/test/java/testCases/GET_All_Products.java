package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_All_Products {

	@Test
	public void read_All_Products(){
		Response response= 
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
		.when()
			.get("read.php")
		.then()
		.extract().response();
		
		int statuscode=response.getStatusCode();
		System.out.println("This is the code" + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
	}

}
