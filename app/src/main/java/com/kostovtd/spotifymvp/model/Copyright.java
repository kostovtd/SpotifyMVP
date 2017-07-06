package com.kostovtd.spotifymvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kostovtd on 03.07.17.
 */

public class Copyright implements Parcelable {

    private String text;

    private String type;


    public Copyright(String text, String type) {
        this.text = text;
        this.type = type;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeString(this.type);
    }

    protected Copyright(Parcel in) {
        this.text = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Copyright> CREATOR = new Parcelable.Creator<Copyright>() {
        @Override
        public Copyright createFromParcel(Parcel source) {
            return new Copyright(source);
        }

        @Override
        public Copyright[] newArray(int size) {
            return new Copyright[size];
        }
    };
}
