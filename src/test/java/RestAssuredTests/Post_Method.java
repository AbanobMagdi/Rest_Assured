package RestAssuredTests;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class Post_Method {
    public static Map <String,String> map = new HashMap<String , String>() ;
    @BeforeClass
    public void TestData(){
        map.put("userId", "2");
        map.put("id", "19");
        map.put("title", "this is projectdebug.com");
        map.put("body", "this is REST-Assured Tutorial");
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/posts/";
    }
    @Test(description = "")
    public void Check_Post_Method()
    {
        RestAssured.given().contentType("application/json").
                body(map).post().then().statusCode(201).and()
                .assertThat().body("title", equalTo("this is projectdebug.com"));
    }
    }


