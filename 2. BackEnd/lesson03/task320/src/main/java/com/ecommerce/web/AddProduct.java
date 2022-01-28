package com.ecommerce.web;

import com.ecommerce.model.EProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        try {
            String name=request.getParameter("username");
            BigDecimal price=new BigDecimal(request.getParameter("price"));
            if (name.equals("")||price==BigDecimal.ZERO) throw new Exception();

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            Transaction transaction=session.beginTransaction();
            EProduct eProduct=new EProduct(name,price);
            session.save(eProduct);
            transaction.commit();

            session.close();

            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");
            requestDispatcher.forward(request,response);
        }

        catch (Exception e) {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("error.html");
            requestDispatcher.forward(request,response);
        }

    }
}
