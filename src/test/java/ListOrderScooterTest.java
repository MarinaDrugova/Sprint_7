import io.qameta.allure.junit4.DisplayName;
import org.example.Client;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.apache.http.HttpStatus.*;
public class ListOrderScooterTest extends Client {
    private static final String checkOrder = "/api/v1/orders";
    @Test
    @DisplayName("Список заказов")
    public void ListOrderScooterTest(){

        given()
                .spec(getSpec())
                .when()
                .get(checkOrder)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("orders", notNullValue());
    }
}
