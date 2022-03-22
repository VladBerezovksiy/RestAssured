package adapter;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import model.Booking;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

@Data
public abstract class BaseAdapter {

    private String endpoint;
    protected Gson gson = new Gson();

    public BaseAdapter(String endpoint) {
        this.endpoint = endpoint;
    }

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .addCookie("token=f1c7bb8c1092e0b")
            .setBaseUri("http://localhost:3001/")
            .build();

    public ValidatableResponse post(String payload) {
        return given()
                .spec(requestSpec)
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse post(Booking model) {
        return given()
                .spec(requestSpec)
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse get() {
        return given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse put(Booking model) {
        return given()
                .spec(requestSpec)
                .body(model)
                .when()
                .put(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse patch(Booking model) {
        return given()
                .spec(requestSpec)
                .body(model)
                .when()
                .patch(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse delete() {
        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

}