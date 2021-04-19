package testCases;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Create_A_Product {
	@Test
public void Create_A_product() {
	HashMap payload = new HashMap();
	payload.put("name", "Iphone40");
	payload.put("description", "Never relased");
	payload.put("price", "1");
	payload.put("category_id", "2");
	payload.put("category_name", "Electronics");
	Response response=
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payload)
		.when()
			.post("/create.php")
		.then()
			.extract().response();
}
}
