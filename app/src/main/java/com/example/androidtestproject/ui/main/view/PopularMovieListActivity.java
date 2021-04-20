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

public class PopularMovieListActivity extends AppCompatActivity {
    private ActivityPopularMoviesListBinding popularMoviesListBinding;
    private MovieListAdapter movieListAdapter;
    private PopularMoviesViewModel popularMoviesViewModel;
    private PopularViewModelFactory viewModelFactory;
    private PopularMoviesRepository popularMoviesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popularMoviesListBinding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movies_list);
        popularMoviesRepository =new PopularMoviesRepository();
        viewModelFactory = new PopularViewModelFactory(popularMoviesRepository);
        popularMoviesViewModel = new ViewModelProvider(this,viewModelFactory).get(PopularMoviesViewModel.class);
        initRecyclerView();
    }

    public void initRecyclerView(){
        popularMoviesListBinding.moviesList.setLayoutManager(new GridLayoutManager(this,2));
        movieListAdapter =new  MovieListAdapter();
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
