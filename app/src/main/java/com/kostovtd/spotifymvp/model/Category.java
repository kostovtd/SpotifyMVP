package com.kostovtd.spotifymvp.model;

import java.util.List;

/**
 * Created by kostovtd on 12.07.17.
 */

public class Category {

    private String id;
    private String href;
    private List<Image> icons;
    private String name;


    public Category(String id, String href, List<Image> icons, String name) {
        this.id = id;
        this.href = href;
        this.icons = icons;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Image> getIcons() {
        return icons;
    }

    public void setIcons(List<Image> icons) {
        this.icons = icons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
