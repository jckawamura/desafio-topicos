package com.example.jorge.desafio1.social_action_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jorge.desafio1.R;
import com.example.jorge.desafio1.entity.SocialActionEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialActionListAdapter extends RecyclerView.Adapter<SocialActionListAdapter.ViewHolder> {

    private List<SocialActionEntity> socialActionList;
    private Context context;
    OnRecyclerViewSelected onRecyclerViewSelected;

    public SocialActionListAdapter(List<SocialActionEntity> socialActionList, Context context) {
        this.socialActionList = socialActionList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.social_action_item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SocialActionListAdapter.ViewHolder holder, int position) {
        SocialActionEntity socialActionEntity = socialActionList.get(position);
        holder.tx_social_action_name.setText(socialActionEntity.getName());
        Picasso.with(context)
                .load(socialActionEntity.getImage())
                .centerCrop()
                .fit()
                .into(holder.img_social_action);
    }

    @Override
    public int getItemCount() {
        return socialActionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tx_social_action_name)
        TextView tx_social_action_name;

        @BindView(R.id.img_social_action)
        ImageView img_social_action;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        // clique rápido
        // ...
        // clique longo
        // ...
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
