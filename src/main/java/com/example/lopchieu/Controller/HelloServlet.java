package com.example.lopchieu.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firsName =  req.getParameter("firsName");
        String lastName = req.getParameter("lastName");
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
