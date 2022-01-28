package com.ecommerce;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ScreenSizes {
    private long SCREENID;
    private String size;

    public ScreenSizes(String size) {
        this.SCREENID = 0;
        this.size = size;
    }

}