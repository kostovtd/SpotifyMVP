package com.kostovtd.spotifymvp.presenter;

import com.kostovtd.spotifymvp.base.BasePresenter;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

/**
 * Created by kostovtd on 21.06.17.
 */

public interface UserPresenter extends BasePresenter {

    void authenticate();
    void successfulAuthentication(AuthenticationResponse response);

}
