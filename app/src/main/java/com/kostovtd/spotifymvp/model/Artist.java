package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 03.07.17.
 */

public class Artist {

    private String href;

    private String id;

    private String name;


    public Artist(String href, String id, String name) {
        this.href = href;
        this.id = id;
        this.name = name;
    }


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
