package File;

import io.restassured.path.json.JsonPath;

public class Reusable1 {
	
	
	 public static JsonPath rawtojson(String response)
	 {
		 JsonPath js1 = new JsonPath(response);
		 return js1;
	 }

}
