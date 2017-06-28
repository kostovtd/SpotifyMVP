package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 28.06.17.
 */

public class Followers {

    private String href;
    private int total;


    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
