package com.example.final01.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Getter
@Setter
public class MiniFlight {
    String source;
    String destination;
    String price;
    String airline;

    public static ArrayList<MiniFlight> getMiniFlightsList(ResultSet rst) throws SQLException {

        ArrayList<MiniFlight> miniFlights=new ArrayList<>();

        while (rst.next()){
            MiniFlight miniFlight=new MiniFlight();
            miniFlight.source=rst.getString("source");
            miniFlight.destination=rst.getString("destination");
            miniFlight.airline=rst.getString("airline");
            miniFlight.price=rst.getString("price");

            miniFlights.add(miniFlight);

        }
        return miniFlights;
    }
}
