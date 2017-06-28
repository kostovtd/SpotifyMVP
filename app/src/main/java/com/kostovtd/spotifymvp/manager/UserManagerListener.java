package com.kostovtd.spotifymvp.manager;

import com.kostovtd.spotifymvp.base.BaseManagerListener;
import com.kostovtd.spotifymvp.model.UserProfile;

/**
 * Created by kostovtd on 28.06.17.
 */

public interface UserManagerListener extends BaseManagerListener {

    void onUserProfileDataAvailable(UserProfile userProfile);

}
