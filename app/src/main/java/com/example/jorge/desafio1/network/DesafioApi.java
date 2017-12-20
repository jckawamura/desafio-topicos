package com.example.jorge.desafio1.network;

import com.example.jorge.desafio1.entity.SocialActionDetailEntity;
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
    private String sessionToken;
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/sociais.json";

    private DesafioApi() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(defaultConvertFactory())
                .build();
    }

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

    public Call<SocialActionDetailEntity> getSocialActionDetail(long id) {
        return desafioService.getSocialActionDetail(sessionToken, id);
    }
}