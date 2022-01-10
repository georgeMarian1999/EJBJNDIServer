package com.beans;

import com.model.Actor;
import com.model.Movie;
import com.repo.MovieRepository;
import com.repo.MovieRepositoryR;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local(MovieRepository.class)
@Remote(MovieRepositoryR.class)
public class MovieRepositoryBean implements MovieRepository, MovieRepositoryR {


    @PersistenceContext(unitName = "ejb")
    private EntityManager manager;

    @Override
    public List<Movie> getAll() {
        List<Movie> movies;
        TypedQuery<Movie> query = manager.createQuery("select m from Movie m ", Movie.class);
        movies = query.getResultList();
        return movies;
    }

    @Override
    public Movie findById(int id) {
        return manager.find(Movie.class, id);
    }

    @Override
    public Movie save(Movie movie) {
        manager.persist(movie);
        return movie;
    }

    @Override
    public void deleteById(Integer integer) {
        Movie movie = findById(integer);
        TypedQuery<Actor> query = manager.createQuery("select a from Actor a where a.movie.id_movie = " +integer, Actor.class);
        List<Actor> actors = query.getResultList();
        for(Actor a: actors) {
            manager.remove(a);
        }
        if (movie != null) {
            manager.remove(movie);
        }
    }


}
