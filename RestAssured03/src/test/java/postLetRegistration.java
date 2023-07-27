import Pojos.userDataForRegistration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class postLetRegistration {
    private List<userDataForRegistration> userDataList;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/";

        userDataList = new ArrayList<userDataForRegistration>(); //Попробовал использовать лист
        userDataForRegistration user1 = new userDataForRegistration(0, "Denn", "Denis", "Martynov", "idenismartynov@yandex.ru", "Qwertytrewq", "+79229999999", 0);
        userDataList.add(user1);

        userDataForRegistration user2 = new userDataForRegistration(1, "Test", "Testing", "Teststs", "ksldjakljad@mail.com", "KKASKjdksajdka", "890593939393939939393", 0);
        userDataList.add(user2);
    }

    @Test
    public void letRegistration() {

        Response response = given()
                .contentType(ContentType.JSON)
                .body(userDataList)
                .post("v2/user");
        response.then().assertThat().statusCode(200);
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());

    }
}


