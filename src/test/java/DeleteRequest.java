import io.restassured.RestAssured;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class DeleteRequest extends TestBase{

    @Order(1)
    @Test
    public void deleteAStudent()
    {
        RestAssured.given()
                .when()
                .delete(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/91")
                .then()
                .statusCode(204);
    }
}
