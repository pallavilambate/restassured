package restassured1;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetMethod {
    @Test
    public void pallavimethod(){
        
        RequestSpecification reqspec=RestAssured.given();
        reqspec.baseUri("null");
        reqspec.basePath("null");
        System.out.println(res.asPrettyString());
        System.out.println(res.getStatusCode());
    }
}
