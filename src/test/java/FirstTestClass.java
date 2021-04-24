import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class FirstTestClass extends TestBase{
    @DisplayName("Check if status code is 200")
    @Order(1)
    @Test
    public void checkStatusCode()
    {
        RestAssured.given()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list")
                .then()
                .statusCode(200);
    }
    @DisplayName("Get method with Query Param method")
    @Order(2)
    @Test
    public void checkGetWithQueryParam()
    {
        Response response= RestAssured.given()
                .when()
                .queryParam("courses","Anatomy")
                .queryParam("programme","Medicine")
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list");
        response.prettyPrint();
    }
    @DisplayName("Get method with Query Params method")
    @Order(3)
    @Test
    public void checkGetWithQueryParams()
    {
        Response response= RestAssured.given()
                .when()
                .queryParams("courses","Anatomy","programme","Medicine")
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list");
        response.prettyPrint();
    }
    @DisplayName("Get method with Query Params using Hash Table")
    @Order(4)
    @Test
    public void checkGetWithQueryParamsUsingHashTable()
    {
        HashMap<String,Object> params= new HashMap<String,Object>();
        params.put("courses","Anatomy");
        params.put("programme","Medicine");
        Response response= RestAssured.given()
                .when()
                .queryParams(params)
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list");
        response.prettyPrint();
    }
}
