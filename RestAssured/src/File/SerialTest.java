package File;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo.Addplace;
import Pojo.Location;

public class SerialTest {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://216.10.245.166";
		Addplace P = new Addplace();
		P.setAccuracy(50);
		P.setAddress("29, side layout, cohen 09");
		P.setLanguage("French-IN");
		P.setPhone_number("(+91) 983 893 3937");
		P.setWebsite("http://google.com");
		P.setName("Frontline house");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		P.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		P.setLocation(l);
		
		Response res = given().queryParam("key","qaclick123")
				.body(P)
				.when().post("/maps/api/place/add/json").
				then().assertThat().statusCode(200).extract().response();
		
		String responseString=res.asString();
		System.out.println(responseString);
		
	}
	

}
