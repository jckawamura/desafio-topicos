package com.example.jorge.desafio1.social_action_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jorge.desafio1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialActionList extends AppCompatActivity implements SocialActionListView {

    SocialActionListPresenter socialActionListPresenter;

    @BindView(R.id.rv_social_action)
    RecyclerView rv_social_action;

    @BindView(R.id.linear_layout_loading)
    LinearLayout loading_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_action_list);

        ButterKnife.bind(this);
        socialActionListPresenter = new SocialActionListPresenter(this);
        socialActionListPresenter.updateList();
    }

    @Override
    public void showLoading() {
        loading_layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading_layout.setVisibility(View.GONE);
    }
}
