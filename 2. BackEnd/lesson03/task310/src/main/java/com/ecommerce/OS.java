package com.ecommerce;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class OS {

    private long OSID;
    private String name;


    public OS(String name) {
        this.OSID = 0;
        this.name = name;
    }
}