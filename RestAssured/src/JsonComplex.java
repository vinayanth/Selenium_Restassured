import File.shivamPayload;
import io.restassured.path.json.JsonPath;

public class JsonComplex {
	
	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(shivamPayload.CoursePrice());
		//NO of courses
		
		int count = js.getInt("courses.size");
		System.out.println(count);
		
		//Purchase amount
		int TotalAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalAmt);
		
		//First course
		String FirstC = js.get("courses[0].title");
		System.out.println(FirstC);
		
		
	}

}
