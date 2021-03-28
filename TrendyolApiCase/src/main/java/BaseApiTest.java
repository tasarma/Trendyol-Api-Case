import methods.CreatePlayList;
import methods.FindUser;
import methods.PlayList;
import methods.Search;
import model.GetAndSetInfo;

public class BaseApiTest {
    FindUser getUser = new FindUser();
    GetAndSetInfo getAndSetInfo = new GetAndSetInfo();
    CreatePlayList playListCreate = new CreatePlayList();
    PlayList playList = new PlayList();
    Search search = new Search();
}
