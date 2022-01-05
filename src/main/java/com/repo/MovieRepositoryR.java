package com.repo;

import com.model.Movie;

import java.util.List;

public interface MovieRepositoryR  {
    List<Movie> getAll();
    int getMaxId();
    void deleteById(Integer integer);
    Movie findById(int id);
}
