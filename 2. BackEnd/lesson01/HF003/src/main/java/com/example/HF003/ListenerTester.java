package com.example.HF003;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ListenerTester", value = "/ListenerTester")
public class ListenerTester extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("test context attributes set by listener<br>"); out.println("<br>");
        Dog dog = (Dog) getServletContext().getAttribute("dog");
        out.println("Dog\'s breed is: " + dog.getBreed());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
