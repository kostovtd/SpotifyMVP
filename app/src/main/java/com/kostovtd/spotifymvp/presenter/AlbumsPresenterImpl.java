package com.kostovtd.spotifymvp.presenter;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.manager.AlbumsManager;
import com.kostovtd.spotifymvp.manager.AlbumsManagerListener;
import com.kostovtd.spotifymvp.manager.UserManager;
import com.kostovtd.spotifymvp.model.AlbumItem;
import com.kostovtd.spotifymvp.model.AlbumsResponse;
import com.kostovtd.spotifymvp.model.User;
import com.kostovtd.spotifymvp.util.Is;
import com.kostovtd.spotifymvp.view.AlbumsView;

import java.util.List;

/**
 * Created by kostovtd on 03.07.17.
 */

public class AlbumsPresenterImpl implements AlbumsPresenter {

    private static final String TAG = AlbumsPresenterImpl.class.getSimpleName();

    private Context context;
    private AlbumsView albumsView;


    public AlbumsPresenterImpl(Context context, AlbumsView albumsView) {
        this.context = context;
        this.albumsView = albumsView;
    }


    @Override
    public void fetchAlbums() {
        Log.d(TAG, "fetchAlbums: hit");

        if(context == null) {
            Log.e(TAG, "fetchAlbums: context is NULL");
            return;
        }

        UserManager userManager = new UserManager(context);
        User user = userManager.getUserData();

        if(user == null) {
            Log.e(TAG, "fetchAlbums: user is NULL");
            return;
        }

        String accessToken = user.getAccessToken().getToken();

        if(Is.empty(accessToken)) {
            Log.e(TAG, "fetchAlbums: accessToken is NULL or EMPTY");
            return;
        }

        final AlbumsManager albumsManager = new AlbumsManager(context);

        albumsManager.setListener(new AlbumsManagerListener() {
            @Override
            public void onAlbumsAvailable(AlbumsResponse albumsResponse) {
                albumsView.hideProgress();

                if(albumsResponse == null) {
                    Log.e(TAG, "onAlbumsAvailable: albumsResponse is NULL");
                    return;
                }

                List<AlbumItem> albumItems = albumsResponse.getItems();
                albumsView.showAlbums(albumItems);
            }
        });

        albumsView.showProgress();
        albumsManager.fetchAlbums(accessToken);
    }
}
