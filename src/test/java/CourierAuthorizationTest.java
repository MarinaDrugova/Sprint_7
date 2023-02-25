import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.*;

import  org.example.CourierAuthorization;

public class CourierAuthorizationTest {
    private CourierAuthorization courierAuthorization;
    private CourierClient courierClient;
    private CourierAuthorization courierWithoutLogin;
    private CourierAuthorization courierAuthorizationWithoutLogin;
    private CourierAuthorization courierAuthorizationWithoutPassword;
    private Courier courier;
    private String id;

    @Before
    public void setUp() {
        courier = CourierGeneration.getRandom();
        courierAuthorization = CourierAuthorizationGeneration.getRandom();
        courierClient = new CourierClient();
        courierAuthorization =new CourierAuthorization(courier.getLogin(), courier.getPassword());
        courierAuthorizationWithoutLogin = new CourierAuthorization(courier.getPassword());
        courierAuthorizationWithoutPassword = new CourierAuthorization(courier.getLogin());
    }
        @Test
        @DisplayName("Авторизация курьера")
        public void courierAuthorization() {
            courierClient.createCourier(courier);
            ValidatableResponse loginResponse = courierClient.login(courierAuthorization);
            id = loginResponse.extract().path("id");
            int statusCode = loginResponse.extract().statusCode();
            assertEquals(SC_CREATED, statusCode);
            loginResponse.assertThat().body("id", notNullValue());
        }

        @Test
        @DisplayName("Авторизация курьера без логина")
        public void courierWithoutLogin() {
            courier.setLogin("");
            ValidatableResponse response = courierClient.login(courierAuthorization.from(courier));
            response.assertThat().body("message", equalTo("Недостаточно данных для входа"))
                    .statusCode(SC_BAD_REQUEST);
        }

        @Test
        @DisplayName("Авторизация курьера без пароля")
        public void courierWithoutPasswordTest() {
            courier.setPassword("");
            ValidatableResponse response = courierClient.login(courierAuthorization.from(courier));
            response.assertThat().body("message", equalTo("Недостаточно данных для входа"))
                    .and().statusCode(SC_BAD_REQUEST);
        }

        @Test
        @DisplayName("Авторизация курьера с несуществующим логином")
        public void courierInvalidLogin() {
            courier.setLogin(" ");
            ValidatableResponse response = courierClient.login(courierAuthorization.from(courier));
            response.assertThat().body("message", equalTo("Учетная запись не найдена"))
                    .statusCode(SC_NOT_FOUND);
        }

        @After
        public void cleanUp () {
            if (id != null) {
                courierClient.delete(id);
            }
        }
    }