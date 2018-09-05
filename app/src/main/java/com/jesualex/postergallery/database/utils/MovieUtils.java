package com.jesualex.postergallery.database.utils;

import com.jesualex.postergallery.App;
import com.jesualex.postergallery.database.entitys.Movie;

import io.objectbox.Box;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public class MovieUtils {
    private static Box<Movie> box = App.getBoxStoreInstance().boxFor(Movie.class);
}
