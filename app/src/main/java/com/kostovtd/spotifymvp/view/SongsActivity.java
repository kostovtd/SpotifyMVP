package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.adapter.TracksAdapter;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.model.Album;
import com.kostovtd.spotifymvp.model.TrackItem;
import com.kostovtd.spotifymvp.model.Tracks;
import com.kostovtd.spotifymvp.presenter.SongsPresenter;
import com.kostovtd.spotifymvp.presenter.SongsPresenterImpl;
import com.kostovtd.spotifymvp.util.KeyUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 06.07.17.
 */
public class SongsActivity extends BaseActivity implements SongsView {

    private static final String TAG = SongsActivity.class.getSimpleName();

    private SongsPresenter presenter;
    private TracksAdapter tracksAdapter;

    @BindView(R.id.text_no_items)
    TextView textNoItems;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(R.string.songs_screen_title);

        ButterKnife.bind(this);

        presenter = new SongsPresenterImpl(this, this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            Album selectedAlbum = extractAlbumDataFromBundle(bundle);
            showAllAlbumTracks(selectedAlbum);
        }
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


    private Album extractAlbumDataFromBundle(Bundle bundle) {
        Log.d(TAG, "extractExtraDataFromBundle: hit");

        boolean hasSelectedAlbumKey = bundle.containsKey(KeyUtils.SELECTED_ALBUM_KEY);

        if(hasSelectedAlbumKey) {
            return bundle.getParcelable(KeyUtils.SELECTED_ALBUM_KEY);
        }

        return null;
    }


    /**
     * Populate all {@link com.kostovtd.spotifymvp.model.TrackItem}
     * into a {@link RecyclerView}
     * @param album
     */
    private void showAllAlbumTracks(Album album) {
        Log.d(TAG, "showAllAlbumSongs: hit");

        Tracks tracks = album.getTracks();
        List<TrackItem> trackItems = tracks.getItemList();

        if(tracksAdapter == null) {
            tracksAdapter = new TracksAdapter(this, trackItems);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(tracksAdapter);
        } else {
            tracksAdapter.setTrackItems(trackItems);
            tracksAdapter.notifyDataSetChanged();
        }
    }
}