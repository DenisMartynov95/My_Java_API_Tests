import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetWithCheckFields {

    @Before
    public void setUp() {
        baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkUserNameAndPrintResponseBody () {
        // отправил запрос и сохранил ответ в переменную response, класса Response, для этого импортировал его
        Response response = given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2ODgyOTIzMjcsImV4cCI6MTY4ODg5NzEyN30.qkAyKIddRxg_bpQ9HRMwDd90JSOhlTBfg3ykYnOW-5c")
                .get("/api/users/me");
        response.then().assertThat().body("data.name",equalTo("Денчик")); // тут проверяю что в теле ответа ключу name соответствует мое имя пользователя
        // вывожу тело ответа на экран, преобразую тело ответа в строку методом asString()
        System.out.println(response.body().asString());
    }

    @Test
    public void checkUserActivityAndPrintResponseBody() {
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2ODgyOTIzMjcsImV4cCI6MTY4ODg5NzEyN30.qkAyKIddRxg_bpQ9HRMwDd90JSOhlTBfg3ykYnOW-5c").get("/api/users/me");
        response.then().assertThat().body("data.about",equalTo("Самый крутой исследователь"));  // проверяю, что в теле ответа ключу about соответствует нужное занятие
        System.out.println(response.body().asString()); // вывожу тело ответа и преобразую его в строку тем же методом

    }

    @Test
    public void checkUserEmailAndPrintResponseBody() {
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2ODgzMTQ5MjMsImV4cCI6MTY4ODkxOTcyM30.oBR7lSLRHjrtMGuzidOZQ5SF2zKUNNoSIQXwv2Yj-Is").get("/api/users/me");
        response.then().assertThat().body("data.email",equalTo("teemsattricking@gmail.com"));
        System.out.println(response.body().asString());
    }
}
