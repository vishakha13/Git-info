package testcases;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import Files.payload;

public class SerializeJava {
	@Test
	public static void serial()
	
	
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		 String Response=given().log().all().queryParam("key","qaclick123").header(
				  "content-Type","application/json") .body(payload.AddPlace())
				  .when().post("maps/api/place/add/json")
				  .then().log().all().assertThat().statusCode(200).header("server",
				  "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	}
	
	

}
