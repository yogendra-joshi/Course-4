package assessment_gorest;

import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import loggerConfig.BasicConfiguration;

public class ADDUser extends BasicConfiguration
{
	public static HashMap<String, String> map = new HashMap<String, String>();
	String Email= "yogendrajoshi004@gmail.com";
	@BeforeMethod
	public void postData()
	{
		map.put("name", "yogendra");
		logger.info("Added name");
		map.put("email" , Email);
		logger.info("Added email");
		map.put("gender", "male");
		logger.info("Added gender");
		map.put("status" , "active");
		logger.info("Added status");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";
		logger.info("Payload Created for creating the resource");
	}
	@Test
	public void createResource()
	{
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
				.header("Authorization","Bearer fb522b4fddcfb28e7a91d967f45140835266e410736ad9cbaf1c0c46c5892af2")
			.when()
				.post() //POST Request
			.then()
				.statusCode(201)
				.log().all()
			.and()	
				.body("email", is(Email));
		logger.info("Resource Created");
	}

}

