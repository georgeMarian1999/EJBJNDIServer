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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(ActorRepository.class)
@Remote(ActorRepositoryR.class)
public class ActorsRepositoryBean implements ActorRepository, ActorRepositoryR {

//    @PersistenceContext(unitName = "postgresqlUnit")
//    private EntityManager manager;



    @Override
    public List<Actor> getAll() {
        return null;
    }

    @Override
    public Actor save(Actor m) {
//        try {
//            if(con == null) {
//
//            }
//            Statement statement = con.createStatement();
//            String sql = "insert into \"Actor\"(id,name,age,gender,movieid) values ("+m.getId()+","+"'"+m.getName()+"'"+","+m.getAge()+","+"'"+m.getGender()+"'"+","+m.getMovieID()+")";
//            System.out.println(sql);
//            ResultSet rs = statement.executeQuery(sql);
//            return m;
//        }catch (SQLException e) {
//            System.out.println(e);
//        }
        return m;
    }

    @Override
    public int getMaxId() {
//        try {
//            if(con == null) {
//                connect();
//            }
//            Statement statement = con.createStatement();
//            String sql = "select max(id) as maxId from \"Actor\"";
//            ResultSet rs = statement.executeQuery(sql);
//            if(rs.next()) {
//                return rs.getInt("maxId");
//            }
//            else return 0;
//        }catch (SQLException e) {
//            System.out.println(e);
//        }
        return 0;
    }

    @Override
    public List<Actor> getActorByMovieID(int movieID) {
        List<Actor> actors = new ArrayList<>();
//        try {
//            if(con == null) {
//                connect();
//            }
//            Statement statement = con.createStatement();
//            String sql = "select id,name,age,gender from \"Actor\" where movieid = "+movieID;
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name  = rs.getString("name");
//                int age = rs.getInt("age");
//                String gender = rs.getString("gender");
//                Actor actor = new Actor(id, name, age, gender, movieID);
//                actors.add(actor);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
        return actors;
    }



    @Override
    public void deleteById(Integer integer) {
//        try {
//            if(con == null) {
//                connect();
//            }
//            Statement statement = con.createStatement();
//            String sql = "delete from \"Actor\" where id = "+integer;
//
//            statement.executeQuery(sql);
//            System.out.println("Deleted actor from database with id "+integer);
//        }catch (SQLException e) {
//            System.out.println(e);
//        }
    }

}
