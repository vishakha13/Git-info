	package testcases;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.client.methods.RequestBuilder;

import Files.payload;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
		.addHeader("content-Type","application/json").setContentType(ContentType.JSON).build();

		
		
		  String Response=given().spec(req).log().all().queryParam("key","qaclick123").body(payload.AddPlace())
		  .when().post("maps/api/place/add/json")
		  .then().log().all().assertThat().statusCode(200).header("server",
		  "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		  
		  System.out.println(Response); JsonPath js=new JsonPath(Response);//forparsing json
		  String palceid=js.getString("place_id");
		  
		  System.out.println(palceid);
		 
	String newaddress="Summer walk, Africa";
	given().log().all().queryParam("key","qaclick123").header("content-Type","application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+palceid+"\",\r\n"
			+ "\"address\":\""+newaddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "")
	.when().put( "/maps/api/place/update/json")
	.then().log().all().assertThat().statusCode(200);
	//Add place -> Update Place with new Address-> Get Place to validate if new address is preasent in responce
	
	
	  String getresponse=given().log().all().queryParam("key","qaclick123").queryParam(
	  "Place_id", palceid). when().get(" /maps/api/place/get/json")
	  .then().assertThat().log().all().statusCode(200).extract().response().
	  asString();
	  
	 JsonPath js1= reusablemethods.rowToJson(getresponse);
	  String actualadd=js1.getString("address");
	  
	  System.out.println(actualadd);
	  Assert.assertEquals(actualadd, true);
	 
	
	}
	


	
}