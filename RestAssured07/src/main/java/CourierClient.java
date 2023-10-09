import io.qameta.allure.Step;
import org.example.Config.RestAssuredConfig;
import org.example.TestData.Courier;
import org.example.TestData.CourierInfo;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

                     /*
                          Класс который отвечает за действия с эндпоинтами API

                                                                                     */

public class CourierClient extends RestAssuredConfig { // Унаследовал класс RestAssuredConfig, в котором содержатся все дубликаты для каждого теста

    public static final String COURIER_PATH = "api/v1/courier/"; // Вывел в константу базовый API путь, который дублируется в тестовых методах

    @Step
    public boolean create(Courier courier) { // На выходе нужно получить true или false, чтобы потом использовать переменную create с выходным значением в другом тесте
        return given()
                .spec(RestAssuredConfig.getBaseSpec()) // Так как из теста в тест повторяется Content type, то создал надстройку в классе RestAssuredConfig, куда вынес все дубликаты
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");
    }

    @Step
    public int login(CourierInfo courierInfo) {
        return  given()
                .spec(RestAssuredConfig.getBaseSpec())
                .body(courierInfo)
                .when()
                .post(COURIER_PATH +"login/")// Тут соответственно добавляю к константе то, что незначительно добавляется к URL в других эндпоинтах
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    @Step
    public boolean delete(int courierId) {
        return given()
                .spec(RestAssuredConfig.getBaseSpec())
                .when()
                .delete(COURIER_PATH + courierId)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .path("ok");
    }


}
