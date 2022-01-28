package edu.compositeids;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String zipCode;

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "person_firstname", referencedColumnName ="firstName"),
            @JoinColumn(name = "person_lastname", referencedColumnName ="lastName")
    })

    private Person person;

}
