package com.kostovtd.spotifymvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostovtd on 03.07.17.
 */

public class Album {

    private String id;

    private List<Artist> artists;

    private List<Copyright> copyrights;

    private List<Image> images;

    private String name;

    private int popularity;

    private List<Track> tracks;

    @SerializedName("available_markets")
    private List<String> availableMarkets;

    @SerializedName("release_date")
    private String releaseDate;


    public Album(String id, List<Artist> artists, List<Copyright> copyrights,
                 List<Image> images, String name, int popularity, List<Track> tracks,
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

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
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
}
