package com.example.androidtestproject.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.androidtestproject.data.api.MoviesAPI;
import com.example.androidtestproject.data.api.RetrofitInstance;
import com.example.androidtestproject.data.model.PopularMoviesResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMoviesRepository {
    private MutableLiveData<PopularMoviesResponse> popularMoviesResponseMutableLiveData;
    private  MoviesAPI moviesAPI;
    public final String API_KEY="bb78e4cf3442e302d928f2c5edcdbee1";

    public PopularMoviesRepository() {
        moviesAPI = new RetrofitInstance().retrofitService().create(MoviesAPI.class);
        popularMoviesResponseMutableLiveData = new MutableLiveData<>();

    }

    public MutableLiveData<PopularMoviesResponse> getPopularMovies() {
        moviesAPI.getMoviesList(API_KEY).enqueue(new Callback<PopularMoviesResponse>() {
            @Override
            public void onResponse(@NotNull Call<PopularMoviesResponse> call, @NotNull Response<PopularMoviesResponse> response) {
                popularMoviesResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<PopularMoviesResponse> call, @NotNull Throwable t) {

            }
        });
        return popularMoviesResponseMutableLiveData;
    }
}
