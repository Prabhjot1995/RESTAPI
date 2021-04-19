package testCases;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Delete {
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void delete() {
		HashMap payload = new HashMap();
		payload.put("id", "1499");
//		payload.put("name", "Iphone100");
//		payload.put("description", "Never ever relased");
//		payload.put("price", "Free");
//		payload.put("category_id", "2");
//		payload.put("category_name", "Electronics");
		Response response = 
			given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.body(payload)
			.when()
				.delete("/delete.php")
			.then()
				.extract().response();
		
		int statusCode = response.getStatusCode();
		softAssert.assertEquals(statusCode, 200,"Status code not matching");
		
		String  responseBody = response.getBody().asString();
		JsonPath js = new JsonPath(responseBody);
		String deleteMessage = js.getString("message");
		softAssert.assertEquals(deleteMessage, "Product was deleted.","Product was not deleted.");
		
		
	}
}