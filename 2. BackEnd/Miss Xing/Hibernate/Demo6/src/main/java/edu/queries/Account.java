package edu.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@NoArgsConstructor
@Setter
@Getter
//@Entity
public abstract class Account {

    @Id
    @GeneratedValue
    private Long id;
    private double ballance;

    public Account(double ballance) {
        this.ballance = ballance;
    }
}
