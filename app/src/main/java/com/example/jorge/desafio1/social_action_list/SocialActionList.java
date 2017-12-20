package com.example.jorge.desafio1.social_action_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.jorge.desafio1.R;

import butterknife.BindView;

public class SocialActionList extends AppCompatActivity implements SocialActionListView {

    SocialActionListPresenter socialActionListPresenter;

    @BindView(R.id.rv_social_action)
    RecyclerView rv_social_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_action_list);
    }
}
