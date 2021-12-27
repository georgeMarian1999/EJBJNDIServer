package com.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("deleteId");
            int ID = 0;
            if(id != null) {
                ID = Integer.parseInt(id);
            }
            else {
                request.getRequestDispatcher("/errorMessage.html").forward(request, response);
            }
//            JSONTemplate jsonTemplate = new JSONTemplate();
//            jsonTemplate.deleteMovie(ID);
            System.out.println("Movie with id "+id+" deleted");
            request.getRequestDispatcher("/successDeleteMessage.html").forward(request, response);

        }catch (Exception e){
            request.getRequestDispatcher("/errorMessage.html").forward(request, response);
        }

    }
}
