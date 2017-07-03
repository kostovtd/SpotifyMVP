package com.kostovtd.spotifymvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.base.BaseActivity;

/**
 * Created by kostovtd on 03.07.17.
 */
public class AlbumsActivity extends BaseActivity implements AlbumsView {

    private static final String TAG = AlbumsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(R.string.albums_screen_title);
    }


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: hit");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: hit");
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: hit");
        super.onDestroy();
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.albums_layout;
    }
}