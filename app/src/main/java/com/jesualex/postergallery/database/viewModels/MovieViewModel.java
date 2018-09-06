package com.jesualex.postergallery.database.viewModels;

import android.arch.lifecycle.ViewModel;

import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.database.utils.MovieUtils;

import io.objectbox.android.ObjectBoxLiveData;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public class MovieViewModel extends ViewModel{
    public ObjectBoxLiveData<Movie> getAllMovies(){
        return new ObjectBoxLiveData<>(MovieUtils.getQueryAll());
    }
}
