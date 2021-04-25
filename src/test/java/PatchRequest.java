import com.github.javafaker.Faker;
import com.studentapi.model.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PatchRequest extends TestBase{
    private Faker faker=new Faker();
    private StudentPojo studentPojo= new StudentPojo();
    @Order(1)
    @Test
    public void updateStudentEmailOnlyUsingFakerLibraryAndPatch()
    {
        studentPojo.setEmail(faker.internet().emailAddress());
        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .patch(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/90")
                .then()
                .statusCode(200);
    }
}
