package com.kostovtd.spotifymvp.presenter;

import com.kostovtd.spotifymvp.base.BasePresenter;

/**
 * Created by kostovtd on 13.07.17.
 */

public interface PlaylistsPresenter extends BasePresenter {

    void fetchPlaylists(String categoryId);

}
