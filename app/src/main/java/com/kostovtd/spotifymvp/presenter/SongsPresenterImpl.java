package com.kostovtd.spotifymvp.presenter;

import android.content.Context;

import com.kostovtd.spotifymvp.view.SongsView;

/**
 * Created by kostovtd on 06.07.17.
 */

public class SongsPresenterImpl implements SongsPresenter {

    private static final String TAG = SongsPresenterImpl.class.getSimpleName();

    private Context context;
    private SongsView songsView;


    public SongsPresenterImpl(Context context, SongsView songsView) {
        this.context = context;
        this.songsView = songsView;
    }
}
