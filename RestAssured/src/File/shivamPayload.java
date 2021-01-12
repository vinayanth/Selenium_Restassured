package File;

public class shivamPayload {

	public static String AddPlace()
	{
		 return "{\r\n" + 
		 		"\r\n" + 
		 		"    \"location\":{\r\n" + 
		 		"\r\n" + 
		 		"        \"lat\" : -38.383494,\r\n" + 
		 		"\r\n" + 
		 		"        \"lng\" : 33.427362\r\n" + 
		 		"\r\n" + 
		 		"    },\r\n" + 
		 		"\r\n" + 
		 		"    \"accuracy\":50,\r\n" + 
		 		"\r\n" + 
		 		"    \"name\":\"Frontline house\",\r\n" + 
		 		"\r\n" + 
		 		"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
		 		"\r\n" + 
		 		"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
		 		"\r\n" + 
		 		"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
		 		"\r\n" + 
		 		"    \"website\" : \"http://google.com\",\r\n" + 
		 		"\r\n" + 
		 		"    \"language\" : \"French-IN\"\r\n" + 
		 		"\r\n" + 
		 		"}\r\n" + 
		 		"";
	   	
	}
	public static String CoursePrice()
	{
		return"{\r\n" + 
				"\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 765,\r\n" + 
				"\r\n" + 
				"\"website\": \"Amazon.in\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 510,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress Automation\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA UI path\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"";
	}
	
         public static String Addbook(String aisle, String isbn)
         {
        	String payload="{\r\n" + 
        	 		"\r\n" + 
        	 		"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
        	 		"\"isbn\":\""+aisle+"\",\r\n" + 
        	 		"\"aisle\":\""+isbn+"\",\r\n" + 
        	 		"\"author\":\"John foe\"\r\n" + 
        	 		"}\r\n" + 
        	 		"";
        	 return payload;
         }
}
