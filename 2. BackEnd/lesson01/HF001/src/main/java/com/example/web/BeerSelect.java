package com.example.web;
import com.example.model.BeerExpert;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;


public class BeerSelect extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");
        String c = request.getParameter("color");

        BeerExpert be=new BeerExpert();
        List result=be.getBrands(c);

        request.setAttribute("styles", result);
        RequestDispatcher view =
                request.getRequestDispatcher("result.jsp");
        view.forward(request, response);

    }
}