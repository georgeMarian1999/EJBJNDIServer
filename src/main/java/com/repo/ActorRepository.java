package com.repo;

import com.model.Actor;
import com.model.Movie;

import java.util.List;

public interface ActorRepository  {
    List<Actor> getAll();
    Actor save(Actor m);
    int getMaxId();
    void deleteById(Integer integer);
    List<Actor> getActorByMovieID(int movieID);
}
