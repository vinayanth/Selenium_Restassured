import File.Payload;
import io.restassured.path.json.JsonPath;


public class JasonParsing {
	
	public static void main(String[] args) {
		
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		int count  = js.getInt("courses.size()");
		System.out.println(count);
		
		int TotalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalAmount);
		
		String Firstcourse = js.get("courses[1].title");
		System.out.println(Firstcourse);
		
		//print all the courses and the prices
		
		for(int i=0;i<count;i++)
		{
			String courseTitle = js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitle);
			
		}					
			System.out.println("Number of copies sold by Selenium");
			
	    	for(int i=0;i<count;i++)
			{
				String courseTitles = js.get("courses["+i+"].title");
				if(courseTitles.equalsIgnoreCase("selenium"))
				{
					int copies = js.get("courses["+i+"].copies");
					System.out.println(copies);
					break;
				}
			
			
			
		}
		
		
		
	}

}
