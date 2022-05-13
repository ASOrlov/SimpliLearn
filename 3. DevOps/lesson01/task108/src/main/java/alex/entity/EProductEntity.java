package alex.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EProductEntity {

    private long ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;

}
