package com.example.androidtestproject.ui.main.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.androidtestproject.R;
import com.example.androidtestproject.data.repository.PopularMoviesRepository;
import com.example.androidtestproject.databinding.ActivityPopularMoviesListBinding;
import com.example.androidtestproject.ui.main.adapter.MovieListAdapter;
import com.example.androidtestproject.ui.main.viewmodel.PopularMoviesViewModel;
import com.example.androidtestproject.ui.main.viewmodel.PopularViewModelFactory;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PopularMovieListActivity extends AppCompatActivity {
    private ActivityPopularMoviesListBinding popularMoviesListBinding;
    @Inject
     MovieListAdapter movieListAdapter;
     PopularMoviesViewModel popularMoviesViewModel;
     @Inject
     PopularViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popularMoviesListBinding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movies_list);
        popularMoviesViewModel = new ViewModelProvider(this,viewModelFactory).get(PopularMoviesViewModel.class);
        initRecyclerView();
    }

    public void initRecyclerView(){
        popularMoviesListBinding.moviesList.setLayoutManager(new GridLayoutManager(this,2));
        popularMoviesListBinding.moviesList.setAdapter(movieListAdapter);
        displayUserList();
    }
    private void displayUserList() {
        popularMoviesViewModel.getPopularMovies().observe(this, list->{
                movieListAdapter.setList(list.results);
                movieListAdapter.notifyDataSetChanged();

        });
    }
}
