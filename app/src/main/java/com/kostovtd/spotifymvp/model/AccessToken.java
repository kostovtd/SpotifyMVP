package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 23.06.17.
 */

public class AccessToken {

    private String token;
    private int expiresIn; // milliseconds


    public AccessToken(String token, int expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
