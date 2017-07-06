package com.kostovtd.spotifymvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kostovtd on 03.07.17.
 */

public class Artist implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.href);
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    protected Artist(Parcel in) {
        this.href = in.readString();
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel source) {
            return new Artist(source);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
