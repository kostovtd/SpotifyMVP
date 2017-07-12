package com.kostovtd.spotifymvp.view;

import com.kostovtd.spotifymvp.base.BaseView;
import com.kostovtd.spotifymvp.model.Category;

import java.util.List;

/**
 * Created by kostovtd on 12.07.17.
 */

public interface CategoriesView extends BaseView {

    void showCategories(List<Category> categories);

}
