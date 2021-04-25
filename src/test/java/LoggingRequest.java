import io.restassured.RestAssured;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoggingRequest extends TestBase{

    @Order(1)
    @Test
    public void printRequestHeaders()
    {
        System.out.println("-------------Printing Headers---------------");
        RestAssured.given()
                .log()
                .headers()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list")
                .then()
                .statusCode(200);
    }

    @Order(2)
    @Test
    public void printRequestParamsUsingQueryParams()
    {
        System.out.println("-------------Printing Query Params---------------");
        RestAssured.given()
                .queryParams("firstName","Vernon","programme","Financial Analysis")
                .log()
                .params()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list")
                .then()
                .statusCode(200);
    }

    @Order(3)
    @Test
    public void printRequestPathParams()
    {
        System.out.println("-------------Printing Path Params---------------");
        System.out.println("-------------Printing Query Params---------------");
        RestAssured.given()
                .pathParam("id",1)
                .log()
                .params()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/{id}")
                .then()
                .statusCode(200);
    }

}
