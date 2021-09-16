package testcases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import java.io.File;

public class LoginJira {

	@Test
	public static void Addcomments()
	{
		RestAssured.basePath="http://localhost:8080";
		SessionFilter sf=new SessionFilter();
		
		
		  given().log().all().header("Content-Type","application/json")
		 
		  .body("{ \"username\": \"vishakha13\", \"password\": \"Success@13\" }").log().all().when().filter(sf).post("/rest/auth/1/session")
		  .then().extract().response().toString();
			/*
			 * given().header("X-Atlassian-Token","no-check").filter(sf).pathParam("id",
			 * "10012") .header("Content-Type","multipart/form-data") .multiPart("File", new
			 * File("C:\\Users\\Mahi\\eclipse-workspace\\APIAutomation\\file.txt")).when()
			 * .post("/rest/api/2/issue/{id}/attachments").then().log().all().assertThat().
			 * statusCode(200);
			 */
		  
		  String expectedMessage="Hi how are you";
		  
		String addCommentResponse = given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"body\": \""+expectedMessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(sf).when().post("/rest/api/2/issue/RSA-9/comment").then().log().all()

		  .assertThat().statusCode(201).extract().response().asString();
	}
}