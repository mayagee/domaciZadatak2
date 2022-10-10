package common;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RestAssuredFunctions {

    public static Response get(String url) {
        return given().contentType(ContentType.JSON).get(url);
    }

    public static Response post(String url, Object requestBody) {
        return given().contentType(ContentType.JSON).body(requestBody).post(url).then().extract().response();
    }

    public static Response post(String url, String accessToken, Object requestBody) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).body(requestBody).post(url);

    }

}
