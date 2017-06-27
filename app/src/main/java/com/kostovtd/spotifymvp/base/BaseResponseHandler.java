package com.kostovtd.spotifymvp.base;

/**
 * Created by kostovtd on 27.06.17.
 */

public interface BaseResponseHandler {

    void onErrorReceived(int errorCode);
    void onMaxRetryReached();
}
