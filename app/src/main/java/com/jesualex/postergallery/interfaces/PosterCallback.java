package com.jesualex.postergallery.interfaces;

import android.widget.ImageView;

import com.jesualex.postergallery.database.entitys.Movie;

import java.util.List;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public interface PosterCallback {
    public void OnPosterClick(Movie movie, ImageView poster);
}
