package com.repo;

import com.model.Actor;

import java.util.List;

public interface ActorRepositoryR  {
    List<Actor> getAll();
    Actor save(Actor m);
    int getMaxId();
    void deleteById(Integer integer);
    List<Actor> getActorByMovieID(int movieID);
}
