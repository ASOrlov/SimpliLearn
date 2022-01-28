package edu.alex;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name="custompeople")
@Entity(name = "people")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "first",length = 50)
    private String firstName;

    private String lastName;

    @Column(unique = true, length = 250)
    private String email;


    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private LocalDate boa;

    @Transient
    int temp;


    public User() {

    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String email, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User(String firstName, String lastName, String email, Date birthDate, LocalDate boa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.boa = boa;
    }
}
