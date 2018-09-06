package com.jesualex.postergallery.database.utils;

import android.support.annotation.Nullable;

import com.jesualex.postergallery.App;
import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.utils.Constants;
import com.jesualex.postergallery.utils.RetrofitUtils;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public class MovieUtils {
    private static Box<Movie> box = App.getBoxStoreInstance().boxFor(Movie.class);
    private static Query<Movie> queryAll;

    private static final String POPULAR_KEY = "popular";
    private static final String TOP_RATED_KEY = "top_rated";

    public static Query<Movie> getQueryAll() {
        if(queryAll == null)
            queryAll = box.query().build();

        return queryAll;
    }

    public static void updateByPopular(){
        RetrofitUtils.getMovies(POPULAR_KEY, Constants.DEFAULT_API_KEY, movies -> {
            box.removeAll();
            box.put(movies);
        });
    }

    public static void updateByTopRated(){
        RetrofitUtils.getMovies(TOP_RATED_KEY, Constants.DEFAULT_API_KEY, movies -> {
            box.removeAll();
            box.put(movies);
        });
    }

    public static @Nullable Movie get(long id){
        return id > 0 || id < -1 ? box.get(id) : null;
    }
}
