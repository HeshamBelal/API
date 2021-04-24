import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void init()
    {
        RestAssured.baseURI="http://localhost:";
        RestAssured.basePath="/student";
        RestAssured.port=8085;
    }

}
