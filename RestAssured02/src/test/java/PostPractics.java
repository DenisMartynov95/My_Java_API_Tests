import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.then;

public class PostPractics {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
    }

    @Test
    public void createNewPlaceAndCheckResponse() {
        File json = new File("src/test/java/resources/newCard.json");
        Response response = given()
                .header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2OTAwMzY1ODMsImV4cCI6MTY5MDY0MTM4M30.dvDJAC8xRexA1DPGHKsT-IHUYEezKIQio-VrxoCYzI4")
                .and()
                .body(json)
                .when()
                .post("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())  //проверка, что вернулся непустой ID нового места
                .and()
                .statusCode(201);

    }
}