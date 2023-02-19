package org.example;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierClient extends Client {
    protected final CourierGeneration generation = new CourierGeneration();
    private static final String PATH = "/api/v1/courier";
    public ValidatableResponse create(Courier courier) {
        return given()
                .spec(getSpec())
                .when()
                .body(courier)
                .post(PATH)
                .then().log().all();
    }

    public ValidatableResponse login(CourierAuthorization courierAuthorization) {
        return given()
                .spec(getSpec())
                .when()
                .body(courierAuthorization)
                .post("/api/v1/courier/login")
                .then().log().all();
    }
    public ValidatableResponse delete(String id) {
       return given()
                .spec(getSpec())
                .when()
                .delete("/api/v1/courier/id")
                .then();
    }
}

