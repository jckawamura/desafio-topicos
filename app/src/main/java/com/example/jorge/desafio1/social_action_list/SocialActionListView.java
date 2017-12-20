package com.example.jorge.desafio1.social_action_list;

import com.example.jorge.desafio1.entity.SocialActionEntity;

import java.util.List;

/**
 * Created by elise on 20/12/2017.
 */

interface SocialActionListView {
    void updateList(List<SocialActionEntity> socialActionEntities);
    void showLoading();

    void hideLoading();

    void saveSocialActionSharedPreferences(String jsonSocialActionEntity);

    void showMessage(String s);
}
