package com.example.final01.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Getter
@Setter
public class Airport {
    String name;

    public static ArrayList<Airport> getAirportsList(ResultSet rst) throws SQLException {

        ArrayList<Airport> airports=new ArrayList<>();

        while (rst.next()){
            Airport airport=new Airport();
            airport.name=rst.getString("name");
            airports.add(airport);

        }
        return airports;
    }
}
