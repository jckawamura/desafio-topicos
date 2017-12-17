package com.example.jorge.desafio1.entity;

/**
 * Created by Jorge on 17/12/2017.
 */

public class SocialActionEntity {
    private long id;
    private String name;
    private String imageURL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
