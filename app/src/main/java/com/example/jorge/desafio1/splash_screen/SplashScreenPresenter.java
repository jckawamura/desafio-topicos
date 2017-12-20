package com.example.jorge.desafio1.splash_screen;

import android.os.Handler;
import android.widget.Toast;

import com.example.jorge.desafio1.entity.SocialActionListEntity;
import com.example.jorge.desafio1.network.DesafioApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jorge on 17/12/2017.
 */

class SplashScreenPresenter {

    SplashScreenView splashScreenView;

    public SplashScreenPresenter(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
    }

    public void start() {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // sem verificação de login
                final DesafioApi desafioApi = DesafioApi.getInstance();
                desafioApi
                        .getSocialActionList()
                        .enqueue(new Callback<SocialActionListEntity>() {
                            @Override
                            public void onResponse(Call<SocialActionListEntity> call, Response<SocialActionListEntity> response) {
                                splashScreenView.openSocialActionList();
                            }

                            @Override
                            public void onFailure(Call<SocialActionListEntity> call, Throwable t) {
                                // sem verificação de erros
                            }
                        });
            }
        }, 2000);
    }
}
