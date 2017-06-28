package com.kostovtd.spotifymvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.model.UserProfile;
import com.kostovtd.spotifymvp.presenter.ProfilePresenter;
import com.kostovtd.spotifymvp.presenter.ProfilePresenterImpl;

import butterknife.ButterKnife;

/**
 * Created by kostovtd on 28.06.17.
 */
public class ProfileActivity extends AppCompatActivity implements ProfileView {

    private static final String TAG = ProfileActivity.class.getSimpleName();

    private ProfilePresenter profilePresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        setTitle(R.string.profile_screen_title);

        ButterKnife.bind(this);

        profilePresenter = new ProfilePresenterImpl(this, this);

        profilePresenter.fetchProfileData();
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
    public void showProfileData(UserProfile userProfile) {
        Log.d(TAG, "showProfileData: hit");
    }
}