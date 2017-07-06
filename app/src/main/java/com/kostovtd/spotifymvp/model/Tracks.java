package com.kostovtd.spotifymvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostovtd on 04.07.17.
 */

public class Tracks implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.itemList);
    }

    protected Tracks(Parcel in) {
        this.itemList = new ArrayList<TrackItem>();
        in.readList(this.itemList, TrackItem.class.getClassLoader());
    }

    public static final Parcelable.Creator<Tracks> CREATOR = new Parcelable.Creator<Tracks>() {
        @Override
        public Tracks createFromParcel(Parcel source) {
            return new Tracks(source);
        }

        @Override
        public Tracks[] newArray(int size) {
            return new Tracks[size];
        }
    };
}
