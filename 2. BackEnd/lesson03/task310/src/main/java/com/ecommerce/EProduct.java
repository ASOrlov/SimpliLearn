package com.ecommerce;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EProduct {
    private long ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;
    private List<Color> colors;
    private Collection<ScreenSizes> screenSizes;
    private Set<OS> os;
    private Map finance;
}