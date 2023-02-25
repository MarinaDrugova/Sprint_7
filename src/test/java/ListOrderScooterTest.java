import io.qameta.allure.junit4.DisplayName;
import org.example.OrderScooterClient;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.apache.http.HttpStatus.*;
import io.restassured.response.ValidatableResponse;
public class ListOrderScooterTest {
    private OrderScooterClient orderScooterClient;

    @Before
    public void setUp(){
        orderScooterClient = new OrderScooterClient();

    }
    @Test
    @DisplayName("Список заказов")
    public void listOrderScooterTest(){
        ValidatableResponse response = orderScooterClient.get();
        int statusCode = response.extract().statusCode();
        assertEquals(SC_OK, statusCode);
        response.assertThat().body("orders", notNullValue());
    }
}