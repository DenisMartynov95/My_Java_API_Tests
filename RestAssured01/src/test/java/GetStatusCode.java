import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetStatusCode {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }


    @Test
    public void getMyInfoStatusCode() {
        given() //Судя по документации - самый корневой метод с которого все начинается
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2ODgyOTIzMjcsImV4cCI6MTY4ODg5NzEyN30.qkAyKIddRxg_bpQ9HRMwDd90JSOhlTBfg3ykYnOW-5c")
                .get("/api/users/me")
                .then().statusCode(200);
    }

    @Test
    public void getMyLikeStatus() {
        given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2ODgyOTIzMjcsImV4cCI6MTY4ODg5NzEyN30.qkAyKIddRxg_bpQ9HRMwDd90JSOhlTBfg3ykYnOW-5c")
                .put("/api/cards/63ea2ccc5b0588003de6966d/likes")
                .then().statusCode(200);
        System.out.println(put().statusCode());
        //    if (200 == put().statusCode()) {
        //       System.out.println("Статус код 200");
        //   } else {
        //       System.out.println("Статус код 404");
        }

    }

