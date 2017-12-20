package com.example.jorge.desafio1.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jorge on 17/12/2017.
 */

public class SocialActionEntity {

    @SerializedName("id")
    @Expose
    private long id;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("image")
    @Expose
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
