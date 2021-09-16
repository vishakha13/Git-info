package testcases;

import static io.restassured.RestAssured.given;

import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		  //System.out.println(Response);
		  JsonPath js=new JsonPath(payload.CoursePrice());//forparsing json
		 int CourseSize= js.getInt("courses.size()");
		  System.out.println(CourseSize);
		  int purchaseprice=js.getInt("dashboard.purchaseAmount");
		  
		  System.out.println(purchaseprice);
		  String title1= js.get("courses[0].title");
		  System.out.println(title1);
		  for(int i=0;i<CourseSize;i++)
		  {
			 String allTitle= js.get("courses["+i+"].title");
			 System.out.println(allTitle);
			 int priceall=js.getInt("courses["+i+"].price");
			 System.out.println(priceall);
			 
		  }
		  
		  for(int i=0;i<CourseSize;i++)
		  {
			 String allTitle= js.get("courses["+i+"].title");
			 if(allTitle.equalsIgnoreCase("RPA"))
			 {
				 System.out.println(js.get("courses["+i+"].copies").toString());
				 break;
			 }
		 
		  }
		 
			 
	}

}
