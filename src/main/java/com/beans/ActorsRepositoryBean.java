package com.beans;

import com.model.Actor;
import com.model.Movie;
import com.repo.ActorRepository;
import com.repo.ActorRepositoryR;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(ActorRepository.class)
@Remote(ActorRepositoryR.class)
public class ActorsRepositoryBean implements ActorRepository, ActorRepositoryR {

    @PersistenceContext(unitName = "ejb")
    private EntityManager manager;

    @Override
    public List<Actor> getAll() {
        return null;
    }

    @Override
    public Actor save(Actor a, int id_movie) {
        Movie movie = manager.find(Movie.class, id_movie);
        if (movie != null) {
            //movie.addActor(a);
            a.setMovie(movie);
            manager.persist(movie);
            manager.persist(a);
        }
        return a;
    }

    @Override
    public List<Actor> getActorByMovieID(int movieID) {
        List<Actor> actors = new ArrayList<>();
        TypedQuery<Actor> query = manager.createQuery("select a from Actor a where a.movie.id_movie ="+movieID, Actor.class);
        actors = query.getResultList();
        return actors;
    }



    @Override
    public void deleteById(Integer integer) {
        Actor actor = manager.find(Actor.class, integer);
        if (actor != null) {
            Movie mov = manager.find(Movie.class, actor.getMovie().getId());
//            mov.deleteActor(actor);
//            manager.persist(mov);
            manager.remove(actor);
        }
    }

}
