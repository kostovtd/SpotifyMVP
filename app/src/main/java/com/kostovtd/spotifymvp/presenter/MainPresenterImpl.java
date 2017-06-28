package com.kostovtd.spotifymvp.presenter;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.manager.ScreenManager;

/**
 * Created by kostovtd on 27.06.17.
 */

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = MainPresenterImpl.class.getSimpleName();


    private Context context;


    public MainPresenterImpl(Context context) {
        this.context = context;
    }


    @Override
    public void navigateToProfileScreen() {
        Log.d(TAG, "navigateToProfileScreen: hit");

        if(context == null) {
            Log.e(TAG, "navigateToProfileScreen: context is NULL");
            return;
        }

        ScreenManager.navigateToProfileScreen(context);
    }
}
