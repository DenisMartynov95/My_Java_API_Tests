import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.then;

public class PatchPractics {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
    }

    @Test
    public void refreshProfileInfo() {
        File json = new File("src/test/java/resources/refreshProfileInfo.json");
        Response response = given()
                .header("content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2OTAwMzY1ODMsImV4cCI6MTY5MDY0MTM4M30.dvDJAC8xRexA1DPGHKsT-IHUYEezKIQio-VrxoCYzI4")
                .body(json)
                .when()
                .patch("api/users/me");
        response.then().assertThat().statusCode(200)
                .and()
                .assertThat().body("data.name", equalTo("Василий Васильев"));
    }

}
