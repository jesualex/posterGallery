package com.jesualex.postergallery.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.database.entitys.Response;
import com.jesualex.postergallery.interfaces.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public class RetrofitUtils {
    private static RetrofitClient retrofitClient;

    private static RetrofitClient getRetrofitInstance(){
        if(retrofitClient == null){
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitClient.class);
        }

        return retrofitClient;
    }

    public static void getMovies(
            @NonNull final String orderBy,
            @NonNull final String apiKey
    ){
        Call<Response<Movie>> call = getRetrofitInstance().getMovies(orderBy, apiKey);

        call.enqueue(new Callback<Response<Movie>>() {
            @Override
            public void onResponse(@NonNull Call<Response<Movie>> call,
                                   @NonNull retrofit2.Response<Response<Movie>> response) {
                if(!response.isSuccessful() || response.body() == null){
                    switch (response.code()) {
                        case 401:
                            GeneralUtils.showToast(R.string.no_auth);
                            break;

                        default:
                            GeneralUtils.showToast(R.string.api_bad_response);
                            break;
                    }
                }else{
                    response.body().getResults();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Response<Movie>> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
                GeneralUtils.showToast(R.string.api_bad_response);
            }
        });
    }

}
