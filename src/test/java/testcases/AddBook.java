package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class AddBook {
	
	@Test(dataProvider="Bookdata")
	public static void AddbookAPI(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Respose=given().log().all().header("Content-Type","application/json")
		.body(payload.Addbook2(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=reusablemethods.rowToJson(Respose);
		String ID=js.getString("ID");
		System.out.println(ID);
	}
		
	/*
	 * public static void DeleteAPI() { //Delete ValidatableResponse deleletAPI=
	 * given().log().all().header("Content-Type","application/json")
	 * 
	 * .when().delete("/Library/Addbook.php").then().log().all().assertThat().
	 * statusCode(200);
	 * System.out.printf("deletered successfully",deleletAPI.toString() );
	 * 
	 * 
	 * }
	 */
	@DataProvider(name="Bookdata")
	public Object[][] getdata()
	{
		return new Object[][] {{"dassa","34554"},{"fdsfs","2425"},{"hjhk","6578"}};
	}
	
	
	
	

}
