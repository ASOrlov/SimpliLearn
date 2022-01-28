package edu.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "address")
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.everyone",query = "from Person")
})
public class Person {

    @Id
    @GeneratedValue
    //private Long PersonId;
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<PhoneNumber> numbers=new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber){
        numbers.add(phoneNumber);
    }
}
