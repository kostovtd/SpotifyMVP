package com.kostovtd.spotifymvp.network;

import com.kostovtd.spotifymvp.model.UserProfileResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by kostovtd on 27.06.17.
 */

public interface SpotifyAPI {

    @GET("/v1/me")
    Call<UserProfileResponse> getProfileData(@Header("Authorization") String authorization);
}
