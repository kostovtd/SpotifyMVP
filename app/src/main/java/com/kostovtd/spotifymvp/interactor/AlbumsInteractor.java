package com.kostovtd.spotifymvp.interactor;

import android.util.Log;

import com.kostovtd.spotifymvp.model.AlbumsResponse;
import com.kostovtd.spotifymvp.network.SpotifyAPI;
import com.kostovtd.spotifymvp.util.ApiUtils;
import com.kostovtd.spotifymvp.util.Is;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kostovtd on 04.07.17.
 */

public class AlbumsInteractor {

    private static final String TAG = AlbumsInteractor.class.getSimpleName();

    private AlbumsResponseHandler responseHandler;


    public AlbumsInteractor() {
    }

    public AlbumsInteractor(AlbumsResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }


    public void fetchAlbums(String accessToken) {
        Log.d(TAG, "fetchAlbums: hit");

        if(responseHandler == null) {
            Log.e(TAG, "fetchAlbums: responseHandler is NULL");
            return;
        }

        if(Is.empty(accessToken)) {
            Log.e(TAG, "fetchAlbums: accessToken is NULL or EMPTY");
            return;
        }

        String accessBearerToken = ApiUtils.AUTHORIZATION_WORD + " " + accessToken;
        SpotifyAPI spotifyAPI = ApiUtils.getSpotifyAPI();

        spotifyAPI.getAlbums(accessBearerToken).enqueue(new Callback<AlbumsResponse>() {
            int retry = 0;

            @Override
            public void onResponse(Call<AlbumsResponse> call, Response<AlbumsResponse> response) {
                if(response.isSuccessful()) {
                    AlbumsResponse albumsResponse = response.body();
                    responseHandler.onAlbumsFetchedSuccessfully(albumsResponse);
                } else {
                    int errorCode = response.code();
                    responseHandler.onErrorReceived(errorCode);
                }
            }

            @Override
            public void onFailure(Call<AlbumsResponse> call, Throwable t) {
                if(retry < ApiUtils.MAX_RETRY) {
                    retry++;
                    call.enqueue(this);
                } else {
                    responseHandler.onMaxRetryReached();
                }
            }
        });
    }


    public void setResponseHandler(AlbumsResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }
}
