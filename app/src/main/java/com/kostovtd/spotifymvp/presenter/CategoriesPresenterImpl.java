package com.kostovtd.spotifymvp.presenter;

import android.content.Context;

/**
 * Created by kostovtd on 12.07.17.
 */

public class CategoriesPresenterImpl implements CategoriesPresenter {

    private static final String TAG = CategoriesPresenterImpl.class.getSimpleName();


    private Context context;


    public CategoriesPresenterImpl(Context context) {
        this.context = context;
    }


}
