import Pogo.User;
import io.restassured.RestAssured;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUserData {

    @Before

    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test

    public void getUserData() {
        User user = RestAssured.given()
                .header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2OTMzODk4MjAsImV4cCI6MTY5Mzk5NDYyMH0.16jAJEZz_UIijIuoX1Qf6v8mYhwXL-ieZz4W405IAh8")
                .get("/api/users/me")
                .body().as(User.class);
        MatcherAssert.assertThat(user, notNullValue());
    }

}
