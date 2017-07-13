package com.kostovtd.spotifymvp.view;

import com.kostovtd.spotifymvp.base.BaseView;
import com.kostovtd.spotifymvp.model.Playlist;

import java.util.List;

/**
 * Created by kostovtd on 13.07.17.
 */

public interface PlaylistsView extends BaseView {

    void showPlaylists(List<Playlist> playlistItems);

}
