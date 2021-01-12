import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import File.Reusable1;
import File.shivamPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class DynamicDemoShi {

	@Test(dataProvider = "Books")
	public void addbook(String isbn,String aisle)
	
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().header("Content-Type","application/json").
		body(shivamPayload.Addbook(isbn,aisle)).
		when()
		.post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = Reusable1.rawtojson(response);
		String id = js.get("ID");
		System.out.println(id);
		
	
	}
	
	@DataProvider(name="Books")
	public Object[][] getData()
	{
		return new Object[][] {{"herte","7777"},{"ewsdw","5555"},{"frrfr","4545"}};
	}
	
}
