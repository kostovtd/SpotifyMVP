package com.kostovtd.spotifymvp.interactor;

import com.kostovtd.spotifymvp.base.BaseResponseHandler;
import com.kostovtd.spotifymvp.model.AlbumsResponse;

/**
 * Created by kostovtd on 04.07.17.
 */

public interface AlbumsResponseHandler extends BaseResponseHandler {

    void onAlbumsFetchedSuccessfully(AlbumsResponse albumsResponse);

}
