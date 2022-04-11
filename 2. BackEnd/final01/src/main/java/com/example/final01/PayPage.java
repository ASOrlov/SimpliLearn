package com.example.final01;

import com.example.final01.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "PayPage", value = "/PayPage")
public class PayPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);

            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));


            CallableStatement stmtCallable = conn.getConnection().prepareCall("{call add_order(?,?,?)}");

            Integer flightID = Integer.parseInt(request.getParameter("flightid"));
            String cardNumber=request.getParameter("cardnumber");
            String[] passengers=request.getParameterValues("passenger");

            for (String passenger : passengers) {
                stmtCallable.setInt(1, flightID);
                stmtCallable.setString(2, cardNumber);
                stmtCallable.setString(3, passenger);
                stmtCallable.executeUpdate();
            }

            stmtCallable.close();
            conn.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Congratulations! Your ticket(s) paid successful<h1>");
        out.println("</html></body>");
    }
}
