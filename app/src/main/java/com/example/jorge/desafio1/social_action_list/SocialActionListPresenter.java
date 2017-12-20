package com.example.jorge.desafio1.social_action_list;

import com.example.jorge.desafio1.entity.SocialActionEntity;
import com.example.jorge.desafio1.entity.SocialActionListEntity;
import com.example.jorge.desafio1.network.DesafioApi;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by elise on 20/12/2017.
 */

class SocialActionListPresenter {
    private SocialActionListView socialActionListView;
    private List<SocialActionEntity> socialActionEntities = new ArrayList<>();
    SocialActionListEntity socialActionListEntity;

    SocialActionListPresenter(SocialActionListView socialActionListView) {
        this.socialActionListView = socialActionListView;
    }

    public void updateList() {
        final DesafioApi desafioApi = DesafioApi.getInstance();
        socialActionListView.showLoading();
        desafioApi.getSocialActionList().enqueue(new Callback<SocialActionListEntity>() {
            @Override
            public void onResponse(Call<SocialActionListEntity> call, Response<SocialActionListEntity> response) {
                socialActionListEntity = response.body();
                socialActionListView.updateList(socialActionListEntity.getSocialActionEntities());
                socialActionListView.hideLoading();
            }

            @Override
            public void onFailure(Call<SocialActionListEntity> call, Throwable t) {
                socialActionListView.hideLoading();
                socialActionListView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

    public void saveSocialActions() {
        String jsonSocialActionEntity = new Gson().toJson(socialActionListEntity);
        socialActionListView.saveSocialActionSharedPreferences(jsonSocialActionEntity);
    }
}
