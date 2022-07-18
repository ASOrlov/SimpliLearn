package com.example.test;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/webapione")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person/{personId}")
    public PersonResponse getPerson(@PathVariable int personId){
        return personService.getPerson(personId);
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody PersonEntity pe ) {
        personService.addPerson(pe);
    }
}

