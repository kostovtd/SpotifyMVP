package com.kostovtd.spotifymvp.manager;

import com.kostovtd.spotifymvp.model.AlbumsResponse;

/**
 * Created by kostovtd on 04.07.17.
 */

public interface AlbumsManagerListener {

    void onAlbumsAvailable(AlbumsResponse albumsResponse);

}
