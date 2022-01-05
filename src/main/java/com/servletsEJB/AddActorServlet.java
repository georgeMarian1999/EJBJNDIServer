package com.servletsEJB;



import com.model.Actor;
import com.repo.ActorRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addActorLogic")
public class AddActorServlet extends HttpServlet {

    @EJB
    private ActorRepository actorRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            int movieID = Integer.parseInt(request.getParameter("movieID"));
            int id = actorRepository.getMaxId() + 1;
            Actor actor = new Actor(id, name, age, gender);
            actorRepository.save(actor);
            request.setAttribute("name", null);
            request.getRequestDispatcher("/actors").forward(request, response);

        }catch (Exception e){
            request.getRequestDispatcher("/error").forward(request, response);
        }

    }
}
