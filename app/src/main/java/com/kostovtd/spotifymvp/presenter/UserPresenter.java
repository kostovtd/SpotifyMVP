package com.kostovtd.spotifymvp.presenter;

import com.kostovtd.spotifymvp.base.BasePresenter;

/**
 * Created by kostovtd on 21.06.17.
 */

public interface UserPresenter extends BasePresenter {

    void authenticate(String clientId);
    boolean validateUsername(String username);

}
