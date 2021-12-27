package com.beans;

import com.model.Movie;
import com.repo.Repository;
import com.repo.RepositoryR;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Stateless
@Local(Repository.class)
@Remote(RepositoryR.class)
public class RepositoryBean implements Repository, RepositoryR {
    private static SessionFactory sessionFactory;

    public RepositoryBean() {
        //initialize();
    }
    public void close() {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }


    static void initialize() {
            // A SessionFactory is set up once for an application!
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                System.out.println("Exceptie "+e);
                StandardServiceRegistryBuilder.destroy(registry);
            }
    }



    @Override
    public void save(Movie movie) {

    }

    @Override
    public List<Movie> getAll() {
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            String hql="SELECT new Movie(M.id, M.title, M.rating, M.genre) FROM Movie M";
            Query query=session.createQuery(hql);
            List result=query.getResultList();
            List<Movie> movies=new ArrayList<>();
            for (Object object: result
                 ) {
                movies.add((Movie) object);
            }
            return  movies;
        }
    }
}
