package com.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EProduct {
    private long ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;

    public EProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.dateAdded = new Date();
    }
}