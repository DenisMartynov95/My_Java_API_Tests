import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredGetAllureTest {

    public String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDc0NjJmYjA4M2YzODAwNDIxMzhhNmYiLCJpYXQiOjE2OTMzODk4MjAsImV4cCI6MTY5Mzk5NDYyMH0.16jAJEZz_UIijIuoX1Qf6v8mYhwXL-ieZz4W405IAh8"; //вынес свой токен в перемененую

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void getMyInfoStatusCode() {
        given()
                .auth().oauth2(jwtToken)
                .get("/api/users/me")
                .then().statusCode(200);
    }

    @Test
    public void checkUserNameAndPrintResponseBody() {
        Response response = given()
                .auth().oauth2(jwtToken)  //Судя по всему при каждой анотации Test, нужно снова вставлять свой токен. Без этого тест падает
                .header("Content-Type", "application/json")
                .get("/api/users/me");
        response.then().assertThat().body("data.name", equalTo("Денис"));
        System.out.println(response.asString());
    }

    @Test
    public void likeCardAndDislikeAndCheckStatusCode() {
        Response response = given()
                .auth().oauth2(jwtToken)
                .header("Content-Type", "application/json")
                .put("/api/cards/64b6a8e0434244003d277aa0/likes");
        response.then().statusCode(200);
        System.out.println("Лайк поставлен: " + RestAssured.put().statusCode());

        Response response1 = given()
                .auth().oauth2(jwtToken)
                .header("Content-Type", "application/json")
                .delete("/api/cards/64b6a8e0434244003d277aa0/likes");
        response1.then().statusCode(200);
        System.out.println("Лайк удален: " + RestAssured.delete().statusCode());
    }

}
