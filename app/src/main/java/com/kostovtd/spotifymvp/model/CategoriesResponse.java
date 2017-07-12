package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 12.07.17.
 */

public class CategoriesResponse {

    private Categories categories;


    public CategoriesResponse(Categories categories) {
        this.categories = categories;
    }


    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
