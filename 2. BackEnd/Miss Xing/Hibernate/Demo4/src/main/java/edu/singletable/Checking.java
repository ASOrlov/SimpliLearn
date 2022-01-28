package edu.singletable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
//@Entity
@DiscriminatorValue(value = "1")
public class Checking extends Account{

    @Column(name = "[limit]")
    private Double limit;

    public Checking(Double balance, Double limit) {
        super(balance);
        this.limit = limit;
    }
}
