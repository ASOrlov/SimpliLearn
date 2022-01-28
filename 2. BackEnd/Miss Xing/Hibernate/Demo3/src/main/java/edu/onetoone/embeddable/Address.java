package edu.onetoone.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//no entity
@Getter
@Setter
@Embeddable
public class Address {


    //no primary key generated this embeddable entity
    private String street;
    private String zipCode;

}
