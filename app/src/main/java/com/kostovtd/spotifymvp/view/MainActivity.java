package com.kostovtd.spotifymvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kostovtd.spotifymvp.R;

import butterknife.ButterKnife;

/**
 * Created by kostovtd on 23.06.17.
 */
public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle(R.string.main_screen_title);

        ButterKnife.bind(this);
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
}