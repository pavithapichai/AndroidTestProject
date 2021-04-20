package com.example.androidtestproject.ui.main.adapter;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidtestproject.R;
import com.example.androidtestproject.data.model.PopularMovie;
import com.example.androidtestproject.databinding.ListItemBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListViewHolder> {
    private List<PopularMovie> popularMovies =new ArrayList<>();

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBinding listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new MovieListViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        PopularMovie popularMovie = popularMovies.get(position);
        holder.listItemBinding.title.setText(popularMovie.title);
        loadImage(holder.listItemBinding.movieImageview,popularMovie.poster_path);
    }
  //  @BindingAdapter("imagePath")
    public static void loadImage(ImageView imageView, String imagePath) {
        String imageUrl ="https://image.tmdb.org/t/p/w500"+imagePath;
        if (imagePath != null) {
            Glide.with(imageView)
                    .load(imageUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView);
        } else {
            imageView.setImageDrawable(null);
        }
    }

    @Override
    public int getItemCount() {
        return popularMovies.size();
    }

    public void setList(List<PopularMovie> movies){
        popularMovies.clear();
        popularMovies.addAll(movies);

    }
}

class MovieListViewHolder extends RecyclerView.ViewHolder {
    ListItemBinding listItemBinding;

    public MovieListViewHolder(@NonNull ListItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.listItemBinding = itemBinding;
    }
}