package com.ecommerce;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Color {

    private long COLORID;
    private String name;


    public Color(String name) {
        this.COLORID = 0;
        this.name = name;
    }

}
