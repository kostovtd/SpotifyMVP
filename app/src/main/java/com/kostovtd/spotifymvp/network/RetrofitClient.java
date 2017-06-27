package com.kostovtd.spotifymvp.network;

import android.util.Log;

import com.kostovtd.spotifymvp.util.Is;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kostovtd on 27.06.17.
 */

public class RetrofitClient {

    private static final String TAG = RetrofitClient.class.getSimpleName();

    private static Retrofit retrofit = null;


    public static Retrofit getClient(String baseUrl) {
        Log.d(TAG, "getClient: hit");

        if(Is.empty(baseUrl)) {
            throw new IllegalArgumentException("baseUrl is NULL or EMPTY");
        }

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
