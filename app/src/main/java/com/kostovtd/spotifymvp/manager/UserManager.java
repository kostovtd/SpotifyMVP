package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.kostovtd.spotifymvp.model.AccessToken;
import com.kostovtd.spotifymvp.model.User;

/**
 * Created by kostovtd on 23.06.17.
 */

public class UserManager {

    private static final String TAG = UserManager.class.getSimpleName();
    private static final String SHARED_PREFERENCES_NAME = "com.kostovtd.spotifymvp";
    private static final String ACCESS_TOKEN_KEY = "access_token_key";
    private static final String EXPIRES_IN_KEY = "expires_in_key";

    private Context context;


    public UserManager(Context context) {
        this.context = context;
    }


    /**
     * Save {@link User} in {@link SharedPreferences}
     * @param user
     * @return TRUE if saved, FALSE otherwise
     */
    public boolean saveUserData(User user) {
        Log.d(TAG, "saveUserData: hit");

        if(user != null) {
            if(context != null) {
                if(user.getAccessToken() != null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(ACCESS_TOKEN_KEY, user.getAccessToken().getToken());
                    editor.putInt(EXPIRES_IN_KEY, user.getAccessToken().getExpiresIn());
                    editor.apply();
                    return true;
                } else {
                    Log.e(TAG, "saveUserData: accessToken object is NULL");
                }
            } else {
                Log.e(TAG, "saveUserData: context is NULL");
            }
        } else {
            Log.e(TAG, "saveUserData: user is NULL");
        }

        return false;
    }


    /**
     * Extract all available data about {@link User}
     * from {@link SharedPreferences}
     * @return {@link User} object, or NULL
     */
    public User getUserData() {
        Log.d(TAG, "getUserData: hit");

        if(context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,
                    Context.MODE_PRIVATE);

            boolean hasSavedAccessToken = sharedPreferences.contains(ACCESS_TOKEN_KEY);
            boolean hasSavedExpiresIn = sharedPreferences.contains(EXPIRES_IN_KEY);
            if(hasSavedAccessToken && hasSavedExpiresIn) {
                String accessTokenStr = sharedPreferences.getString(ACCESS_TOKEN_KEY, "");
                int expiresIn = sharedPreferences.getInt(EXPIRES_IN_KEY, 0);
                AccessToken accessToken = new AccessToken(accessTokenStr, expiresIn);

                return new User(accessToken);
            } else {
                Log.e(TAG, "getUserData: missing user info");
            }
        } else {
            Log.e(TAG, "getUserData: context is NULL");
        }


        return null;
    }
}
