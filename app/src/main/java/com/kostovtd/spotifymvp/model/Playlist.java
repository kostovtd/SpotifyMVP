package com.kostovtd.spotifymvp.model;

import java.util.List;

/**
 * Created by kostovtd on 13.07.17.
 */

public class Playlist {

    private String id;
    private List<Image> images;
    private String name;


    public Playlist(String id, List<Image> images, String name) {
        this.id = id;
        this.images = images;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
