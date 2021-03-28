package methods;

import com.google.common.io.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PlayList extends RequestSpec {

    public PlayList() {
        super("/playlists");
    }

    Search search = new Search();

    public boolean checkIsPlayListNull(String playListId, ResponseSpecification responseSpecification){
        Response response = RestAssured.given()
                .spec(super.getRequestSpecification())
                .get("/{playListId}/tracks", playListId)
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
        List<Object> items = response.jsonPath().getList("items");
        if(items.size() == 0)
            return true;
        return false;
    }

    public void addTrackToPlayList(String playlistId, List<String> trackList, ResponseSpecification responseSpecification){
        for(int i=0; i<trackList.size(); i++){
            RestAssured.given()
                    .spec(super.getRequestSpecification())
                    .queryParam("uris", trackList.get(i))
                    .post("/{playlist_id}/tracks",playlistId)
                    .then()
                    .spec(responseSpecification);
        }
    }

    public void deleteTrackFromPlayList(String playlistId, String trackUri, ResponseSpecification responseSpecification) throws IOException {
        URL file = Resources.getResource("track.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject json = new JSONObject(myJson);

                RestAssured.given()
                .spec(super.getRequestSpecification())
                .body(json.toString())
                .then()
                .spec(responseSpecification);
    }

    public List<String>  addSongs(){
        List<String> trackList = new ArrayList<>();
        trackList.add(search.searchTrack("The Show Must Go On", ResponseSpec.checkStatusCode200()));
        trackList.add(search.searchTrack("Ey Sareban",ResponseSpec.checkStatusCode200()));
        trackList.add(search.searchTrack("Say: Black Earth",ResponseSpec.checkStatusCode200()));
        //System.out.println(trackList.get(1));
        return trackList;
    }

}
