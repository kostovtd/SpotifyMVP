package com.kostovtd.spotifymvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostovtd on 04.07.17.
 */

public class Tracks {

    @SerializedName("items")
    private List<TrackItem> itemList;


    public Tracks(List<TrackItem> itemList) {
        this.itemList = itemList;
    }


    public List<TrackItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TrackItem> itemList) {
        this.itemList = itemList;
    }
}
