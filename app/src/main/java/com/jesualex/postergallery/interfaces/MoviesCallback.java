package com.jesualex.postergallery.interfaces;

import android.support.annotation.Nullable;

import com.jesualex.postergallery.database.entitys.Movie;

import java.util.List;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public interface MoviesCallback {

    public void OnPostersLoadFinish(@Nullable List<Movie> movies);
}
