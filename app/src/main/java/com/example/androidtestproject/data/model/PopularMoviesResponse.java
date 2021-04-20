package com.example.androidtestproject.data.model;

import java.util.List;

public class PopularMoviesResponse {
    public int page;
    public List<PopularMovie> results;
    public int total_pages;
    public int total_results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<PopularMovie> getResults() {
        return results;
    }

    public void setResults(List<PopularMovie> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}

