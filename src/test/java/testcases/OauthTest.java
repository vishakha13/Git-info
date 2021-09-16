package testcases;


import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POJO.GetCourse;
import POJO.api;
import POJO.webAutomation;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class OauthTest {
	
	@Test
	public static void OauthVerify() throws InterruptedException
	{
		String[] courseTitles= {"Selenium Webdr8787iver Java","Cypress","Protractor","jkggj"};
		
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C://Jar/chromedriver_win32/chromedriver.exe"); WebDriver driver=new
		 * ChromeDriver(); driver.get(
		 * "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php"
		 * ); driver.findElement(By.cssSelector("div[class='w1I7fb']")).click();
		 * Thread.sleep(5000); String url=driver.getCurrentUrl();
		 */
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWicXw2YGhL7KKK2af_S-Yk9RCOlMntdr8Mx8qPoj9g98maNqSCIQ7_VQmT7cgzMIA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=none#";
		   String partialcode=url.split("code=")[1]; String
		  code=partialcode.split("&scope")[0]; System.out.println(code);
		 
		
		
		String accesstokenResponse= given().urlEncodingEnabled(false).queryParams("code",code)
	.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code").when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token")
		.asString();
		System.out.println(accesstokenResponse);
		
		JsonPath js=new JsonPath(accesstokenResponse);
		String accessToken= js.getString("access_token");
		System.out.println(accesstokenResponse);
		  GetCourse gc= given().queryParam("access_token",
				  accessToken).expect().defaultParser(Parser.JSON).when()
				  .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
				   
				  
				 System.out.println(gc.getlinkedIn());
				 System.out.println(gc.getInstructor());
				 System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
				 
				 List<api> apiCourse=gc.getCourses().getApi();
				 for(int i=0;i<apiCourse.size();i++)
				 {
					 
					 if(apiCourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					 {
						String price= apiCourse.get(i).getPrice();
						System.out.println(price);
				 }
				 }
				 
				 ArrayList<String>a=new ArrayList<String>();
				 				 List<webAutomation> coursetitle=gc.getCourses().getWebAutomation();
				 for(int j=0;j<coursetitle.size();j++)
				 
				 {
					 a.add(coursetitle.get(j).getCourseTitle());
					 
						 
				}
				 List<String> expectctedList=Arrays.asList(courseTitles);
				 Assert.assertTrue(a.equals(expectctedList));
				 
				 
	}
	
}
