package com.ecommerce.web;

import com.ecommerce.model.EProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllProducts", value = "/ShowAllProducts")
public class ShowAllProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        List<EProduct> result = session.createQuery("from EProduct").list();
        session.close();

        request.setAttribute("products", result);
        RequestDispatcher view =
                request.getRequestDispatcher("productlist.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
