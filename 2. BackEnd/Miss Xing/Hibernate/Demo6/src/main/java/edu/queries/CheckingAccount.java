package edu.queries;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@DiscriminatorValue("checking")
//@Entity
public class CheckingAccount extends Account{
    private Double overdraftLimit;

    public CheckingAccount(double ballance, Double overdraftLimit) {
        super(ballance);
        this.overdraftLimit = overdraftLimit;
    }
}
