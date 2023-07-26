package RestAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetRequest {
    @BeforeSuite
    public void TestSetup() {
        System.out.println("Testing Setup...............");
    }

    @Test
    void getBeverlyHillsRequest() {
        given().
                get("http://zippopotam.us/us/90210").then()
                .log().all().statusCode(200).
                assertThat().contentType("application/json")
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }
    @Test
    void getArgentinaRequest() {
        given().
                get("http://zippopotam.us/AR/1601").then()
                .log().all().statusCode(200).
                assertThat().contentType("application/json")
                .body("country", not(hasItem("Argentina"))).
                body("places.'place name'", hasSize(1));
    }


    @AfterSuite
    public void TearTesting() {
        System.out.println("Testing Finish...............");
    }

}
