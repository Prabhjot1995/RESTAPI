package testCases;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Get_A_Product1 {
	@Test
	public void read() {
		HashMap payload = new HashMap();
		payload.put("id","1478");
		payload.put("name", "Iphone100");
		payload.put("description", "Never ever relased");
		payload.put("price", "Free");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
	Response response=
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payload)
			
		.when()
			.put("/update.php")
		.then()
			.extract().response();
	
	String body = response.getBody().asString();
	System.out.println(body);
	
		int code =response.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println(code);
			
}
}