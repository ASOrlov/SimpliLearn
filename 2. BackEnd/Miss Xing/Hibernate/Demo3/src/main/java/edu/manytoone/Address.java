package edu.manytoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@Entity
public class Address {

    @Id
    private Long id;
    private String street;
    private String zipCode;

    @ManyToOne
    //@JoinColumn(name = "person_id")
    @JoinTable(name = "person_address", joinColumns = {@JoinColumn(name = "person_id")}, inverseJoinColumns={@JoinColumn(name = "address_id")})
    private Person person;
}
