package com.example.backend.controller;


import com.example.backend.entity.TypeOfProblemEntity;
import com.example.backend.service.TypeOfProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/typesofproblem")
public class TypeOfProblemController {

    @Autowired
    TypeOfProblemService typeOfProblemService;

    @GetMapping("/all")
    public List<TypeOfProblemEntity> getAllTypesOfProblem() {

        List<TypeOfProblemEntity>result=typeOfProblemService.getAll();

        return result;
    }

}
