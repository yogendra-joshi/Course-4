package assessment_gorest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import loggerConfig.BasicConfiguration;

public class GETListOfUsers extends BasicConfiguration
{
	
	@Test
	public void getResourceList()
	{
		RestAssured
			.given()
				.contentType("application/json")
				.header("Authorization","Bearer fb522b4fddcfb28e7a91d967f45140835266e410736ad9cbaf1c0c46c5892af2")
			.when()	
				.get("https://gorest.co.in/public/v2/users")  // GET Operation
			.then()
				.statusCode(200)
				.log().all();	
		logger.info("Response Captured");
	}
}
