package edu.onetoone.joincolumn;

import edu.onetoone.joincolumn.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    //@JoinColumn(name = "addr_id")
    private Address address;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
