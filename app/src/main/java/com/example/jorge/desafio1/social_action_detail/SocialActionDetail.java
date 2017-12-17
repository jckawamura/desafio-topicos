package com.example.jorge.desafio1.social_action_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorge.desafio1.R;

public class SocialActionDetail extends AppCompatActivity implements SocialActionDetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_action_detail);
    }
}
