package restassured1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class validateResponse {
    @Test
    public void validateStatusCode(){
        RequestSpecification requetspec = RestAssured.given();
        requetspec.baseUri("https://reqres.in/");
        requetspec.basePath("api/users?page=2");

        Response res=requetspec.get();
        int statuscode=res.getStatusCode();

        Assert.assertEquals(statuscode,200,"status code not match");
    }
    
}
