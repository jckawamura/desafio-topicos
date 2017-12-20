package com.example.jorge.desafio1.social_action_list;

import com.example.jorge.desafio1.entity.SocialActionEntity;
import com.example.jorge.desafio1.entity.SocialActionListEntity;
import com.example.jorge.desafio1.network.DesafioApi;

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
    private List<SocialActionEntity> socialActionEntityList = new ArrayList<>();
    SocialActionListEntity socialActionListEntity;

    SocialActionListPresenter(SocialActionListView socialActionListView) {
        this.socialActionListView = socialActionListView;
    }

    public void updateList() {
        final DesafioApi desafioApi = DesafioApi.getInstance();
        socialActionListView.showLoading();

        desafioApi.get().enqueue(new Callback<MovieListEntity>() {
            @Override
            public void onResponse(Call<MovieListEntity> call, Response<MovieListEntity> response) {
                movieListEntity = response.body();
                if(movieListEntity != null){
                    moviesView.updateList(movieListEntity.getMovies());
                } else{
                    moviesView.showMessage("Falha no login");
                }
                moviesView.hideLoading();
            }

            @Override
            public void onFailure(Call<MovieListEntity> call, Throwable t) {
                moviesView.hideLoading();
                moviesView.showMessage("Falha no acesso ao servidor");
            }
        });
    }
}
