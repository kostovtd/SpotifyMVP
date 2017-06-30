package com.kostovtd.spotifymvp.presenter;

import android.content.Context;
import android.util.Log;

import com.kostovtd.spotifymvp.manager.UserManager;
import com.kostovtd.spotifymvp.manager.UserManagerListener;
import com.kostovtd.spotifymvp.model.UserProfile;
import com.kostovtd.spotifymvp.view.ProfileView;

/**
 * Created by kostovtd on 28.06.17.
 */

public class ProfilePresenterImpl implements ProfilePresenter {

    private static final String TAG = ProfilePresenterImpl.class.getSimpleName();

    private Context context;
    private ProfileView profileView;


    public ProfilePresenterImpl(Context context, ProfileView profileView) {
        this.context = context;
        this.profileView = profileView;
    }


    @Override
    public void fetchProfileData() {
        Log.d(TAG, "fetchProfileData: hit");

        if(context != null) {
            final UserManager userManager = new UserManager(context);

            // set listener
            userManager.setListener(new UserManagerListener() {
                @Override
                public void onUserProfileDataAvailable(UserProfile userProfile) {
                    Log.d(TAG, "onUserProfileDataAvailable: hit");

                    profileView.hideProgressBar();

                    if(userProfile != null) {
                        if(profileView != null) {
                            profileView.showProfileData(userProfile);
                        } else {
                            Log.e(TAG, "onUserProfileDataAvailable: view is NULL");
                        }
                    } else {
                        Log.e(TAG, "onUserProfileDataAvailable: userProfile is NULL");
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    Log.d(TAG, "onError: hit");
                }
            });

            profileView.showProgressBar();

            // execute the network call
            userManager.fetchUserData();
        } else {
            Log.e(TAG, "fetchProfileData: context is NULL");
        }
    }
}
