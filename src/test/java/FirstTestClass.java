import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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
}
