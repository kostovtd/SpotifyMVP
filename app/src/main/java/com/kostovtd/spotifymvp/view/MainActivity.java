package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.presenter.MainPresenter;
import com.kostovtd.spotifymvp.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 23.06.17.
 */
public class MainActivity extends BaseActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter presenter;

    @BindView(R.id.view_profile_button)
    Button bViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setTitle(R.string.main_screen_title);

        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);

        bViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToProfileScreen();
            }
        });
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
        return R.layout.main_activity;
    }
}