package com.example.jorge.desafio1.social_action_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorge.desafio1.R;
import com.example.jorge.desafio1.entity.SocialActionDetailEntity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialActionDetail extends AppCompatActivity implements SocialActionDetailView {
    SocialActionDetailPresenter socialActionDetailPresenter;

    @BindView(R.id.image_view_header)
    ImageView imgHeader;

    @BindView(R.id.text_view_description)
    TextView tvDescription;

    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_action_detail);
        ButterKnife.bind(this);

        // opção de Up Action na ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        long socialActionId = intent.getLongExtra("id", -1);

        socialActionDetailPresenter = new SocialActionDetailPresenter(this);
        socialActionDetailPresenter.getSocialActionDetail(socialActionId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_download:
                Toast.makeText(this, getString(R.string.action_download), Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showDetails(SocialActionDetailEntity socialActionDetailEntity) {
        tvDescription.setText(socialActionDetailEntity.getDescription());
        Picasso.with(this)
                .load(socialActionDetailEntity.getImage())
                .centerCrop()
                .fit()
                .into(imgHeader);
        setTitle(socialActionDetailEntity.getName());
    }

    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
