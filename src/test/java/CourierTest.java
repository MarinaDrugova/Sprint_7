import org.example.Courier;
import org.example.CourierAuthorization;
import org.example.CourierClient;
import org.example.CourierGeneration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;

public class CourierTest {
    private Courier courier;
    private CourierClient courierClient;
    private CourierAuthorization courierAuthorization;
    private Courier identicCourier;
    private Courier courierWithoutLogin = CourierGeneration.getRandomWithLogin();
    private Courier courierWithoutPassword;
    private String id;

    @Before
    public void setUp() {
        courier = CourierGeneration.getRandom();
        courierWithoutPassword = CourierGeneration.getRandomWithoutPassword();
        courierWithoutLogin = CourierGeneration.getRandomWithLogin();
        identicCourier = new Courier(courier.getLogin(), courier.getPassword(), courier.getFirstName());
        courierClient = new CourierClient();
        courierAuthorization = new CourierAuthorization(courier.getLogin(), courier.getPassword());
    }

    @After
    public void cleanUp() {
        if (id != null) {
            courierClient.delete(id);
        }
    }
    @Test
    public void courierCanBeCreated() {
        ValidatableResponse response = courierClient.create(courier);
        ValidatableResponse loginResponse = courierClient.login(courierAuthorization);
        id = loginResponse.extract().path("id").toString();
        response.statusCode(SC_CREATED);
        boolean messageResponse = response.extract().path("ok");
        assertTrue(messageResponse);
    }

    @Test
    public void identicCouriersCanNotBeCreated() {
        courierClient.create(courier);
        ValidatableResponse response = courierClient.create(courier);
        response.assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and().statusCode(SC_BAD_REQUEST);
    }
    @Test
    public void сourierWithoutPasswordCanNotBeCreated(){
        ValidatableResponse response = courierClient.create(courierWithoutPassword);
        int statusCode = response.extract().statusCode();
        assertEquals(SC_BAD_REQUEST, statusCode);
        String messageResponse = response.extract().path("message");
        assertEquals("Недостаточно данных для создания учетной записи", messageResponse);

    }
    @Test
    public void сourierWithoutLoginCanNotBeCreated(){
        ValidatableResponse response = courierClient.create(courierWithoutLogin);
        int statusCode = response.extract().statusCode();
        assertEquals(SC_BAD_REQUEST, statusCode);
        String messageResponse = response.extract().path("message");
        assertEquals("Недостаточно данных для создания учетной записи", messageResponse);

    }
}