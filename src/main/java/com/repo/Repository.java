package com.repo;

import com.model.Movie;

import java.util.List;

public interface Repository {
    void save(Movie movie);
    List<Movie> getAll();
}
