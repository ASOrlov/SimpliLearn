package com.example.final01;

import com.example.final01.model.Flight;
import com.example.final01.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;

@WebServlet(name = "GetFlightInformation", value = "/GetFlightInformation")
public class GetFlightInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Integer numberOfPerson = Integer.parseInt(request.getParameter("number"));
            String placeOfDeparture=request.getParameter("departure");
            String placeOfDestination=request.getParameter("destination");

            String dateOfFlight=request.getParameter("dateofflight");
            LocalDate localDate=LocalDate.parse(dateOfFlight);
            LocalDateTime startOfDay = LocalDateTime.of(localDate, LocalTime.MIN);
            LocalDateTime endOfDay = LocalDateTime.of(localDate, LocalTime.MAX);

            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);

            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));


            CallableStatement stmtCallable = conn.getConnection().prepareCall("{call get_flights(?,?,?,?,?)}");
            stmtCallable.setString(1, placeOfDeparture);
            stmtCallable.setString(2, placeOfDestination);
            stmtCallable.setInt(3, numberOfPerson);
            stmtCallable.setTimestamp(4,java.sql.Timestamp.valueOf(startOfDay));
            stmtCallable.setTimestamp(5, java.sql.Timestamp.valueOf(endOfDay));

            ResultSet rst=stmtCallable.executeQuery();

            ArrayList<Flight> flightArrayList=Flight.getFlightsList(rst);

            stmtCallable.close();
            conn.closeConnection();

            request.setAttribute("sRes",flightArrayList );


            RequestDispatcher view =
                    request.getRequestDispatcher("searchResult.jsp");
            view.forward(request, response);







        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

