package com.servletsEJB;



import com.model.Movie;
import com.repo.MovieRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addMovieLogic")
public class AddServlet extends HttpServlet {

    @EJB
    private MovieRepository movieRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String title = request.getParameter("title");
            int rating = Integer.parseInt(request.getParameter("rating"));
            String genre = request.getParameter("genre");
            int id = movieRepository.getMaxId() + 1;
            Movie movie = new Movie(id,title,rating,genre);
            movieRepository.save(movie);
            System.out.println("New movie saved");
            request.getRequestDispatcher("/addSuccess").forward(request, response);

        }catch (Exception e){
            request.getRequestDispatcher("/error").forward(request, response);
        }

    }
}
