package com.example.jorge.desafio1.social_action_detail;

import com.example.jorge.desafio1.entity.SocialActionDetailEntity;
import com.example.jorge.desafio1.network.DesafioApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jorge on 17/12/2017.
 */

class SocialActionDetailPresenter {
    SocialActionDetailView socialActionDetailView;
    private SocialActionDetailEntity socialActionDetailEntity;

    public SocialActionDetailPresenter(SocialActionDetail socialActionDetail) {
        this.socialActionDetailView = socialActionDetail;
    }

    public void getSocialActionDetail(long socialActionId) {
        final DesafioApi desafioApi = DesafioApi.getInstance();
        socialActionDetailView.showLoading();
        desafioApi.getSocialActionDetail(socialActionId).enqueue(new Callback<SocialActionDetailEntity>() {
            @Override
            public void onResponse(Call<SocialActionDetailEntity> call, Response<SocialActionDetailEntity> response) {
                socialActionDetailEntity = response.body();
                if(socialActionDetailEntity != null){
                    socialActionDetailView.showDetails(socialActionDetailEntity);
                } else {
                    socialActionDetailView.showMessage("Falha ao carregar informações");
                }
                socialActionDetailView.hideLoading();
            }

            @Override
            public void onFailure(Call<SocialActionDetailEntity> call, Throwable t) {
                socialActionDetailView.hideLoading();
                socialActionDetailView.showMessage("Falha no acesso ao servidor");
            }
        });

    }
}
