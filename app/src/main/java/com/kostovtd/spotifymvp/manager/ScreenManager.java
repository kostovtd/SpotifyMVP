package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.kostovtd.spotifymvp.view.AlbumsActivity;
import com.kostovtd.spotifymvp.view.MainActivity;
import com.kostovtd.spotifymvp.view.ProfileActivity;

/**
 * Created by kostovtd on 23.06.17.
 */

public class ScreenManager {

    private static final String TAG = ScreenManager.class.getSimpleName();

    /**
     * Navigate to {@link MainActivity}
     */
    public static void navigateToMainScreen(Context context) {
        Log.d(TAG, "navigateToMainScreen: hit");

        if(context != null) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } else {
            Log.e(TAG, "navigateToMainScreen: context is NULL");
        }
    }


    /**
     * Navigate to {@link ProfileActivity}
     * @param context
     */
    public static void navigateToProfileScreen(Context context) {
        Log.d(TAG, "navigateToProfileScreen: hit");

        if(context != null) {
            Intent intent = new Intent(context, ProfileActivity.class);
            context.startActivity(intent);
        } else {
            Log.e(TAG, "navigateToProfileScreen: context is NULL");
        }
    }


    /**
     * Navigate to {@link AlbumsActivity}
     * @param context
     */
    public static void navigateToAlbumsScreen(Context context) {
        Log.d(TAG, "navigateToAlbumsScreen: hit");

        if(context != null) {
            Intent intent = new Intent(context, AlbumsActivity.class);
            context.startActivity(intent);
        } else {
            Log.e(TAG, "navigateToAlbumsScreen: context is NULL");
        }
    }
}
