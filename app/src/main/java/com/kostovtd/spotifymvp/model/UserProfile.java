package com.kostovtd.spotifymvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostovtd on 27.06.17.
 */

public class UserProfile {

    private String birthdate;
    private String country;
    private String email;
    private String product;
    private String type;
    private Followers followers;
    private String href;
    private String id;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("images")
    private List<Image> imageList;


    public UserProfile(String birthdate, String country, String email,
                       String product, String type, Followers followers,
                       String href, String id, String displayName, List<Image> imageList) {
        this.birthdate = birthdate;
        this.country = country;
        this.email = email;
        this.product = product;
        this.type = type;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.displayName = displayName;
        this.imageList = imageList;
    }


    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
