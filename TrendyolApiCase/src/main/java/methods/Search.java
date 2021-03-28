package methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

import java.util.ArrayList;
import java.util.List;

public class Search extends RequestSpec {

    public Search() {
        super("/search");
    }

    public String searchTrack(String trackName, ResponseSpecification responseSpecification){
        Response response = RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParam("q", trackName)
                .queryParam("type", "track")
                .queryParam("limit","1")
                .get()
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
        List<String> trackPath= response.path("tracks.items.uri");
        return trackPath.get(0);
    }
}
