package com.example.jorge.desafio1.social_action_detail;

import com.example.jorge.desafio1.entity.SocialActionDetailEntity;

/**
 * Created by Jorge on 17/12/2017.
 */

interface SocialActionDetailView {
    void showDetails(SocialActionDetailEntity socialActionDetailEntity);

    void showLoading();

    void showMessage(String msg);

    void hideLoading();
}
