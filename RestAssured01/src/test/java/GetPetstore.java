import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.hamcrest.Matchers.equalTo; // для проверки статус кода


import static io.restassured.RestAssured.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Заставил методы работать в порядке их написания, поэтому методы названы с маркерной буквы алфавитной
public class GetPetstore {

    @Before
    public void setUp() {
        baseURI = "https://petstore.swagger.io/v2/";
    }

    @Test
    public void a_loginPetstoreAccount() {
        Response response = given()
                .auth()
                .basic("Jensen", "test")
                .get("user/login");
        response.then().assertThat().statusCode(200); // Проверяю, точно ли статус код 200?

        if (response.statusCode() == 200) {
            System.out.println(response.getBody().asString() + "   Все в порядке, тест прошел! Авторизация успешна");
        } else {
            System.out.println("Перепроверь отправляемые данные  " + response.getBody().asString());
        }
    }

    @Test
    public void b_findPetByStatus() {
        Response response = given()
                .param("status", "sold")
                .get("pet/findByStatus");
        response.then().assertThat().statusCode(200);
        System.out.println(response.getBody().asString());

    }

    @Test
    public void c_findStoreById() {
        Response response = given()
                .param("orderId", "2")
                .get("store/order/2");
        response.then().assertThat().statusCode(200);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void d_logoutPetstoreAccount() {
        Response response = given()
                .get("user/logout");
        response.then().assertThat().statusCode(200);

        if(response.statusCode() == 200) {
            System.out.println(response.getBody().asString() + "   Все в поряде");
        } else {
            System.out.println("404!");
        }
        RestAssured.reset();
    }



    // @After
    // public  void shutDown() {
    //    RestAssured.reset(); //Закрываю коннект
    // }
}
