package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.interactor.AlbumsInteractor;
import com.kostovtd.spotifymvp.interactor.AlbumsResponseHandler;
import com.kostovtd.spotifymvp.model.AlbumsResponse;
import com.kostovtd.spotifymvp.util.Is;

/**
 * Created by kostovtd on 04.07.17.
 */

public class AlbumsManager {

    private static final String TAG = AlbumsManager.class.getSimpleName();

    private Context context;
    private AlbumsManagerListener listener;


    public AlbumsManager(Context context) {
        this.context = context;
    }

    public AlbumsManager(Context context, AlbumsManagerListener listener) {
        this.context = context;
        this.listener = listener;
    }


    public void setListener(AlbumsManagerListener listener) {
        this.listener = listener;
    }


    public void fetchAlbums(String accessToken) {
        Log.d(TAG, "fetchAlbums: hit");

        if(context == null) {
            Log.e(TAG, "fetchAlbums: context is NULL");
            return;
        }

        if(Is.empty(accessToken)) {
            Log.e(TAG, "fetchAlbums: accessToken is NULL or EMPTY");
            return;
        }


        AlbumsInteractor albumsInteractor = new AlbumsInteractor();

        albumsInteractor.setResponseHandler(new AlbumsResponseHandler() {
            @Override
            public void onAlbumsFetchedSuccessfully(AlbumsResponse albumsResponse) {
                if(listener == null) {
                    Log.e(TAG, "onAlbumsFetchedSuccessfully: listener is NULL");
                    return;
                }

                listener.onAlbumsAvailable(albumsResponse);
            }

            @Override
            public void onErrorReceived(int errorCode) {

            }

            @Override
            public void onMaxRetryReached() {

            }
        });

        albumsInteractor.fetchAlbums(accessToken);
    }
}
