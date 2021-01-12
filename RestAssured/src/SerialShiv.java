import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddplaceShiv;
import Pojo.LocationShiv;

public class SerialShiv {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://216.10.245.166";
		AddplaceShiv p = new AddplaceShiv();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline house");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		p.setTypes(myList);
		LocationShiv l = new LocationShiv();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		
		Response res = given().queryParam("key","qaclick123").
		body("p")
		.when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).extract().response();
		
		String responseString=res.asString();
		System.out.println(responseString);
		
	}

}
