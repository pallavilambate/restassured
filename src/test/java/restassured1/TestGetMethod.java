package restassured1;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetMethod {
    @Test
    public void pallavimethod(){
        
        RequestSpecification reqspec=RestAssured.given();
        reqspec.baseUri("https://reqres.in/");
        reqspec.basePath("api/users?page=2");
        Response res=reqspec.get();
        System.out.println(res.asPrettyString());
        System.out.println(res.getStatusCode());
    }
}
