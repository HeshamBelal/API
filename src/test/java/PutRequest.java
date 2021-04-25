import com.github.javafaker.Faker;
import com.studentapi.model.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PutRequest extends TestBase{
    private Faker faker=new Faker();
    @Order(1)
    @Test
    public void updateStudentInformationUsingFakerLibrary()
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
                .put(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/90")
                .then()
                .statusCode(200);
    }
}