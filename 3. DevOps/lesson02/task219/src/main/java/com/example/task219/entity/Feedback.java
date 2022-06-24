package com.example.task219.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue
    private Long id;

    String description;


    public Feedback(String description) {
        this.description = description;
    }
}
