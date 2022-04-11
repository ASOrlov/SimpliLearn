package com.example.final01.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Flight {
    private String departure;
    private String destination;
    private String airline;
    private int amount;
    private Timestamp departureDate;
    private Timestamp arrivalDate;
    private int id;

    public static ArrayList<Flight>getFlightsList(ResultSet rst) throws SQLException {

        ArrayList<Flight> flightArrayList=new ArrayList<>();

        while (rst.next()){

            Flight flight=new Flight();

            flight.amount=rst.getInt("amount");
            flight.id=rst.getInt("id");
            flight.departure=rst.getString("departure");
            flight.destination=rst.getString("destination");
            flight.airline=rst.getString("airline");

            flight.departureDate=rst.getTimestamp("departure_date");
            flight.arrivalDate=rst.getTimestamp("arrival_date");

            flightArrayList.add(flight);

        }
    return flightArrayList;
    }

}
