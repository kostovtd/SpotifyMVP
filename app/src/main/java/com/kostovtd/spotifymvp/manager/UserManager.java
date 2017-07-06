package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.kostovtd.spotifymvp.interactor.UserInteractor;
import com.kostovtd.spotifymvp.interactor.UserResponseHandler;
import com.kostovtd.spotifymvp.model.AccessToken;
import com.kostovtd.spotifymvp.model.User;
import com.kostovtd.spotifymvp.model.UserProfile;
import com.kostovtd.spotifymvp.util.KeyUtils;

/**
 * Created by kostovtd on 23.06.17.
 */

public class UserManager {

    private static final String TAG = UserManager.class.getSimpleName();
    private static final String SHARED_PREFERENCES_NAME = "com.kostovtd.spotifymvp";

    private Context context;
    private UserManagerListener listener;


    public UserManager(Context context) {
        this.context = context;
    }

    public UserManager(Context context, UserManagerListener listener) {
        this.context = context;
        this.listener = listener;
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
                    editor.putString(KeyUtils.ACCESS_TOKEN_KEY, user.getAccessToken().getToken());
                    editor.putInt(KeyUtils.EXPIRES_IN_KEY, user.getAccessToken().getExpiresIn());
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

            boolean hasSavedAccessToken = sharedPreferences.contains(KeyUtils.ACCESS_TOKEN_KEY);
            boolean hasSavedExpiresIn = sharedPreferences.contains(KeyUtils.EXPIRES_IN_KEY);
            if(hasSavedAccessToken && hasSavedExpiresIn) {
                String accessTokenStr = sharedPreferences.getString(KeyUtils.ACCESS_TOKEN_KEY, "");
                int expiresIn = sharedPreferences.getInt(KeyUtils.EXPIRES_IN_KEY, 0);
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


    public void fetchUserData() {
        Log.d(TAG, "fetchUserData: hit");

        User user = getUserData();

        if(user != null) {
            UserInteractor userInteractor = new UserInteractor();

            userInteractor.setResponseHandler(new UserResponseHandler() {
                @Override
                public void onUserProfileDataFetchedSuccessfully(UserProfile userProfile) {
                    if(listener != null) {
                        listener.onUserProfileDataAvailable(userProfile);
                    } else {
                        Log.i(TAG, "listener is NULL");
                    }
                }

                @Override
                public void onErrorReceived(int errorCode) {

                }

                @Override
                public void onMaxRetryReached() {

                }
            });

            String accessToken = user.getAccessToken().getToken();
            userInteractor.fetchUserProfileData(accessToken);
        }
    }


    public void setListener(UserManagerListener listener) {
        this.listener = listener;
    }
}
