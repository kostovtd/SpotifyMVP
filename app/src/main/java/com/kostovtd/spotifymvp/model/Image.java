package com.kostovtd.spotifymvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kostovtd on 28.06.17.
 */

public class Image implements Parcelable {

    private int height;
    private int width;
    private String url;


    public Image(int height, int width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.height);
        dest.writeInt(this.width);
        dest.writeString(this.url);
    }

    protected Image(Parcel in) {
        this.height = in.readInt();
        this.width = in.readInt();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
