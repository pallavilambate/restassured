package restassured1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
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
    @Test
    public void validatestatusline()
    {
        RequestSpecification reqspect=RestAssured.given();
        reqspect.baseUri("https://reqres.in/");
        reqspect.basePath("api/users?page=2");
        Response res = reqspect.get();
        String statusline = res.statusLine();
        System.out.println("status line:"+statusline);

        Assert.assertEquals(statusline,"HTTP/1.1 200 OK","status line does not matches with expected");

    }
    @Test
    public void printHeaders()
    {
        RequestSpecification reqspec=RestAssured.given();
        reqspec.baseUri("https://reqres.in/");
        reqspec.basePath("api/users?page=2");

        Response res= reqspec.get();

        //print total no of headers
        Headers headers= res.headers();
        int headersno=headers.size();
        System.out.println(headersno);

        //print all headers
        for(Header header1: headers){
            System.out.println(header1.getName()+" : "+header1.getValue());
        }
    }
        @Test
        public void validateResponseAll(){

            //way1
            /* 
            RequestSpecification reqspec=RestAssured.given();
            reqspec.baseUri("https://reqres.in/");
            reqspec.basePath("api/users?page=2");

            Response res=reqspec.get();
            String contenttype=res.header("Content-Type");
            String TE=res.header("Transfer-Encoding");
            String con= res.header("Connection");

            Assert.assertEquals(contenttype, "application/json; charset=utf-8");
            Assert.assertEquals(TE, "chunked");
            Assert.assertEquals(con, "keep-alive");
            */
            //way2
            RestAssured.given()
                       .when().get("https://reqres.in/api/users?page=2")
                       .then().assertThat().header("Content-Type", "application/json; charset=utf-8")
                        .header("Via","1.1 vegur")
                        .header("X-Powered-By","Express")
                        .header("Cache-Control", "max-age=14400")
                        .header("Connection","keep-alive")
                        .header("Access-Control-Allow-Origin","*")
                        .header("CF-Cache-Status","HIT")
                        .header("Age","2360")l

        }
    }

