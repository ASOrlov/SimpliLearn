package edu.onetoone.embeddable;

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


    @Embedded
    private  Address address;
}
