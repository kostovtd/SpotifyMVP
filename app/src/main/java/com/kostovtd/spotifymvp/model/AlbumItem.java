package com.kostovtd.spotifymvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kostovtd on 03.07.17.
 */

public class AlbumItem {

    private Album album;

    @SerializedName("added_at")
    private String addedAt;


    public AlbumItem(Album album, String addedAt) {
        this.album = album;
        this.addedAt = addedAt;
    }


    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }
}
