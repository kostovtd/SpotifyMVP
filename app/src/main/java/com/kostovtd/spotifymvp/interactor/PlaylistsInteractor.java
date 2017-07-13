package com.kostovtd.spotifymvp.interactor;

import android.util.Log;

import com.kostovtd.spotifymvp.model.CategoriesResponse;
import com.kostovtd.spotifymvp.model.Playlists;
import com.kostovtd.spotifymvp.network.SpotifyAPI;
import com.kostovtd.spotifymvp.util.ApiUtils;
import com.kostovtd.spotifymvp.util.Is;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kostovtd on 13.07.17.
 */

public class PlaylistsInteractor {

    private static final String TAG = PlaylistsInteractor.class.getSimpleName();

    private PlaylistsResponseHandler responseHandler;


    public PlaylistsInteractor() {
    }

    public PlaylistsInteractor(PlaylistsResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }


    public void fetchPlaylists(String accessToken, String categoryId) {
        Log.d(TAG, "fetchPlaylists: hit");

        if (responseHandler == null) {
            Log.e(TAG, "fetchPlaylists: responseHandler is NULL");
            return;
        }

        if (Is.empty(accessToken)) {
            Log.e(TAG, "fetchPlaylists: accessToken is NULL or EMPTY");
            return;
        }

        if (Is.empty(categoryId)) {
            Log.e(TAG, "fetchPlaylists: categoryId is NULL or EMPTY");
            return;
        }

        String accessBearerToken = ApiUtils.AUTHORIZATION_WORD + " " + accessToken;
        SpotifyAPI spotifyAPI = ApiUtils.getSpotifyAPI();

        spotifyAPI.getPlaylists(accessBearerToken, categoryId).enqueue(new Callback<Playlists>() {
            int retry = 0;

            @Override
            public void onResponse(Call<Playlists> call, Response<Playlists> response) {
                if(response.isSuccessful()) {
                    Playlists playlists = response.body();
                    responseHandler.onPlaylistsFetchedSuccessfully(playlists);
                } else {
                    int errorCode = response.code();
                    responseHandler.onErrorReceived(errorCode);
                }
            }

            @Override
            public void onFailure(Call<Playlists> call, Throwable t) {
                if(retry < ApiUtils.MAX_RETRY) {
                    retry++;
                    call.enqueue(this);
                } else {
                    responseHandler.onMaxRetryReached();
                }
            }
        });
    }


    public void setResponseHandler(PlaylistsResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }
}
