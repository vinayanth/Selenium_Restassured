import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import File.Payload;
import File.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Dynamicjson {
		
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response =given().header("Content-Type","application/json").
		body(Payload.Addbook("isbn","aisle")).
		when()
		.post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReusableMethod.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
	}

@DataProvider(name="BooksData")
public Object [][] getData()
{
	//array = collection of elments
	//mutidymemsion array = collectinn of array
	return new Object [][] {{"FDREST","765443"},{"DSGEF","645363"},{"HBGHT","987733"}};
	
	
	
}

}
