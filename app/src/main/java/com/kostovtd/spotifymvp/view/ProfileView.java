package com.kostovtd.spotifymvp.view;

import com.kostovtd.spotifymvp.base.BaseView;
import com.kostovtd.spotifymvp.model.UserProfile;

/**
 * Created by kostovtd on 28.06.17.
 */

public interface ProfileView extends BaseView {

    void showProfileData(UserProfile userProfile);

}
