package api;

import api.requests.DeleteUser;
import api.requests.LoginUser;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

    protected final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    protected final String LOGIN = "/api/auth/login";
    protected final String USER = "/api/auth/user";

    public ValidatableResponse login(LoginUser loginUser){
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URI)
                .body(loginUser)
                .when()
                .post(LOGIN).then().log().all();

    }

    public ValidatableResponse deleteUserSuccessfully(String accessToken, DeleteUser deleteUser){
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(BASE_URI)
                .body(deleteUser)
                .when()
                .delete(USER).then().log().all();
    }
}
