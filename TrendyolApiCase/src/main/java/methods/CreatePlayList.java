package methods;

import com.google.common.io.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import model.GetAndSetInfo;
import org.json.JSONObject;
import spec.RequestSpec;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class CreatePlayList extends RequestSpec {

    public CreatePlayList(){
        super("/users");
    }

    public String createPlayList(String userId, ResponseSpecification responseSpecification) throws IOException {
        URL file = Resources.getResource("playlist.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject json = new JSONObject(myJson);

        Response response = RestAssured.given()
                .spec(super.getRequestSpecification())
                .body(json.toString())
                .when()
                .post("/{userId}/playlists", userId)
                .then()
                .spec(responseSpecification)
                .extract()
                .response();

        return response.getBody().jsonPath().getString("id");

    }

}
