package com.kostovtd.spotifymvp.interactor;

import com.kostovtd.spotifymvp.base.BaseResponseHandler;
import com.kostovtd.spotifymvp.model.UserProfileResponse;

/**
 * Created by kostovtd on 27.06.17.
 */

public interface UserResponseHandler extends BaseResponseHandler {

    void onUserProfileDataFetchedSuccessfully(UserProfileResponse userProfileResponse);


}
