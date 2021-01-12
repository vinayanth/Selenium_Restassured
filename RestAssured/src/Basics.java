import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import File.Payload;
public class Basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\VINAYANTH\\Desktop\\addplace.json")))).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server","Apache").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);//for parsing Jason
		String PlaceID = js.getString("place_id");
		
		System.out.println(PlaceID);
		
		//update place
		String newAddress = "29, side layout, cohen 09";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"place_id\": \""+PlaceID+"\",\r\n" + 
				"    \"address\": \"APP\",\r\n" + 
				"    \"key\": \"qaclick123\"\r\n" + 
				"}").
		when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		
		String getPlaceResponse = given().log().all().queryParam("key","qaclick123")
		.queryParam("place_id",PlaceID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
			
		
		
	}

}
