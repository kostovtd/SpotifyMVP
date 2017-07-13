package com.kostovtd.spotifymvp.model;

import java.util.List;

/**
 * Created by kostovtd on 13.07.17.
 */

public class Playlists {

    private List<Playlist> items;


    public Playlists(List<Playlist> items) {
        this.items = items;
    }


    public List<Playlist> getItems() {
        return items;
    }

    public void setItems(List<Playlist> items) {
        this.items = items;
    }
}
