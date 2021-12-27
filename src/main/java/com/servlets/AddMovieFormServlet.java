package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
@WebServlet("/addMovie")
public class AddMovieFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuilder contentBuilder = new StringBuilder();

        try {
            String str;
            BufferedReader in;
            String location = request.getRequestURL().toString().split("/")[3];
            URL index = new URL("http://localhost:8080/"+location+"/form.html");
            URLConnection yc = index.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            request.getRequestDispatcher("/errorMessage.html").forward(request, response);
        }
        String content = contentBuilder.toString();
        out.println(content);
        out.flush();
    }
}
