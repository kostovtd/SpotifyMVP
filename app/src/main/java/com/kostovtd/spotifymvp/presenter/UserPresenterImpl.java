package com.kostovtd.spotifymvp.presenter;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.manager.AuthenticationManager;
import com.kostovtd.spotifymvp.manager.ScreenManager;
import com.kostovtd.spotifymvp.manager.UserManager;
import com.kostovtd.spotifymvp.model.User;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

/**
 * Created by kostovtd on 21.06.17.
 */

public class UserPresenterImpl implements UserPresenter {

    private static final String TAG = UserPresenterImpl.class.getSimpleName();


    private Context context;


    public UserPresenterImpl(Context context) {
        this.context = context;
    }


    /**
     * Authenticate the current user based on the given client id.
     * spotify-auth library used.
     */
    @Override
    public void authenticate() {
        Log.d(TAG, "authenticate: hit");
        AuthenticationManager authenticationManager = new AuthenticationManager(context);
        authenticationManager.authenticate();
    }


    @Override
    public void successfulAuthentication(AuthenticationResponse response) {
        Log.d(TAG, "successfulAuthentication: hit");

        AuthenticationManager authenticationManager = new AuthenticationManager(context);
        User user = authenticationManager.extractUserData(response);

        if(user != null) {
            UserManager userManager = new UserManager(context);
            boolean userSaved = userManager.saveUserData(user);

            if(userSaved) {
                ScreenManager screenManager = new ScreenManager(context);
                screenManager.navigateToMainScreen();
            } else {
                Log.e(TAG, "successfulAuthentication: user not saved");
            }
        } else {
            Log.e(TAG, "successfulAuthentication: user not saved");
        }
    }
}
