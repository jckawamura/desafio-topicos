package com.example.jorge.desafio1.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jorge.desafio1.R;
import com.example.jorge.desafio1.social_action_list.SocialActionList;

public class SplashScreen extends AppCompatActivity implements SplashScreenView {
    SplashScreenPresenter splashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreenPresenter.start();
    }

    @Override
    public void openSocialActionList() {
        Intent intent = new Intent(SplashScreen.this, SocialActionList.class);
        startActivity(intent);
    }
}
