package com.kostovtd.spotifymvp.util;

import com.kostovtd.spotifymvp.network.RetrofitClient;
import com.kostovtd.spotifymvp.network.SpotifyAPI;

/**
 * Created by kostovtd on 27.06.17.
 */

public class ApiUtils {

    private static final String BASE_URL = "https://api.spotify.com";


    public static SpotifyAPI getSpotifyAPI() {
        return RetrofitClient.getClient(BASE_URL).create(SpotifyAPI.class);
    }

}
