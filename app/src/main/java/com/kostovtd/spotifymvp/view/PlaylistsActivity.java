package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 13.07.17.
 */
public class PlaylistsActivity extends BaseActivity implements PlaylistsView {

    private static final String TAG = PlaylistsActivity.class.getSimpleName();


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.text_no_items)
    TextView textNoItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(R.string.playlists_screen_title);

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


    @Override
    protected int getLayoutResourceId() {
        return R.layout.playlists_layout;
    }
}