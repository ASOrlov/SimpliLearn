package edu.manytoone;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
//@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String firstName;

    private String lastName;
}
