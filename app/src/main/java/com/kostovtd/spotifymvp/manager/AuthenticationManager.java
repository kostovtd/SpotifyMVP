package com.kostovtd.spotifymvp.manager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

/**
 * Created by kostovtd on 22.06.17.
 */

public class AuthenticationManager {

    private static final String TAG = AuthenticationManager.class.getSimpleName();
    private static final String REDIRECT_URI = "https://abv.bg";
    private static final String CLIENT_ID = "1234"; // the ID taken from after registering the app in the Spotify app platform
    private static final String SCOPE_READ_PRIVATE_PLAYLIST = "playlist-read_private";
    private static final String SCOPE_READ_USER_LIBRARY = "user-library-read";
    private static final String SCOPE_READ_USER_STATUS = "user-read-private"; // normal or platinum user
    private static final String SCOPE_READ_USER_BIRTHDATE = "user-read-birthdate";
    private static final String SCOPE_READ_USER_EMAIL = "user-read-email";
    public static final int REQUEST_CODE = 1234; // used for onActivityResult


    private Context context;


    public AuthenticationManager(Context context) {
        this.context = context;
    }


    public void authenticate() {
        Log.d(TAG, "authenticate: hit");
        AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(CLIENT_ID,
                AuthenticationResponse.Type.TOKEN,
                REDIRECT_URI);

        // what scopes of information will we require
        String[] scopesArr = {SCOPE_READ_PRIVATE_PLAYLIST, SCOPE_READ_USER_STATUS,
                SCOPE_READ_USER_LIBRARY, SCOPE_READ_USER_BIRTHDATE, SCOPE_READ_USER_EMAIL};

        builder.setScopes(scopesArr);

        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity((Activity)context, REQUEST_CODE, request);
    }
}
