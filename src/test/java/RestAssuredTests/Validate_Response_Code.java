package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Validate_Response_Code {
    @Test(description = "validate response code is 200 by given and then methods")
    public void Validate_Response_Code_By_Given() {
        given().get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then().assertThat().statusCode(200);
    }

    @Test(description = "validate response code is 200 By_Response_Library")
    public void Validate_Response_Code_By_Response_Library() {
        Response Res = RestAssured.get("https://fakerestapi.azurewebsites.net/api/v1/Activities");
        Assert.assertEquals(Res.statusCode(), 200);
    }
}
