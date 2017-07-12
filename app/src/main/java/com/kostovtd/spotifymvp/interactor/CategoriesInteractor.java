package com.kostovtd.spotifymvp.interactor;

import android.util.Log;

import com.kostovtd.spotifymvp.model.CategoriesResponse;
import com.kostovtd.spotifymvp.network.SpotifyAPI;
import com.kostovtd.spotifymvp.util.ApiUtils;
import com.kostovtd.spotifymvp.util.Is;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kostovtd on 12.07.17.
 */

public class CategoriesInteractor {

    private static final String TAG = CategoriesInteractor.class.getSimpleName();

    private CategoriesResponseHandler responseHandler;


    public CategoriesInteractor() {
    }

    public CategoriesInteractor(CategoriesResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }


    public void fetchCategories(String accessToken) {
        Log.d(TAG, "fetchCategories: hit");

        if(responseHandler == null) {
            Log.e(TAG, "fetchCategories: responseHandler is NULL");
            return;
        }

        if(Is.empty(accessToken)) {
            Log.e(TAG, "fetchCategories: accessToken is NULL or EMPTY");
            return;
        }


        String accessBearerToken = ApiUtils.AUTHORIZATION_WORD + " " + accessToken;
        SpotifyAPI spotifyAPI = ApiUtils.getSpotifyAPI();

        spotifyAPI.getCategories(accessBearerToken).enqueue(new Callback<CategoriesResponse>() {
            int retry = 0;

            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                if(response.isSuccessful()) {
                    CategoriesResponse categoriesResponse = response.body();
                    responseHandler.onCategoriesFetchedSuccessfully(categoriesResponse);
                } else {
                    int errorCode = response.code();
                    responseHandler.onErrorReceived(errorCode);
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                if(retry < ApiUtils.MAX_RETRY) {
                    retry++;
                    call.enqueue(this);
                } else {
                    responseHandler.onMaxRetryReached();
                }
            }
        });
    }


    public void setResponseHandler(CategoriesResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }
}
