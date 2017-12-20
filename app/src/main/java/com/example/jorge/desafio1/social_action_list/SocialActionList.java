package com.example.jorge.desafio1.social_action_list;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jorge.desafio1.R;
import com.example.jorge.desafio1.entity.SocialActionEntity;
import com.example.jorge.desafio1.social_action_detail.SocialActionDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialActionList extends AppCompatActivity implements SocialActionListView {

    SocialActionListPresenter socialActionListPresenter;

    @BindView(R.id.rv_social_action)
    RecyclerView rv_social_action;

    @BindView(R.id.linear_layout_loading)
    LinearLayout loading_layout;


    //private List<SocialActionEntity> socialActionEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_action_list);

        ButterKnife.bind(this);


        /*
        rv_social_action.setAdapter(new SocialActionListAdapter(socialActionEntities, this));
        rv_social_action.setLayoutManager(new LinearLayoutManager(this));
        */

        socialActionListPresenter = new SocialActionListPresenter(this);
        socialActionListPresenter.updateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_download:
                // salvar detalhes em SharedPreferences
                socialActionListPresenter.saveSocialActions();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateList(final List<SocialActionEntity> socialActionEntities) {

        // configura o adapter
        SocialActionListAdapter socialActionListAdapter = new SocialActionListAdapter(socialActionEntities, this);
        socialActionListAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(SocialActionList.this, SocialActionDetail.class);
                intent.putExtra("id", socialActionEntities.get(position).getId());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(SocialActionList.this, "Clique para ver mais detalhes", Toast.LENGTH_SHORT).show();
            }
        });

        rv_social_action.setAdapter(socialActionListAdapter);

        // gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(this, layoutManager.getOrientation());
        rv_social_action.setLayoutManager(layoutManager);
        rv_social_action.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void showLoading() {
        loading_layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading_layout.setVisibility(View.GONE);
    }

    @Override
    public void saveSocialActionSharedPreferences(String jsonSocialActionEntity) {

        SharedPreferences.Editor editor =
                getSharedPreferences("social_action_json", MODE_PRIVATE).edit();

        editor.putString("social_action_entity", jsonSocialActionEntity);

        editor.apply();

        showMessage("Informações salvas com sucesso");
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}

