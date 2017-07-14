package com.kostovtd.spotifymvp.manager;

import com.kostovtd.spotifymvp.model.CategoriesResponse;
import com.kostovtd.spotifymvp.model.Playlists;
import com.kostovtd.spotifymvp.model.PlaylistsResponse;

/**
 * Created by kostovtd on 13.07.17.
 */

public interface PlaylistsManagerListener {

    void onPlaylistsAvailable(PlaylistsResponse playlistsResponse);

}
