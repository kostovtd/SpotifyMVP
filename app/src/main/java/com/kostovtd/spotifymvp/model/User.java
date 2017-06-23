package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 23.06.17.
 */

public class User {

    private AccessToken accessToken;


    public User(AccessToken accessToken) {
        this.accessToken = accessToken;
    }


    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
