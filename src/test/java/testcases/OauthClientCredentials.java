package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class OauthClientCredentials {

	@Test
	public static void OauthVerifyClientC() throws InterruptedException
	{
		
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgz9yNlvO5V1zu4Zz4nOuGYrGW_1DI8WHJF5En8DMjlfm-W4zszmSmmNFUFCkZ3Hw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none#";
		   String partialcode=url.split("code=")[1];
		   String code=partialcode.split("&scope")[0]; 
		   System.out.println(code);
		  String accesstokenResponse= given().urlEncodingEnabled(false).queryParams("code",code)
					.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
						.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
						.queryParams("Scope",url)
						.queryParams("grant_type","Client Credentials").when().log().all()
						.post("https://www.googleapis.com/oauth2/v4/token")
						.asString();
		  System.out.println(accesstokenResponse);
	}
		
}
