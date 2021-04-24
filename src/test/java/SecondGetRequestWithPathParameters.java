import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SecondGetRequestWithPathParameters extends TestBase{
    @Order(1)
    @Test
    public void checkGetRequestByPathParams()
    {
        Response response= RestAssured.given()
                .pathParam("id",98)
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/"+"/{id}");
        response.prettyPrint();
    }
}
