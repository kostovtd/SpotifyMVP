package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 14.07.17.
 */

public class PlaylistsResponse {

    private Playlists playlists;


    public PlaylistsResponse(Playlists playlists) {
        this.playlists = playlists;
    }


    public Playlists getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }
}
