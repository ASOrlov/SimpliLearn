package com.example.final01;

import com.example.final01.model.Airline;
import com.example.final01.model.Airport;
import com.example.final01.model.MiniFlight;
import com.example.final01.util.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String login = request.getParameter("username");
            String password = request.getParameter("password");


            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));

            PreparedStatement preparedStatement  = conn.getConnection().prepareStatement("select * from users where login = ? and password = ? ");

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();


            Boolean success=rs.next();

            if (success) {
                HttpSession session = request.getSession();
                String userName = request.getParameter("username");
                session.setAttribute("username", userName);

                Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rst = stmt.executeQuery("select name from airlines");
                request.setAttribute("airlines",Airline.getAirlinesList(rst));
                rst = stmt.executeQuery("select name from airports");
                request.setAttribute("airports", Airport.getAirportsList(rst));
                rst = stmt.executeQuery("select * from miniflights");
                request.setAttribute("miniflights", MiniFlight.getMiniFlightsList(rst));


                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminDashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.html");
                requestDispatcher.forward(request, response);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

}





