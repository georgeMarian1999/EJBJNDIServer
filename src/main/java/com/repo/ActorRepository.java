package com.repo;

import com.model.Actor;
import com.model.Movie;

import java.util.List;

public interface ActorRepository  {
    List<Actor> getAll();
    Actor save(Actor a, int id_movie);
    void deleteById(Integer integer);
    List<Actor> getActorByMovieID(int movieID);
}
