import org.testng.Assert;
import org.testng.annotations.Test;
import spec.ResponseSpec;
import java.io.IOException;
import java.util.List;

public class SpotifyApiTest extends BaseApiTest {

    List<String> trackList = playList.addSongs();

    @Test
    public void spotifyJourney() throws IOException {
        getAndSetInfo.setUserId(getUser.getUserId(ResponseSpec.checkStatusCode200()));
        getAndSetInfo.setPlayListId(playListCreate.createPlayList(getAndSetInfo.getUserId(), ResponseSpec.checkStatusCode201()));
        Assert.assertTrue(playList.checkIsPlayListNull(getAndSetInfo.getPlayListId(), ResponseSpec.checkStatusCode200()));
    }

    @Test(dependsOnMethods={"spotifyJourney"})
    public void addTracks() {
        String playListId = getAndSetInfo.getPlayListId();
        playList.addTrackToPlayList(playListId, trackList, ResponseSpec.checkStatusCode201());
        Assert.assertFalse(playList.checkIsPlayListNull(playListId, ResponseSpec.checkStatusCode200()));
    }

    @Test(dependsOnMethods={"addTracks"})
    public void deleteTracks() throws IOException {
        String playListId = getAndSetInfo.getPlayListId();
        playList.deleteTrackFromPlayList(playListId, trackList.get(1), ResponseSpec.checkStatusCode200());
       Assert.assertFalse(playList.checkIsPlayListNull(playListId, ResponseSpec.checkStatusCode200()));
    }
}

