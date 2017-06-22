package com.kostovtd.spotifymvp.presenter;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.util.Is;

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

    }

}
