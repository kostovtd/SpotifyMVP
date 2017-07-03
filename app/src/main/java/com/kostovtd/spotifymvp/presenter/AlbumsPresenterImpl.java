package com.kostovtd.spotifymvp.presenter;

import android.content.Context;

/**
 * Created by kostovtd on 03.07.17.
 */

public class AlbumsPresenterImpl implements AlbumsPresenter {

    private static final String TAG = AlbumsPresenterImpl.class.getSimpleName();

    private Context context;


    public AlbumsPresenterImpl(Context context) {
        this.context = context;
    }
}
