package com.kostovtd.spotifymvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostovtd on 03.07.17.
 */

public class TrackItem {

    private List<Artist> artists;

    private boolean explicit;

    private String href;

    private String id;

    private String name;

    @SerializedName("available_markets")
    private List<String> availableMarkets;

    @SerializedName("duration_ms")
    private long durationMs;


    public TrackItem(List<Artist> artists, boolean explicit,
                     String href, String id, String name,
                     List<String> availableMarkets, long durationMs) {
        this.artists = artists;
        this.explicit = explicit;
        this.href = href;
        this.id = id;
        this.name = name;
        this.availableMarkets = availableMarkets;
        this.durationMs = durationMs;
    }


    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
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

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(long durationMs) {
        this.durationMs = durationMs;
    }
}
