package edu.singletable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
//@Entity
@DiscriminatorValue(value = "2")
public class Savings extends Account{

    Double interest;

    public Savings(Double balance, Double interest) {
        super(balance);
        this.interest = interest;
    }
}
