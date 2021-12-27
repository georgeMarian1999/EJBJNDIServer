package com.repo;

import com.model.Movie;

import java.util.List;

public interface RepositoryR {
    void save(Movie movie);
    List<Movie> getAll();
}
