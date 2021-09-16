package testcases;

import io.restassured.path.json.JsonPath;

public class reusablemethods {

	public static JsonPath rowToJson(String getresponse)
	{
		JsonPath js1=new JsonPath(getresponse);
		return js1;
		
	}
}
