package testCases;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_A_product {
	@Test
	public void Read_A_Product() {
		Response response = given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.queryParam("id", "1484")
			.when()
				.get("/read_one.php")
			.then()
				.extract().response();

		String body = response.getBody().asString();
		//System.out.println(body);
		JsonPath js = new JsonPath(body);
		String id =js.get("id");
		String name=js.getString("name");
		String description=js.getString("description");
		
		
		
		long time = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("This is time " + time);
		if (time <= 4000) {
			System.out.println("Time is in the range");
		} else {
			System.out.println("system is slow");
		}
	}

}
