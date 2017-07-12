package com.kostovtd.spotifymvp.manager;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.interactor.CategoriesInteractor;
import com.kostovtd.spotifymvp.interactor.CategoriesResponseHandler;
import com.kostovtd.spotifymvp.model.CategoriesResponse;
import com.kostovtd.spotifymvp.util.Is;

/**
 * Created by kostovtd on 12.07.17.
 */

public class CategoriesManager {

    private static final String TAG = CategoriesManager.class.getSimpleName();

    private Context context;
    private CategoriesManagerListener listener;


    public CategoriesManager(Context context) {
        this.context = context;
    }

    public CategoriesManager(Context context, CategoriesManagerListener listener) {
        this.context = context;
        this.listener = listener;
    }


    public void fetchCategories(String accessToken) {
        Log.d(TAG, "fetchCategories: hit");

        if(context == null) {
            Log.e(TAG, "fetchCategories: context is NULL");
            return;
        }

        if(Is.empty(accessToken)) {
            Log.e(TAG, "fetchCategories: accessToken is EMPTY");
            return;
        }

        CategoriesInteractor interactor = new CategoriesInteractor();

        interactor.setResponseHandler(new CategoriesResponseHandler() {
            @Override
            public void onCategoriesFetchedSuccessfully(CategoriesResponse categoriesResponse) {
                if(listener == null) {
                    Log.e(TAG, "onCategoriesFetchedSuccessfully: listener is NULL");
                    return;
                }

                listener.onCategoriesAvailable(categoriesResponse);
            }

            @Override
            public void onErrorReceived(int errorCode) {

            }

            @Override
            public void onMaxRetryReached() {

            }
        });

        interactor.fetchCategories(accessToken);
    }


    public void setListener(CategoriesManagerListener listener) {
        this.listener = listener;
    }
}
