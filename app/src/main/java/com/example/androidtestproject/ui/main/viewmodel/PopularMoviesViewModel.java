package com.example.androidtestproject.ui.main.viewmodel;

import android.util.Patterns;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidtestproject.data.model.PopularMoviesResponse;
import com.example.androidtestproject.data.repository.PopularMoviesRepository;
import com.example.androidtestproject.utils.Event;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PopularMoviesViewModel extends ViewModel  {

    private  MutableLiveData<PopularMoviesResponse> moviesData;
    @Inject
    public PopularMoviesViewModel(PopularMoviesRepository popularMoviesRepository) {
        moviesData = popularMoviesRepository.getPopularMovies();
    }

    public LiveData<PopularMoviesResponse> getPopularMovies() {
        return moviesData;
    }



}
