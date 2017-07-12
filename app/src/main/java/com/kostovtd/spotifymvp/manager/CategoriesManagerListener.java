package com.kostovtd.spotifymvp.manager;

import com.kostovtd.spotifymvp.model.CategoriesResponse;

/**
 * Created by kostovtd on 12.07.17.
 */

public interface CategoriesManagerListener {

    void onCategoriesAvailable(CategoriesResponse categoriesResponse);

}
