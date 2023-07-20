package RestAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Get_Method {
    @Test(description = " First smoke testing check the status code by using get method" +
            " And check the response body ")
    public void Check_Get_Method() {
        get("https://postman-echo.com/GET").then().statusCode(200)
                .and().assertThat().body("headers.host", equalTo("postman-echo.com"))
                .and().assertThat().body("headers.x-forwarded-proto", equalTo("https"));
    }
}
