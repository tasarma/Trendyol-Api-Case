package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAndSetInfo {
    private  String userId;
    private String playListId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String UserId) {
        userId = UserId;
    }

    public String getPlayListId() {
        return playListId;
    }

    public void setPlayListId(String PlayerId) {
        playListId = PlayerId;
    }
}
