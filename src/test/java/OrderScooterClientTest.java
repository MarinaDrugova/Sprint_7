import io.restassured.response.ValidatableResponse;
import org.example.OrderScooter;
import org.example.OrderScooterClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)

public class OrderScooterClientTest {
    private OrderScooterClient orderScooterClient;
    private final String[] colors;
    public OrderScooterClientTest(String[] colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}}
        };
    }
    @Before
    public void setUp() {
       orderScooterClient = new OrderScooterClient();

    }
    @Test
    public void OrderScooterTest() {
        String name = "name";
        String surname = "surname";
        String address = "address";
        String subwayStation = "subwayStation";
        String phone = "phone";
        int timeRent = 1;
        String dateBringScooter = "2023-02-28";
        String message = "messageForCourier";
        OrderScooter orderScooter = new OrderScooter(name, surname, address, subwayStation, phone, timeRent, dateBringScooter, message, colors);
        ValidatableResponse response = orderScooterClient.create(orderScooter);
        int statusCode = response.extract().statusCode();
        assertEquals(201, statusCode);
        response.assertThat().body("track", notNullValue());

    }
}
