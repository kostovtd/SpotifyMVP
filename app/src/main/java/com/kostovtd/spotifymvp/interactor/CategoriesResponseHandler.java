package com.kostovtd.spotifymvp.interactor;

import com.kostovtd.spotifymvp.base.BaseResponseHandler;
import com.kostovtd.spotifymvp.model.CategoriesResponse;

/**
 * Created by kostovtd on 12.07.17.
 */

public interface CategoriesResponseHandler extends BaseResponseHandler {

    void onCategoriesFetchedSuccessfully(CategoriesResponse categoriesResponse);

}
