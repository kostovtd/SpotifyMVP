package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.adapter.CategoriesAdapter;
import com.kostovtd.spotifymvp.adapter.CategoriesAdapterListener;
import com.kostovtd.spotifymvp.adapter.PlaylistsAdapter;
import com.kostovtd.spotifymvp.adapter.PlaylistsAdapterListener;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.model.Album;
import com.kostovtd.spotifymvp.model.Playlist;
import com.kostovtd.spotifymvp.presenter.PlaylistsPresenter;
import com.kostovtd.spotifymvp.presenter.PlaylistsPresenterImpl;
import com.kostovtd.spotifymvp.util.KeyUtils;
import com.kostovtd.spotifymvp.util.SizeUtil;
import com.kostovtd.spotifymvp.util.SpacesItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 13.07.17.
 */
public class PlaylistsActivity extends BaseActivity implements PlaylistsView, PlaylistsAdapterListener {

    private static final String TAG = PlaylistsActivity.class.getSimpleName();

    private PlaylistsAdapter playlistsAdapter;
    private PlaylistsPresenter presenter;

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

        presenter = new PlaylistsPresenterImpl(this, this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            String categoryId = extractCategoryDataFromBundle(bundle);
            presenter.fetchPlaylists(categoryId);
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
        return R.layout.playlists_layout;
    }


    @Override
    public void showPlaylists(List<Playlist> playlistItems) {
        Log.d(TAG, "showPlaylists: hit");

        if(playlistItems == null || playlistItems.size() == 0) {
            Log.e(TAG, "showPlaylists: playlistItems is NULL");
            textNoItems.setVisibility(View.VISIBLE);
            return;
        } else {
            textNoItems.setVisibility(View.GONE);
        }


        if(playlistsAdapter == null) {
            playlistsAdapter = new PlaylistsAdapter(this, playlistItems);
            playlistsAdapter.setListener(this);

            int rightDp = (int) SizeUtil.convertPixelsToDp(150, this);
            int topDp = (int) SizeUtil.convertPixelsToDp(50, this);
            int bottomDp = (int) SizeUtil.convertPixelsToDp(100, this);
            recyclerView.addItemDecoration(new SpacesItemDecoration(0, rightDp, topDp, bottomDp));

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(playlistsAdapter);
        } else {
            playlistsAdapter.setPlaylists(playlistItems);
            playlistsAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onPlaylistSelected(Playlist playlist) {
        Log.d(TAG, "onPlaylistSelected: hit");
    }


    private String extractCategoryDataFromBundle(Bundle bundle) {
        Log.d(TAG, "extractCategoryDataFromBundle: hit");

        boolean hasSelectedCategoryIdKey = bundle.containsKey(KeyUtils.SELECTED_CATEGORY_ID_KEY);

        if(hasSelectedCategoryIdKey) {
            return bundle.getString(KeyUtils.SELECTED_CATEGORY_ID_KEY);
        }

        return "";
    }
}