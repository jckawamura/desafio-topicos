package com.example.jorge.desafio1.network;

import com.example.jorge.desafio1.entity.SocialActionDetailEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Jorge on 17/12/2017.
 */

interface DesafioService {
    @GET("acoes_sociais")
    Call<SocialActionDetailEntity> getSocialActionDetail
            (@Header("Authorization") String sessionToken,
             @Query("id") long id);
}
