package com.jesualex.postergallery.interfaces;

import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.database.entitys.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public interface RetrofitClient {

    @GET("3/movie/{orderBy}")
    Call<Response<Movie>> getMovies(
            @Path("orderBy") String orderBy,
            @Query("api_key") String apiKey
    );
}
