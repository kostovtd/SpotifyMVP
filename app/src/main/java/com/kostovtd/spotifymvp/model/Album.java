package com.kostovtd.spotifymvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostovtd on 03.07.17.
 */

public class Album implements Parcelable {

    private String id;

    private List<Artist> artists;

    private List<Copyright> copyrights;

    private List<Image> images;

    private String name;

    private int popularity;

    private Tracks tracks;

    @SerializedName("available_markets")
    private List<String> availableMarkets;

    @SerializedName("release_date")
    private String releaseDate;


    public Album(String id, List<Artist> artists, List<Copyright> copyrights,
                 List<Image> images, String name, int popularity, Tracks tracks,
                 List<String> availableMarkets, String releaseDate) {
        this.id = id;
        this.artists = artists;
        this.copyrights = copyrights;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.tracks = tracks;
        this.availableMarkets = availableMarkets;
        this.releaseDate = releaseDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Copyright> getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(List<Copyright> copyrights) {
        this.copyrights = copyrights;
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

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeList(this.artists);
        dest.writeList(this.copyrights);
        dest.writeList(this.images);
        dest.writeString(this.name);
        dest.writeInt(this.popularity);
        dest.writeParcelable(this.tracks, flags);
        dest.writeStringList(this.availableMarkets);
        dest.writeString(this.releaseDate);
    }

    protected Album(Parcel in) {
        this.id = in.readString();
        this.artists = new ArrayList<Artist>();
        in.readList(this.artists, Artist.class.getClassLoader());
        this.copyrights = new ArrayList<Copyright>();
        in.readList(this.copyrights, Copyright.class.getClassLoader());
        this.images = new ArrayList<Image>();
        in.readList(this.images, Image.class.getClassLoader());
        this.name = in.readString();
        this.popularity = in.readInt();
        this.tracks = in.readParcelable(Tracks.class.getClassLoader());
        this.availableMarkets = in.createStringArrayList();
        this.releaseDate = in.readString();
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel source) {
            return new Album(source);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}
