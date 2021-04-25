import com.github.javafaker.Faker;
import com.studentapi.model.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoggingRequestDetails extends TestBase{
    private Faker faker;
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
    public void printRequestParamsUsingPathParams()
    {
        System.out.println("-------------Printing Path Params---------------");
        RestAssured.given()
                .pathParam("id",1)
                .log()
                .params()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/{id}")
                .then()
                .statusCode(200);
    }
    @Order(4)
    @Test
    public void printAGetRequestAllParams()
    {
        System.out.println("-------------Printing All Params---------------");
        RestAssured.given()
                .queryParams("programme","Financial Analysis","limit",1)
                .log()
                .all()
                .when()
                .get(RestAssured.baseURI+RestAssured.port+RestAssured.basePath+"/list");
    }

    @Order(5)
    @Test
    public void printAPostRequestAllParams()
    {
        faker=new Faker();
        StudentPojo studentPojo= new StudentPojo();
        studentPojo.setFirstName(faker.name().firstName());
        studentPojo.setLastName(faker.name().lastName());
        studentPojo.setEmail(faker.internet().emailAddress());
        studentPojo.setProgramme(faker.educator().course());
        studentPojo.setCourses(faker.educator().course());
        studentPojo.setCourses(faker.educator().course());
        System.out.println("-------------Printing All Params---------------");
        RestAssured.given()
                .log()
                .all()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .post(RestAssured.baseURI+RestAssured.port+RestAssured.basePath);
    }
    @Order(6)
    @Test
    public void printAPostRequestAllParamsIfFails()
    {
        faker=new Faker();
        StudentPojo studentPojo= new StudentPojo();
        studentPojo.setFirstName(faker.name().firstName());
        studentPojo.setLastName(faker.name().lastName());
        studentPojo.setEmail(faker.internet().emailAddress());
        studentPojo.setProgramme(faker.educator().course());
        studentPojo.setCourses(faker.educator().course());
        studentPojo.setCourses(faker.educator().course());
        System.out.println("-------------Printing All Params---------------");
        RestAssured.given()
                .log()
                .ifValidationFails()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .post(RestAssured.baseURI+RestAssured.port+RestAssured.basePath)
                .then()
                .statusCode(200);
    }
}