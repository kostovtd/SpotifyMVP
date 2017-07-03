package com.kostovtd.spotifymvp.model;

import java.util.List;

/**
 * Created by kostovtd on 03.07.17.
 */

public class AlbumResponse {

    private String href;

    private List<AlbumItem> items;


    public AlbumResponse(String href, List<AlbumItem> items) {
        this.href = href;
        this.items = items;
    }


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<AlbumItem> getItems() {
        return items;
    }

    public void setItems(List<AlbumItem> items) {
        this.items = items;
    }
}
