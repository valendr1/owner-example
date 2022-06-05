package tests;

import config.ApiConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

@Config.Sources("classpath:$api.properties")
public class SimpleApiTest {
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);
    static String token = config.token();

    @Test
    @DisplayName("Проверка регистрации")
    void registerSuccessfulTest() {
        given()
                .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}")
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .body("token", is(token));
    }
}
