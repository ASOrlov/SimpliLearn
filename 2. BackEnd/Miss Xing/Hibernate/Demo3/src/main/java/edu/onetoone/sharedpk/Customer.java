package edu.onetoone.sharedpk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Address address;

}
