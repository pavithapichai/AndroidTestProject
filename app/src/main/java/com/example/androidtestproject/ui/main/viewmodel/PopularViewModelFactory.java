package com.example.androidtestproject.ui.main.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidtestproject.data.repository.PopularMoviesRepository;

import javax.inject.Inject;

public class PopularViewModelFactory implements ViewModelProvider.Factory {
    private PopularMoviesRepository popularMoviesRepository;
    @Inject
    public PopularViewModelFactory(PopularMoviesRepository repository) {
        this.popularMoviesRepository=repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(PopularMoviesViewModel.class))
            return (T) new PopularMoviesViewModel(popularMoviesRepository);
                throw new  IllegalArgumentException("Unknow class");
    }
}
