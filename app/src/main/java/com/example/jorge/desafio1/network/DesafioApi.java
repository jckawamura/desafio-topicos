package com.example.jorge.desafio1.network;

import com.example.jorge.desafio1.entity.SocialActionDetailEntity;
import com.example.jorge.desafio1.entity.SocialActionListEntity;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jorge on 17/12/2017.
 */

public class DesafioApi {

    private static DesafioApi instance;
    private DesafioService desafioService;
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/";

    private DesafioApi() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(defaultConvertFactory())
                .build();

        this.desafioService = retrofit.create(DesafioService.class);
    }

    // cria Gson a ser adotado no retrofit
    private Converter.Factory defaultConvertFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }

    public static DesafioApi getInstance() {
        if (instance == null) {
            instance = new DesafioApi();
        }
        return instance;
    }

    public Call<SocialActionListEntity> getSocialActionList() {
        return desafioService.getSocialActionList();
    }

    public Call<SocialActionDetailEntity> getSocialActionDetail(long id) {
        return desafioService.getSocialActionDetail(id);
    }
}
