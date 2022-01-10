package com.servletsEJB;


import com.repo.MovieRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {

    @EJB
    private MovieRepository movieRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("deleteMovieId");
            int ID = 0;
            System.out.println(id);
            if(id != null) {
                ID = Integer.parseInt(id);
            }
            else {
                request.getRequestDispatcher("/error").forward(request, response);
            }
            movieRepository.deleteById(ID);
            System.out.println("Movie with id "+id+" deleted");
            request.getRequestDispatcher("/").forward(request, response);

        }catch (Exception e){
            request.getRequestDispatcher("/").forward(request, response);
        }

    }
}
