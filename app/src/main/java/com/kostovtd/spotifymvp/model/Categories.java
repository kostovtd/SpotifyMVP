package com.kostovtd.spotifymvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostovtd on 12.07.17.
 */

public class Categories {

    private String href;

    @SerializedName("items")
    private List<Category> categories;


    public Categories(String href, List<Category> categories) {
        this.href = href;
        this.categories = categories;
    }


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
