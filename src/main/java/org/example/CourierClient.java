package org.example;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierClient extends Client {
    private static final String PATH = "/api/v1/courier";
    @Step("Создание курьера")
    public ValidatableResponse createCourier (Courier courier) {
        return given()
                .spec(getSpec())
                .when()
                .body(courier)
                .post(PATH)
                .then().log().all();
    }
    @Step("Успешный запрос при наличии логина и пароля")
    public ValidatableResponse login(CourierAuthorization courierAuthorization) {
        return given()
                .spec(getSpec())
                .when()
                .body(courierAuthorization)
                .post("/api/v1/courier/login")
                .then().log().all();
    }
    @Step("Удаление курьера по его id")
    public ValidatableResponse delete(String id) {
       return given()
                .spec(getSpec())
                .when()
                .delete("/api/v1/courier/id")
                .then();
    }
}

