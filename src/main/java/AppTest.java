import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.junit.Test;

public class AppTest {

    @Test
    public void getUserTest() {
        given().when().get("https://reqres.in" + "/api/users/2").then().statusCode(200);
    }

    @Test
    public void userDeleteTest() {
        given().when().delete("https://reqres.in" + "/api/users/5").then().statusCode(204);
    }

    @Test
    public void getUserListTest() {
        given().when().get("https://reqres.in" + "/api/users").then().statusCode(200);
    }

    @Test
    public void createUserTest() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Virender");
        requestParams.put("job", "Singh");

        given()
                .body(requestParams.toString())
                .when()
                .post("https://reqres.in" + "/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void unsuccessfulLoginTest() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "sydney@fife");

        given()
                .body(requestParams.toString())
                .when()
                .post("https://reqres.in" + "/api/register")
                .then()
                .statusCode(400);
    }

    @Test
    public void userNotFoundTest() {
        given().when().get("https://reqres.in" + "/api/unknown/23").then().statusCode(404);
    }

    @Test
    public void updateUserTest() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "morpheus");
        requestParams.put("job", "kierownik");

        given()
                .body(requestParams.toString())
                .when()
                .post("https://reqres.in" + "/api/users/2")
                .then()
                .statusCode(201);
    }
}