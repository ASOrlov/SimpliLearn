package com.ecommerce;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class EProduct {
    private long ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;

    public EProduct(long id, String name, BigDecimal price, Date dateAdded) {
        this.ID = id;
        this.name = name;
        this.price = price;
        this.dateAdded = dateAdded;
    }
}