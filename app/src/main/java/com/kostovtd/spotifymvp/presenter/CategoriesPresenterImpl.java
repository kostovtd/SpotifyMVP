package com.kostovtd.spotifymvp.presenter;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.manager.CategoriesManager;
import com.kostovtd.spotifymvp.manager.CategoriesManagerListener;
import com.kostovtd.spotifymvp.manager.ScreenManager;
import com.kostovtd.spotifymvp.manager.UserManager;
import com.kostovtd.spotifymvp.model.Categories;
import com.kostovtd.spotifymvp.model.CategoriesResponse;
import com.kostovtd.spotifymvp.model.Category;
import com.kostovtd.spotifymvp.model.User;
import com.kostovtd.spotifymvp.util.Is;
import com.kostovtd.spotifymvp.view.CategoriesView;

import java.util.List;

/**
 * Created by kostovtd on 12.07.17.
 */

public class CategoriesPresenterImpl implements CategoriesPresenter {

    private static final String TAG = CategoriesPresenterImpl.class.getSimpleName();


    private Context context;
    private CategoriesView categoriesView;


    public CategoriesPresenterImpl(Context context, CategoriesView categoriesView) {
        this.context = context;
        this.categoriesView = categoriesView;
    }


    @Override
    public void fetchCategories() {
        Log.d(TAG, "fetchCategories: hit");

        if(context == null) {
            Log.e(TAG, "fetchCategories: context is NULL");
            return;
        }

        if(categoriesView == null) {
            Log.e(TAG, "fetchCategories: categoriesView is NULL");
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

        CategoriesManager categoriesManager = new CategoriesManager(context);

        categoriesManager.setListener(new CategoriesManagerListener() {
            @Override
            public void onCategoriesAvailable(CategoriesResponse categoriesResponse) {
                categoriesView.hideProgress();

                if(categoriesResponse == null) {
                    Log.e(TAG, "onCategoriesAvailable: categoriesResponse is NULL");
                    return;
                }

                Categories categories = categoriesResponse.getCategories();
                if(categories != null) {
                    List<Category> categoriesList = categories.getCategories();
                    categoriesView.showCategories(categoriesList);
                } else {
                    Log.e(TAG, "onCategoriesAvailable: categories is NULL");
                }
            }
        });

        categoriesView.showProgress();
        categoriesManager.fetchCategories(accessToken);
    }


    @Override
    public void navigateToPlaylistsScreen() {
        Log.d(TAG, "navigateToPlaylistsScreen: hit");

        if(context == null) {
            Log.e(TAG, "navigateToPlaylistsScreen: context is NULL");
            return;
        }

        ScreenManager.navigateToPlaylistsScreen(context);
    }
}
