package com.example.final01;

import com.example.final01.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "ChangePassword", value = "/ChangePassword")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            HttpSession httpSession= request.getSession(false);
            String login = (String) httpSession.getAttribute("username");
            String oldpassword = request.getParameter("oldpassword");
            String newpassword = request.getParameter("newpassword");

            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));

            PreparedStatement preparedStatementSelect  = conn.getConnection().prepareStatement("select id from users where login = ? and password = ? ");

            preparedStatementSelect.setString(1, login);
            preparedStatementSelect.setString(2, oldpassword);

            ResultSet rs = preparedStatementSelect.executeQuery();

            if (rs.next()) {
                PreparedStatement preparedStatementUpdate  = conn.getConnection().prepareStatement("update users set password=? where id = ?");
                preparedStatementUpdate.setString(1, newpassword);
                preparedStatementUpdate.setInt(2,rs.getInt("id"));
                preparedStatementUpdate.executeUpdate();

                preparedStatementSelect.close();
                preparedStatementUpdate.close();
                conn.closeConnection();

                PrintWriter out=response.getWriter();
                out.println("<html><body><h1>");
                out.println("Password changed Successful");
                out.println("</h1></body></html>");

            } else {
                preparedStatementSelect.close();
                conn.closeConnection();
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
