package restassured1;

import org.testng.annotations.Test;

//import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class getResponseBody {
    @Test
 public void getResponsebody(){
    RequestSpecification reqspec =RestAssured.given();
    reqspec.baseUri("https://reqres.in/");
    reqspec.basePath("api/users?page=2");

    Response res=reqspec.get();
    ResponseBody resBody= res.getBody();
    String resBodystr=resBody.asString();
System.out.println(resBodystr);

Assert.assertEquals(resBodystr.contains("Wong"), true);
 }
 @Test
 public void testJsonpath(){
    RequestSpecification reqspec =RestAssured.given();
    reqspec.baseUri("https://reqres.in/");
    reqspec.basePath("api/users?page=2");

    Response res=reqspec.get();
    ResponseBody resBody= res.getBody();
    JsonPath jp= resBody.jsonPath();
    String firstname= jp.get("data[1].first_name");
    System.out.println(firstname);

    Assert.assertEquals(firstname, "Janet");
 }
}
