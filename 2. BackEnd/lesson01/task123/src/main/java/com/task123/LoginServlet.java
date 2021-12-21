package com.task123;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out= response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if (username.equalsIgnoreCase("alexander")
        && password.equals("Orlov"))
        {
            String userName = request.getParameter("username");
            HttpSession session=request.getSession();
            session.setAttribute("username",  userName);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("dashboard.html");
            requestDispatcher.forward(request,response);
        }

        else {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("error.html");
            requestDispatcher.forward(request,response);
        }


    }
}
