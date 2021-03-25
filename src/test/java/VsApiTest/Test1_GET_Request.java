package VsApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class Test1_GET_Request {

    @Test

    public void getAllRequest() {

        // Base URI

        RestAssured.baseURI = "https://api.victoriassecret.com/settings/v1/languages?activeCountry=US";

        // Request object

        RequestSpecification httpRequest = given();

        // Response object

        Response response = httpRequest.request(Method.GET, "https://api.victoriassecret.com/settings/v1/languages?activeCountry=US");

        String responseBody = response.getBody().prettyPrint();
        //System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        //statusCode Validation

        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");


    }

    @Test

    void test_02(){

        given()
                .get("https://api.victoriassecret.com/settings/v1/languages?activeCountry=US")
                .then()
                .statusCode(200)
      .body("languageDescription",hasItems("English","French"));
    }


    @Test

    void test03(){
        given()
                .get("https://api.victoriassecret.com/settings/v1/languages?activeCountry=US")
                .then()
                .statusCode(200)
                .log().all();
    }
}
