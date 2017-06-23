package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.kostovtd.spotifymvp.view.MainActivity;

/**
 * Created by kostovtd on 23.06.17.
 */

public class ScreenManager {

    private static final String TAG = ScreenManager.class.getSimpleName();


    private Context context;


    public ScreenManager(Context context) {
        this.context = context;
    }


    /**
     * Navigate to {@link MainActivity}
     */
    public void navigateToMainScreen() {
        Log.d(TAG, "navigateToMainScreen: hit");

        if(context != null) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } else {
            Log.e(TAG, "navigateToMainScreen: context is NULL");
        }
    }
}
