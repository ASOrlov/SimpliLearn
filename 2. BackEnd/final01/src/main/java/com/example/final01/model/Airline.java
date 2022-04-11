package com.example.final01.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Getter
@Setter
public class Airline {
    String name;

    public static ArrayList<Airline> getAirlinesList(ResultSet rst) throws SQLException {

        ArrayList<Airline> airlines=new ArrayList<>();

        while (rst.next()){
            Airline airline=new Airline();
            airline.name=rst.getString("name");
            airlines.add(airline);

        }
        return airlines;
    }

}
