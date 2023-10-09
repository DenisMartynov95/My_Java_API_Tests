import io.restassured.RestAssured;
import org.example.TestData.Courier;
import org.example.TestData.CourierInfo;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.AdditionalMatchers.not;


public class CourierTest {

    private CourierClient courierClient; // Инициализировал класс в котором хранится код для теста
    private int courierId; // Инициализировал переменную, чтобы удалять созданные данные после окончания теста

    @Before
    public void setUp(){
        courierClient = new CourierClient();
    }
    @After
    public void tearDown(){
        courierClient.delete(courierId);
    }


    @Test
    public void checkCourierCanBeCreated() {
        // Arrange (подготовить данные)
        Courier courier = Courier.getRandomInfo();

        // Act (действие)
        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(new CourierInfo(courier.login, courier.password)); // альтернатива БЕЗ  фабричного метода
//        courierId = courierClient.login(CourierInfo.from(courier)); // фабричный метод, дословно courierId = courierClient.login (Информацию для логина возьми из курьера)

                // Assert (проверка)
        assertTrue("Курьер не создался",isCourierCreated); // в message выведу ошибку с текстом если курьер все же не создасться
        assertNotNull("Не удалось получить ID курьера",courierId);
    }

}
