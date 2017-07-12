package com.kostovtd.spotifymvp.presenter;

import com.kostovtd.spotifymvp.base.BasePresenter;

/**
 * Created by kostovtd on 27.06.17.
 */

public interface MainPresenter extends BasePresenter {

    void navigateToProfileScreen();
    void navigateToAlbumsScreen();
    void navigateToCategoriesScreen();
}
