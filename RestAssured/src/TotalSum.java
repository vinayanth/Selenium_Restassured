import org.testng.annotations.Test;

import File.Payload;
import io.restassured.path.json.JsonPath;


public class TotalSum {
	
	@Test
	public void sumofcourse()
	{
	   JsonPath js =new JsonPath(Payload.CoursePrice());
	   int count = js.getInt("courses.size()");
	   
	   for(int i=0;i<count;i++)
	   {
		   int price = js.getInt("courses["+i+"].price");
		   int copies = js.getInt("courses["+i+"].copies");
		   
		   int amount = price * copies;
		   
		   System.out.println(amount);
	   }

}
}
