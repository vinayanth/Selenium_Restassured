import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import File.Reusable1;
import File.shivamPayload;

public class ShivamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        RestAssured.baseURI="http://216.10.245.166";
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(shivamPayload.AddPlace())
        .when().post("/maps/api/place/add/json")
        .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
        .header("Server","Apache").extract().response().asString();
        
        System.out.println(response);
        JsonPath js = new JsonPath(response);//for parsing json
        String PlaceID = js.getString("place_id");
        System.out.println(PlaceID);
        
        //update Place
        String newAddress = "APP";
        
        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
        .body("{\r\n" + 
        		"    \"place_id\": \""+PlaceID+"\",\r\n" + 
        		"    \"address\": \""+newAddress+"\",\r\n" + 
        		"    \"key\": \"qaclick123\"\r\n" + 
        		"}").
        when().put("/maps/api/place/update/json")
        .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
        
      //Get place
    	
    	String getplaceresponse = given().log().all().queryParam("key", "qaclick123")
        .queryParam("place_id",PlaceID)
        .when().get("/maps/api/place/get/json")
        .then().assertThat().log().all().statusCode(200).extract().response().asString();
    	
    	JsonPath js1 = Reusable1.rawtojson(getplaceresponse);
    	String actualaddress = js1.getString("address");
    	System.out.println(actualaddress);
    	Assert.assertEquals(actualaddress, newAddress);
	}
	

	
}
