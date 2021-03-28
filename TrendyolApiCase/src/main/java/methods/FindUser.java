package methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class FindUser extends RequestSpec {

    public FindUser() {
        super("/me");
    }

    public String getUserId(ResponseSpecification responseSpecification){
        Response response = RestAssured.given()
                .spec(super.getRequestSpecification())
                .get()
                .then()
                .spec(responseSpecification)
                .extract().response();
        return response.getBody().jsonPath().getString("id");
    }
}
