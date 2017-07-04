package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.model.AlbumItem;
import com.kostovtd.spotifymvp.presenter.AlbumsPresenter;
import com.kostovtd.spotifymvp.presenter.AlbumsPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 03.07.17.
 */
public class AlbumsActivity extends BaseActivity implements AlbumsView {

    private static final String TAG = AlbumsActivity.class.getSimpleName();

    private AlbumsPresenter presenter;

    @BindView(R.id.text_no_items)
    TextView textNoItems;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(R.string.albums_screen_title);

        ButterKnife.bind(this);

        presenter = new AlbumsPresenterImpl(this, this);

        presenter.fetchAlbums();
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


    @Override
    public void showAlbums(List<AlbumItem> albumItems) {

    }
}