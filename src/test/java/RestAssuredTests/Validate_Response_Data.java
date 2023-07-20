package RestAssuredTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Validate_Response_Data {
    @Test(description = "Validate Response Data ")
    public void Validate_Data_From_Response() {
        given().log().all()
                .get("https://gateway.autodns.com/").then().log().body()
                .contentType(ContentType.XML);

                /*then().assertThat().statusCode(200).and().assertThat()
                .body("response.result.msg.text",
                        equalTo("Parser error."))
                .and().assertThat().body("response.result.msg.code",
                        equalTo("EF00000"))
                .and().assertThat().body("response.result.msg.type",
                        equalTo("error"));*/
    }
}
