package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/webapitwo")
public class HobbyController {

    @Autowired
    HobbyService hobbyService;

    @GetMapping("/hobby/{personid}")
    public String findByPersonId(@PathVariable int personid){
        return hobbyService.findByPersonId(personid);
    }

    @PostMapping("/hobby")
    public void addHobby(@RequestBody HobbyEntity he ) {
        hobbyService.addHobby(he);
    }

}

