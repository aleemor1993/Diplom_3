package api;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserAssertions {

    public String getValidAccessToken(ValidatableResponse response) {
        return response.log().all().assertThat().body("success", equalTo(true))
                .and().statusCode(200)
                .extract().path("accessToken");

    }

    public ValidatableResponse deleteUserSuccessfully(ValidatableResponse response){
        return response.log().all().assertThat().body("success", equalTo(true))
                .and().body("message", equalTo("User successfully removed"))
                .and().statusCode(202);
    }
}
