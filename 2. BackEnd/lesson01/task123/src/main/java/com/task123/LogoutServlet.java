package com.task123;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();
        HttpSession httpSession= request.getSession(false);


        out.println("<html><body>");
        out.println("<h2>Bye "+httpSession.getAttribute("username")+" </h2>");
        out.println("</body></html>");


        httpSession.invalidate();
    }
}
