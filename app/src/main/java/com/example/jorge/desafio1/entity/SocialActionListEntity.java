package com.example.jorge.desafio1.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jorge on 17/12/2017.
 */

public class SocialActionListEntity {

    @SerializedName("acoes_sociais")
    @Expose
    private List<SocialActionEntity> socialActionEntities = null;

    public List<SocialActionEntity> getSocialActionEntities() {
        return socialActionEntities;
    }
}
