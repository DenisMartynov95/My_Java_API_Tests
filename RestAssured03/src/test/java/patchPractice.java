import Pojos.Profile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;
import static org.hamcrest.Matchers.*;

public class patchPractice {

    private Profile profile;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
        // Инициализируйте объект профиля на уровне класса
        profile = new Profile("Денис", "QA Auto");
    }

    @Test
    public void updateProfile() {
        Response response = given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2OTAwNDMxODYsImV4cCI6MTY5MDY0Nzk4Nn0.OEU4hvjIWx2E8squ8vrXCyGzgvQhIQjdveKScamv3vM")
                .contentType(ContentType.JSON)
                .body(profile)
                .patch("/api/users/me");
        response.then().assertThat().body("data.name", equalTo("Денис"));
        System.out.println(patch().statusCode());
    }
}
