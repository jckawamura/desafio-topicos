package com.example.jorge.desafio1.social_action_list;

import android.view.View;

/**
 * Created by elise on 20/12/2017.
 */

interface OnRecyclerViewSelected {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}
