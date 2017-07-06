package com.kostovtd.spotifymvp.presenter;

import com.kostovtd.spotifymvp.base.BasePresenter;
import com.kostovtd.spotifymvp.model.Album;

/**
 * Created by kostovtd on 03.07.17.
 */

public interface AlbumsPresenter extends BasePresenter {

    void fetchAlbums();
    void navigateToSongsScreen(Album album);
}
