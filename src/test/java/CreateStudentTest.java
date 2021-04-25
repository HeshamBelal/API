import com.github.javafaker.Faker;
import com.studentapi.model.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class CreateStudentTest extends TestBase {
private Faker faker= new Faker();
    @Order(1)
    @Test
    public void createStudentUsingStringPayload()
    {
        //For this post request the mail should be unique
        //TODO Print the response
        String payload= "{\"firstName\":\"Hesho\",\"lastName\":\"Belo\",\"email\":\"hesho@Hesho.com\",\"programme\":\"ComputerScience\",\"courses\":[\"Accounting\",\"Statistics\"]}";
        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(RestAssured.baseURI+RestAssured.port+RestAssured.basePath)
                .then()
                .statusCode(201);
    }
    @Order(2)
    @Test
    public void createStudentUsingGsonSerializationAndFakerLibrary()
    {
        StudentPojo studentPojo= new StudentPojo();
        studentPojo.setFirstName(faker.name().firstName());
        studentPojo.setLastName(faker.name().lastName());
        studentPojo.setEmail(faker.internet().emailAddress());
        studentPojo.setProgramme(faker.educator().course());
        studentPojo.setCourses(faker.educator().course());
        studentPojo.setCourses(faker.educator().course());
        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .post(RestAssured.baseURI+RestAssured.port+RestAssured.basePath)
                .then()
                .statusCode(201);
    }
}
