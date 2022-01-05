package com.servletsEJB;


import com.repo.ActorRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteActor")
public class DeleteActorServlet extends HttpServlet {

    @EJB
    private ActorRepository actorRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("deleteActorId");
            int ID = 0;
            if(id != null) {
                ID = Integer.parseInt(id);
            }
            else {
                request.getRequestDispatcher("/error").forward(request, response);
            }
            actorRepository.deleteById(ID);
            System.out.println("Actor with id "+id+" deleted");
            request.getRequestDispatcher("/").forward(request, response);

        }catch (Exception e){
            request.getRequestDispatcher("/").forward(request, response);
        }

    }
}
