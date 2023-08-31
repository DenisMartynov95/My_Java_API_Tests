import Pogo.InputForCheckProductsInWarehouse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.given;

public class PostCheckProductsInWarehouse {
    private List<Integer> inputData; //По аналогии создаю тут лист
//    public InputForCheckProductsInWarehouse inputData;

    @Before


    public void setUp() {
        RestAssured.baseURI = ("https://4ca9c568-5c98-4041-b413-79516c10094d.serverhub.praktikum-services.ru");
//        inputData = new InputForCheckProductsInWarehouse(1,2);

        inputData = new ArrayList<>();
        inputData.add(1,3);
        inputData.add(2,2);
        inputData.add(3,5);
    }

    @Test

    public void checkProductsInWarehouse() {
        Response response = RestAssured.given()
                .body(inputData)
                .when()
                .post("/api/v1/warehouses/check");
        response.then().assertThat().statusCode(200);
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

}
