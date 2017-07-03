package com.kostovtd.spotifymvp.model;

/**
 * Created by kostovtd on 03.07.17.
 */

public class Copyright {

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
}
