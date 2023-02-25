package org.example;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;

public class OrderScooterClient extends Client {
    public ValidatableResponse create(OrderScooter orderScooter) {
        return given()
                .spec(getSpec())
                .body(orderScooter)
                .when()
                .post("/api/v1/orders")
                .then();

    }

    public ValidatableResponse get() {
        return given()
                .spec(getSpec())
                .when()
                .get("/api/v1/orders")
                .then();

    }

}