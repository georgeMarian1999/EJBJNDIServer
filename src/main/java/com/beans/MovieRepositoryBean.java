package com.beans;

import com.model.Movie;
import com.repo.MovieRepository;
import com.repo.MovieRepositoryR;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(MovieRepository.class)
@Remote(MovieRepositoryR.class)
public class MovieRepositoryBean implements MovieRepository, MovieRepositoryR {


    @PersistenceContext(unitName = "movies")
    private EntityManager manager;

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        TypedQuery<Movie> query = manager.createQuery("select m from Movie m ", Movie.class);
        movies = query.getResultList();
//        try {
//
//            String sql = "select * from \"Movie\"";
//
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
        return movies;
    }

    @Override
    public int getMaxId() {
//        try {
//            if(con == null) {
//                connect();
//            }
//            Statement statement = con.createStatement();
//            String sql = "select max(id) as maxId from \"Movie\"";
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next()) {
//                return rs.getInt("maxId");
//            }
//        }catch (SQLException e) {
//            System.out.println(e);
//        }
        return 0;
    }

    @Override
    public Movie findById(int id) {
//        return
//            String sql = "select * from \"Movie\" where id="+id;
//
//
        return null;
    }

    @Override
    public Movie save(Movie movie) {
//            String sql = "insert into \"Movie\"(id,title,rating,genre) values ("+movie.getId()+","+"'"+movie.getTitle()+"'"+","+movie.getRating()+","+"'"+movie.getGenre()+"'"+")";
//            return movie;
        return movie;

    }




    @Override
    public void deleteById(Integer integer) {

            String sql = "delete from \"Movie\" where id = "+integer;

            System.out.println("Deleted from database with id "+integer);
    }


}
