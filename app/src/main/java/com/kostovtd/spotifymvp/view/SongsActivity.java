package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.util.Log;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.presenter.SongsPresenter;
import com.kostovtd.spotifymvp.presenter.SongsPresenterImpl;

import butterknife.ButterKnife;

/**
 * Created by kostovtd on 06.07.17.
 */
public class SongsActivity extends BaseActivity implements SongsView {

    private static final String TAG = SongsActivity.class.getSimpleName();

    private SongsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(R.string.songs_screen_title);

        ButterKnife.bind(this);

        presenter = new SongsPresenterImpl(this, this);
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
        return R.layout.songs_layout;
    }
}