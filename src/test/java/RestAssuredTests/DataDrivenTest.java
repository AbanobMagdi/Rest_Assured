package RestAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDrivenTest {
    @DataProvider(name = "TestData")
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }
        @Test(dataProvider = "TestData")
        public void CheckDataWithDataDrivenTest (String countryCode, String zipCode, String expectedPlaceName ){
            given().
                    pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                    when().
                    get("http://zippopotam.us/{countryCode}/{zipCode}").
                    then().
                    assertThat().
                    body("places[0].'place name'", equalTo(expectedPlaceName));
        }
    }

