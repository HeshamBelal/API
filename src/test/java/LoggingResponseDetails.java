import io.restassured.RestAssured;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoggingResponseDetails extends TestBase{
    @Order(1)
    @Test
    public void printResponseHeaders()
    {
        System.out.println("-------------Printing Response Headers---------------");
        RestAssured.given()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list")
                .then()
                .log()
                .headers()
                .statusCode(200);
    }
    @Order(2)
    @Test
    public void printResponseStatus()
    {
        System.out.println("-------------Printing Response Status---------------");
        RestAssured.given()
                .queryParams("firstName","Vernon","programme","Financial Analysis")
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list")
                .then()
                .log()
                .status()
                .statusCode(200);
    }
    @Order(3)
    @Test
    public void printResponseBody()
    {
        System.out.println("-------------Printing Response Body---------------");
        RestAssured.given()
                .pathParam("id",1)
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/{id}")
                .then()
                .log()
                .body()
                .statusCode(200);
    }
    @Order(4)
    @Test
    public void printAResponseWhenValidationFails()
    {
        System.out.println("-------------Printing Response---------------");
        RestAssured.given()
                .queryParams("programme","Financial Analysis","limit",1)
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list")
                .then()
                .log()
                .ifValidationFails()
                .statusCode(201);
    }
    @Order(5)
    @Test
    public void printAResponseIfError()
    {
        RestAssured.given()
                .pathParam("id",-1)
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/{id}")
                .then()
                .log()
                .ifError();
    }
}