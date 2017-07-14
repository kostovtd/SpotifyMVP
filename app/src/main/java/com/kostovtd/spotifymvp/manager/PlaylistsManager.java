package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.interactor.PlaylistsInteractor;
import com.kostovtd.spotifymvp.interactor.PlaylistsResponseHandler;
import com.kostovtd.spotifymvp.model.PlaylistsResponse;
import com.kostovtd.spotifymvp.util.Is;

/**
 * Created by kostovtd on 13.07.17.
 */

public class PlaylistsManager {

    private static final String TAG = PlaylistsManager.class.getSimpleName();

    private Context context;
    private PlaylistsManagerListener listener;


    public PlaylistsManager(Context context) {
        this.context = context;
    }

    public PlaylistsManager(Context context, PlaylistsManagerListener listener) {
        this.context = context;
        this.listener = listener;
    }


    public void fetchPlaylists(String accessToken, String categoryId) {
        Log.d(TAG, "fetchPlaylists: hit");

        if(context == null) {
            Log.e(TAG, "fetchPlaylists: context is NULL");
            return;
        }

        if(Is.empty(accessToken)) {
            Log.e(TAG, "fetchPlaylists: accessToken is EMPTY");
            return;
        }

        if(Is.empty(categoryId)) {
            Log.e(TAG, "fetchPlaylists: categoryId is NULL or EMPTY");
            return;
        }


        PlaylistsInteractor interactor = new PlaylistsInteractor();

        interactor.setResponseHandler(new PlaylistsResponseHandler() {
            @Override
            public void onPlaylistsFetchedSuccessfully(PlaylistsResponse playlistsResponse) {
                if(listener == null) {
                    Log.e(TAG, "onPlaylistsFetchedSuccessfully: listener is NULL");
                    return;
                }

                listener.onPlaylistsAvailable(playlistsResponse);
            }

            @Override
            public void onErrorReceived(int errorCode) {

            }

            @Override
            public void onMaxRetryReached() {

            }
        });

        interactor.fetchPlaylists(accessToken, categoryId);
    }


    public void setListener(PlaylistsManagerListener listener) {
        this.listener = listener;
    }


}
