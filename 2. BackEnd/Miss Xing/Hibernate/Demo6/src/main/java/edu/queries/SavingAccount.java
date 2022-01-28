package edu.queries;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@DiscriminatorValue("savings")
//@Entity
public class SavingAccount extends Account{

    private Double APY;

    public SavingAccount(double ballance, Double APY) {
        super(ballance);
        this.APY = APY;
    }
}
