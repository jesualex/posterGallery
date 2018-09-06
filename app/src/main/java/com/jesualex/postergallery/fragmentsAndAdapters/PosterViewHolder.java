package com.jesualex.postergallery.fragmentsAndAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jesualex.postergallery.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
class PosterViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.posterImage) ImageView posterImage;

    View view;

    public PosterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        this.view = view;
    }
}
