package com.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = request.getParameter("destination");

        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String deleteID = request.getParameter("deleteId");

        RequestDispatcher rdAddMovie = request.getRequestDispatcher("/addMovie");
        RequestDispatcher rdAdd = request.getRequestDispatcher("/add");
        RequestDispatcher rdMovies = request.getRequestDispatcher("/movies");
        RequestDispatcher rdStatus = request.getRequestDispatcher("/status");
        RequestDispatcher rdDelete = request.getRequestDispatcher("/delete");

        RequestDispatcher rdSuccess = request.getRequestDispatcher("/successMessage.html");

        if (destination == null && (title == null || genre == null ) && deleteID == null) {
            String location = request.getRequestURL().toString().split("/")[3];
            response.sendRedirect("/"+location+"/");
        } else if (destination == null && deleteID == null) {
            System.out.println("Forwarding from dispatcher with request /add");
            rdAdd.forward(request, response);
        }
        else if (destination == null && (title == null || genre == null ) ) {
            System.out.println("Fowarding from dispatcher with request /delete");
            rdDelete.forward(request, response);
        }
        else {
            assert destination != null;
            if (destination.equals("st")) {
                System.out.println("Forwarding from servlet with destination " + destination);
                rdStatus.forward(request,response);
            }
            else if (destination.equals("mv")) {
                System.out.println("Forwarding from servlet with destination " + destination);
                rdMovies.forward(request, response);
            }
            else if (destination.equals("add")){
                System.out.println("Forwarding from servlet with destination " + destination);
                rdAddMovie.forward(request,response);
            }
            else if (destination.equals("home")){
                System.out.println("Forwarding from servlet with destination " + destination);
                String location = request.getRequestURL().toString().split("/")[3];
                response.sendRedirect("/"+location+"/");
            }
        }

    }
}
