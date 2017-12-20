package com.example.jorge.desafio1.network;

import com.example.jorge.desafio1.entity.SocialActionDetailEntity;
import com.example.jorge.desafio1.entity.SocialActionListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Jorge on 17/12/2017.
 */

interface DesafioService {
    @GET("sociais.json")
    Call<SocialActionListEntity> getSocialActionList();

    @GET("sociais.json")
    Call<SocialActionDetailEntity> getSocialActionDetail
            (@Query("id") long id);

}
