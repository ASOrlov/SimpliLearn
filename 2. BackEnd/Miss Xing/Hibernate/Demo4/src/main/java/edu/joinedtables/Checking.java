package edu.joinedtables;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
//@Entity

public class Checking extends Account {

    @Column(name = "[limit]")
    private Double limit;

    public Checking(Double balance, Double limit) {
        super(balance);
        this.limit = limit;
    }
}
