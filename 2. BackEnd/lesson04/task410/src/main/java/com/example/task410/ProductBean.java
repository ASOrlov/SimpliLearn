package com.example.task410;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class ProductBean implements Serializable{
    private String productId;
    private String productName;
    private double price;
}
