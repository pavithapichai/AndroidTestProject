package com.example.androidtestproject.data.api;

import com.example.androidtestproject.data.model.PopularMoviesResponse;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MoviesAPI {
    @GET("movie/popular")
    Call<PopularMoviesResponse> getMoviesList(@Query("api_key") String api_key);
}
